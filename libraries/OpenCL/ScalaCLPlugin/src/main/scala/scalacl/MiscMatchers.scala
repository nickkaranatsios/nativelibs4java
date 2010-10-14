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

import scala.tools.nsc.Global

trait MiscMatchers {
  val global: Global
  import global._
  import definitions._
  import treeInfo.{ methPart }
  
  /** Strips apply nodes looking for type application. */
  def typeArgs(tree: Tree): List[Tree] = tree match {
    case Apply(fn, _)              => typeArgs(fn)
    case TypeApply(fn, args)       => args
    case AppliedTypeTree(fn, args) => args
    case _                         => Nil
  }
  /** Smashes directly nested applies down to catenate the argument lists. */
  def flattenApply(tree: Tree): List[Tree] = tree match {
    case Apply(fn, args)  => flattenApply(fn) ++ args
    case _                => Nil
  }
  def flattenApplyGroups(tree: Tree): List[List[Tree]] = tree match {
    case Apply(fn, args)  => flattenApplyGroups(fn) ++ List(args)
    case _                => Nil
  }
  /** Smashes directly nested selects down to the inner tree and a list of names. */
  def flattenSelect(tree: Tree): (Tree, List[Name]) = tree match {
    case Select(qual, name) => flattenSelect(qual) match { case (t, xs) => (t, xs :+ name) }
    case _                  => (tree, Nil)
  }
  /** Creates an Ident or Select from a list of names. */
  def mkSelect(names: Name*): Tree = names.toList match {
    case Nil        => EmptyTree
    case x :: Nil   => Ident(x)
    case x :: xs    => xs.foldLeft(Ident(x): Tree)(Select(_, _))
  }

  class Ids(start: Long = 1) {
    private var nx = start
    def next = this.synchronized {
      val v = nx
      nx += 1
      v
    }
  }
  
  class N(val s: String) {
    def unapply(n: Name): Boolean = n.toString == s
  }
  object N {
    def apply(s: String) = new N(s)
  }
  implicit def N2Name(n: N) = newTermName(n.s)
  
  val scalaName = N("scala")
  val ArrayName = N("Array")
  val intWrapperName = N("intWrapper")
  val tabulateName = N("tabulate")
  val toName = N("to")
  val byName = N("by")
  val withFilterName = N("withFilter")
  val untilName = N("until")
  val isEmptyName = N("isEmpty")
  val sumName = N("sum")
  val headName = N("head")
  val tailName = N("tail")
  val foreachName = N("foreach")
  val foldLeftName = N("foldLeft")
  val foldRightName = N("foldRight")
  val reduceLeftName = N("reduceLeft")
  val reduceRightName = N("reduceRight")
  val scanLeftName = N("scanLeft")
  val scanRightName = N("scanRight")
  val mapName = N("map")
  val canBuildFromName = N("canBuildFrom")
  val filterName = N("filter")
  val updateName = N("update")
  val toSizeTName = N("toSizeT")
  val toLongName = N("toLong")
  val toIntName = N("toInt")
  val toShortName = N("toShort")
  val toByteName = N("toByte")
  val toCharName = N("toChar")
  val toDoubleName = N("toDouble")
  val toFloatName = N("toFloat")
  val mathName = N("math")
  val packageName = N("package")
    
  object ScalaMathFunction {
    /** I'm all for avoiding "magic strings" but in this case it's hard to
     *  see the twice-as-long identifiers as much improvement.
     */
    def apply(functionName: String, args: List[Tree]) =
      Apply(mkSelect("scala", "math", "package", functionName), args)
        
    def unapply(tree: Tree): Option[(Name, List[Tree])] = tree match {
      case
        Apply(
          Select(
            Select(
              Select(
                Ident(scalaName()),
                mathName()
              ),
              packageName()
            ),
            funName
          ),
          args
        ) =>
        Some((funName, args))
      case _ =>
        None
    }
  }
  object IntRange {
    def apply(from: Tree, to: Tree, by: Option[Tree], isUntil: Boolean, filters: List[Tree]) = error("not implemented")

	def unapply(tree: Tree): Option[(Tree, Tree, Option[Tree], Boolean, List[Tree])] = tree match {
      case Apply(Select(Apply(Select(Predef(), intWrapperName()), List(from)), funToName @ (toName() | untilName())), List(to)) =>
        funToName match {
          case toName() =>
            Some((from, to, None, false, Nil))
          case untilName() =>
            Some((from, to, None, true, Nil))
          case _ =>
            None
        }
      case Apply(Select(tg, n @ (byName() | withFilterName())), List(arg)) =>
       tg match {
          case IntRange(from, to, by, isUntil, filters) =>
            n match {
                case byName() if by == None =>
                    Some((from, to, Some(arg), isUntil, filters))
                case withFilterName() =>
                    Some((from, to, by, isUntil, filters ++ List(arg)))
                case _ =>
                    None
            }
          case _ =>
            None
        }
    }
  }
  
