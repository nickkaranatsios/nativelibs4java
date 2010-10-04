/*
 * ScalaCL - putting Scala on the GPU with JavaCL / OpenCL
 * http://scalacl.googlecode.com/
 *
 * Copyright (c) 2009-2010, Olivier Chafik (http://ochafik.free.fr/)
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *     * Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the distribution.
 *     * Neither the name of Olivier Chafik nor the
 *       names of its contributors may be used to endorse or promote products
 *       derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY OLIVIER CHAFIK AND CONTRIBUTORS ``AS IS'' AND ANY
 * EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE REGENTS AND CONTRIBUTORS BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package scalacl

import scala.collection.immutable.Stack
import scala.reflect.generic.Names
import scala.reflect.generic.Trees
import scala.tools.nsc.Global
import scala.tools.nsc.plugins.Plugin
import scala.tools.nsc.symtab.Definitions

/**
 * http://www.scala-lang.org/node/140
 * http://lamp.epfl.ch/~emir/bqbase/2005/06/02/nscTutorial.html
 * http://code.google.com/p/simple-build-tool/wiki/CompilerPlugins
 * mvn scala:run -DmainClass=scalacl.Compile "-DaddArgs=-d|out|src/main/examples/BasicExample.scala|-Xprint:scalaclfunctionstransform"
 * scala -cp target/scalacl-compiler-1.0-SNAPSHOT-shaded.jar scalacl.Main -d out src/examples/BasicExample.scala
 * javap -c -classpath out/ scalacl.examples.BasicExample
 */
class ScalaCLPlugin(val global: Global) extends Plugin {
  override val name = "ScalaCL Optimizer"
  override val description =
    "This plugin transforms some Scala functions into OpenCL kernels (for CLCol[T].map and filter's arguments), so they can run on a GPU.\n" +
  "It will also soon feature autovectorization of ScalaCL programs, detecting parallelizable loops and unnecessary collection creations."

  val runsAfter = List[String]("namer")//refchecks")

  lazy val explicitelyDisabled = "1".equals(System.getenv("DISABLE_SCALACL_PLUGIN")) || "true".equals(System.getProperty("scalacl.plugin.disable"))

  var enabled = !explicitelyDisabled
  var arrayLoopsEnabled = true
  var intRangeForeachEnabled = true
  override def processOptions(options: List[String], error: String => Unit) {
    for (option <- options) {
      println("Found option " + option)
      option match {
        case "disable" => enabled = false
        case "enable" => enabled = true
        case "arrayLoops:enable" => arrayLoopsEnabled = true
        case "arrayLoops:disable" => arrayLoopsEnabled = false
        case "intRangeForeach:enable" => intRangeForeachEnabled = true
        case "intRangeForeach:disable" => intRangeForeachEnabled = false
        case _ => error("Unknown option: " + option)
      }
    }
  }
  override val optionsHelp: Option[String] = Some(
"""
-P:scalacl:enable                   Enable ScalaCL's Compiler Plugin
-P:scalacl:disable                  Disable ScalaCL's Compiler Plugin
-P:scalacl:arrayLoops:enable        Enable transformation of Array[T].foreach and Array[T].map calls to while loops
-P:scalacl:arrayLoops:disable     Disable transformation of Array[T].foreach and Array[T].map calls to while loops
-P:scalacl:intRangeForeach:enable   Enable transformation of int range foreach loops (in the model of 'for (i <- a to/until b by c) body') to while loops
-P:scalacl:intRangeForeach:disable  Disable transformation of int range foreach loops (in the model of 'for (i <- a to/until b by c) body') to while loops
""".trim
  )

  override val components = if (enabled)
    List(
      new ScalaCLFunctionsTransformComponent(global),
      if (intRangeForeachEnabled) new RangeForeach2WhileTransformComponent(global) else null,
      if (arrayLoopsEnabled) new ArrayLoopsTransformComponent(global) else null
    ).filter(_ != null)
  else
    Nil
}

object ScalaCLPlugin {
  def components(global: Global) = List(
    new ScalaCLFunctionsTransformComponent(global),
    new RangeForeach2WhileTransformComponent(global),
    new ArrayLoopsTransformComponent(global)
  )
}
