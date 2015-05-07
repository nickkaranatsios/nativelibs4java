&lt;wiki:gadget url="http://jnaerator.googlecode.com/svn/wiki/adsense468x60.xml" border="0" width="468" height="60" /&gt;

NativeLibs4Java has a Maven repository in which new versions of both binaries and sources of its subprojects are regularly uploaded (only OpenCL4Java, for now).

If you wish to wrap your own native library for Java, you might want to have a look at [JNAerator's Maven instructions](http://code.google.com/p/jnaerator/wiki/Maven)

# Repository #

To use [NativeLibs4Java's Maven repository](http://nativelibs4java.sourceforge.net/maven), you need to add the following lines to your pom.xml :

```
<repository>
  <id>nativelibs4java-repo</id>
  <url>http://nativelibs4java.sourceforge.net/maven</url>
</repository>
```

# Usage #

  * [JavaCL](http://nativelibs4java.sourceforge.net/maven/com/nativelibs4java/javacl) (includes OpenCL4Java)
```
<dependency>
	<groupId>com.nativelibs4java</groupId>
	<artifactId>javacl</artifactId>
	<version>1.0.0-RC1</version>
	<scope>compile</scope>
</dependency>
```
  * [BridJ](http://nativelibs4java.sourceforge.net/maven/com/nativelibs4java/bridj/) (see [project page](http://bridj.googlecode.com))
```
<dependency>
	<groupId>com.nativelibs4java</groupId>
	<artifactId>bridj</artifactId>
	<version>0.6</version>
	<scope>compile</scope>
</dependency>
```<dependency>
	<groupId>com.nativelibs4java</groupId>
	<artifactId>bridj</artifactId>
	<version>0.6</version>
	<scope>compile</scope>
</dependency>
}}}```