  object Predef {
    lazy val RefArrayOps = this("refArrayOps")
    lazy val IntWrapper  = this("intWrapper")
    
    def contains(sym: Symbol)        = sym.owner == PredefModule.moduleClass
    def apply(name: String): Symbol  = PredefModule.tpe member name
    def unapply(tree: Tree): Boolean = tree.symbol == PredefModule
  }
  object ArrayOps {
    lazy val ArrayOpsClass    = definitions.getClass("scala.collection.mutable.ArrayOps")

    def unapply(tree: Tree): Option[Symbol] = tree match {
      case TypeApply(sel, List(arg))
        if sel.symbol == Predef.RefArrayOps =>
        Some(arg.tpe.typeSymbol)
      case _  => tree.symbol.tpe match {
        case MethodType(_, TypeRef(_, ArrayOpsClass, List(param)))
          if Predef contains tree.symbol =>
          Some(param.typeSymbol)
        case _ =>
          None
      }
    }
  }

  object Foreach {
    def apply(target: Tree, function: Tree) = error("not implemented")

	def unapply(tree: Tree): Option[(Tree, Tree)] = tree match {
      case Apply(TypeApply(Select(target, foreachName()), List(fRetType)), List(function)) =>
        Some((target, function))
      case _ =>
        None
    }
  }


  object ArrayTree {
    def unapply(tree: Tree) = tree match {
      case Apply(ArrayOps(componentType), List(array)) => Some(array, componentType)
      case _ => None
    }
  }
  /** This method submitted in case you like this sort of thing:
   *  not everyone does.  I'm a tireless advocate for brevity.
   */
  class ColTree(ColClass: Symbol) {
    def unapply(tree: Tree) = Some(tree.symbol.tpe) collect {
      case TypeRef(_, ColClass, List(param)) => param.typeSymbol
    }
  }
  object ListTree extends ColTree(ListClass)
  
  object CanBuildFromArg {
    def unapply(tree: Tree) = tree match {
      case
        Apply(
          TypeApply(
            Select(
              xxx,
              canBuildFromName()
            ),
            yyy
          ),
          zzz
        ) =>
        true
      case _ =>
        false
    }
  }

  object MapTree {
    def apply(collection: Tree, function: Tree, functionArgType: Tree, mappedCollectionType: Tree, canBuildFrom: Tree) =
      Apply(
        Apply(
          TypeApply(
            Select(
              collection,
              mapName
            ),
            List(functionArgType, mappedCollectionType)
          ),
          List(function)
        ),
        List(canBuildFrom)
      )

    def unapply(tree: Tree): Option[(Tree, Tree, Tree, Tree, Tree)] = tree match {
      case
        Apply(
          Apply(
            TypeApply(
              Select(
                collection,
                mapName()
              ),
              List(functionArgType, mappedCollectionType)
            ),
            List(function)
          ),
          List(canBuildFrom @ CanBuildFromArg())
        ) =>
        //println("collection = " + collection)
        Some((collection, function, functionArgType, mappedCollectionType, canBuildFrom))
      case _ =>
        None
    }
  }
  object ArrayMap {
    def apply(array: Tree, componentType: Symbol, mappedComponentType: Symbol, mappedArrayType: Tree, param: ValDef, body: Tree) = error("not implemented")
    def unapply(tree: Tree): Option[(Tree, Symbol, Symbol, Tree, Tree)] = tree match {
      case 
        MapTree(
          ArrayTree(array, componentType),
          function,
          functionArgType,
          mappedCollectionType,
          canBuildFrom
        ) =>
        val tpe = array.tpe
        val sym = tpe.typeSymbol
        mappedCollectionType.tpe match {
          case TypeRef(_, _, List(TypeRef(_, sym, args))) =>
            Some((array, componentType, sym, mappedCollectionType, function))
          case _ =>
            None
        }
      case _ =>
        None
    }
  }

  object Func {
    def unapply(tree: Tree): Option[(List[ValDef], Tree)] = tree match {
      case // method references def f(x: T) = y; col.map(f) (inside the .map = a block((), xx => f(xx))
        Block(List(), Func(params, body)) =>
        Some(params, body)
      case Function(params, body) =>
        Some(params, body)
      case _ =>
        None
    }
  }
  object ArrayTabulate {
    /** This is the one all the other ones go through. */
    lazy val tabulateSyms = (ArrayModule.tpe member "tabulate" alternatives).toSet//filter (_.paramss.flatten.size == 3)

