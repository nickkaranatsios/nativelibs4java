# Introduction #

There are two use-cases for this sub-project :
  * Get ready-to-use generalistic Cocoa wrappings : you should hopefully be able to download a JNAerator-beefed up [Rococoa](http://rococoa.dev.java.net) release soon. Right now, Rococoa only ships with a few hand-crafted wrappings.
  * Get custom-tailored wrappings only for the frameworks you're using in your project : you can then follow and adapt the build instructions provided here.

Discussion on these mappings and their use should take place on [Rococoa's users mailing lists](https://rococoa.dev.java.net/servlets/ProjectMailingListList).

These mappings have not been tested yet (at all). It may contain many bugs and is are only a preview of what's going on with JNAerator.

The API is highly likely to evolve quickly, so please don't rely on it too much...

And feel free to tell what you think about it !

# Download #

Compiled wrappers : [macframeworks.jar](http://ochafik.free.fr/nativelibs4java/MacOSXFrameworks/macframeworks.jar)

[Javadoc (partial)](http://ochafik.free.fr/nativelibs4java/MacOSXFrameworks/javadoc)

Wrappers sources : [macframeworks-src.zip](http://ochafik.free.fr/nativelibs4java/MacOSXFrameworks/macframeworks-src.zip)

Sources of modified Rococoa (TODO test modifications with auto-tests & submit to Rococoa) : [rococoa-jnaerator.zip](http://ochafik.free.fr/nativelibs4java/rococoa-jnaerator.zip)

# Building #

Download [MacOSXFrameworks' config.jnaerator](https://github.com/ochafik/nativelibs4java/tree/master/libraries/MacOSXFrameworks/config.jnaerator), then type :

```
java -Xmx1000m -jar jnaerator.jar
```
(this will automatically grab the config.jnaerator file and JNAerate a compiled JAR with all the wrappings + runtime libraries)