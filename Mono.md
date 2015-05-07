&lt;wiki:gadget url="http://jnaerator.googlecode.com/svn/wiki/adsense468x60.xml" border="0" width="468" height="60" /&gt;

# Introduction #

[Mono is a multi-platform CLR/.NET implementation](http://mono-project.com/What_is_Mono) written and maintained by [Novell](http://www.novell.com/).

It makes it possible to run .NET programs on Linux, MacOS X and other unices.

A very cool feature of Mono is its [Embedding C API](http://www.mono-project.com/Embedding_Mono), which is an ideal target for use from Java using [JNAerated](http://jnaerator.googlecode.com/) wrappers.

# Downloads #

You can download [Mono4Java Maven artifacts from here](http://nativelibs4java.sourceforge.net/maven/com/nativelibs4java/mono4java/), or use it from a Maven project with the following dependency :
```
<project>
  ...
  <repositories>
    ...
    <repository>
      <id>nativelibs4java</id>
      <name>nativelibs4java Maven2 Repository</name>
      <url>http://nativelibs4java.sourceforge.net/maven</url>
    </repository>
  </repositories>

  <dependencies>
    <dependency>
      <groupId>com.nativelibs4java</groupId>
      <artifactId>mono4java</artifactId>
      <version>0.1-SNAPSHOT</version>
    </dependency>
  </dependencies>
  ...
</project>
```

# Quickstart #

Read this blog entry [.NET WinForms HelloWorld from Java using embedded Mono + JNAerator](http://ochafik.free.fr/blog/?p=165).

It explains how to use the [examples](http://code.google.com/p/nativelibs4java/source/browse/#svn/trunk/libraries/Mono/examples).

# Building #

See the [Build](Build.md) page. After a full build of all of NativeLibs4Java's source tree, Mono4Java's artifacts are in `libraries/Mono/Mono4Java/target`.

The bindings can be re-generated with `mvn jnaerator:jnaerate` in the Mono4Java directory.