    def apply(componentType: Tree, lengths: List[Tree], function: Tree, manifest: Tree) = error("not implemented")
    def unapply(tree: Tree): Option[(Tree, List[Tree], Tree, Tree)] = {
      if (!tabulateSyms.contains(methPart(tree).symbol))
        None
      else flattenApplyGroups(tree) match {
        case List(lengths, List(function), List(manifest)) =>
          Some((typeArgs(tree).headOption getOrElse EmptyTree, lengths, function, manifest))
        case _ =>
          None
      }
    }
  }
  sealed abstract class TraversalOpType {
    def methodName(isLeft: Boolean): String   
  }
  case object Fold extends TraversalOpType {
    override def methodName(isLeft: Boolean) = "fold" + (if (isLeft) "Left" else "Right")
  }
  case object Scan extends TraversalOpType {
    override def methodName(isLeft: Boolean) = "scan" + (if (isLeft) "Left" else "Right")
  }
  case object Reduce extends TraversalOpType {
    override def methodName(isLeft: Boolean) = "reduce" + (if (isLeft) "Left" else "Right")
  }
  case object Sum extends TraversalOpType {
    override def methodName(isLeft: Boolean) = "sum"
  }
  object ReduceName {
    def apply(isLeft: Boolean) = error("not implemented")
    def unapply(name: Name) = name match {
      case reduceLeftName() => Some(true)
      case reduceRightName() => Some(false)
      case _ => None
    }
  }
  object ScanName {
    def apply(isLeft: Boolean) = error("not implemented")
    def unapply(name: Name) = name match {
      case scanLeftName() => Some(true)
      case scanRightName() => Some(false)
      case _ => None
    }
  }
  object FoldName {
    def apply(isLeft: Boolean) = error("not implemented")
    def unapply(name: Name) = name match {
      case foldLeftName() => Some(true)
      case foldRightName() => Some(false)
      case _ => None
    }
  }

  /// Matches one of the folding/scanning/reducing functions : (reduce|fold|scan)(Left|Right)
  object TraversalOp {
    def apply(op: TraversalOpType, array: Tree, resultType: Symbol, function: Tree, isLeft: Boolean, initialValue: Tree) = error("not implemented")
    def unapply(tree: Tree): Option[(TraversalOpType, Tree, Symbol, Tree, Boolean, Tree)] = tree match {
      case // PRIMITIVE OR REF SCAN : scala.this.Predef.refArrayOps[A](array: Array[A]).scanLeft[B, Array[B]](initialValue)(function)(canBuildFromArg)
        Apply(
          Apply(
            Apply(
              TypeApply(
                Select(collection, ScanName(isLeft)),
                List(functionArgType, mappedArrayType)
              ),
              List(initialValue)
            ),
            List(function)
          ),
          List(CanBuildFromArg())
        ) =>
        val tpe = collection.tpe
        mappedArrayType.tpe match {
          case TypeRef(_, _, List(TypeRef(_, sym, args))) =>
            Some((Scan, collection, sym, function, isLeft, initialValue))
          case _ =>
            None
        }
      case // PRIMITIVE OR REF FOLD : scala.this.Predef.refArrayOps[A](array: Array[A]).foldLeft[B](initialValue)(function)
        Apply(
          Apply(
            TypeApply(
              Select(collection, FoldName(isLeft)),
              List(functionResultType)
            ),
            List(initialValue)
          ),
          List(function)
        ) =>
        Some((Fold, collection, functionResultType.symbol, function, isLeft, initialValue))
      case // PRIMITIVE OR REF SUM : scala.this.Predef.refArrayOps[A](array: Array[A]).sum[A](isNumeric)
        Apply(
          TypeApply(
            Select(collection, sumName()),
            List(functionResultType)
          ),
          List(isNumeric)
        ) =>
        Some((Sum, collection, functionResultType.symbol, null, true, null))
      case // PRIMITIVE OR REF REDUCE : scala.this.Predef.refArrayOps[A](array: Array[A]).reduceLeft[B](function)
        Apply(
          TypeApply(
            Select(collection, ReduceName(isLeft)),
            List(functionResultType)
          ),
          List(function)
        ) =>
        Some((Reduce, collection, functionResultType.symbol, function, isLeft, null))
      case _ =>
        None
    }
  }

}