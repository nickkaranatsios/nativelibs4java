package com.nativelibs4java.opencl.library;
/**
 * JNA Wrapper for library <b>OpenGL</b><br>
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.free.fr/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a>, <a href="http://rococoa.dev.java.net/">Rococoa</a>, or <a href="http://jna.dev.java.net/">JNA</a>.
 */
public interface OpenGLContextUtils extends com.sun.jna.Library {
	public static final java.lang.String JNA_LIBRARY_NAME = com.sun.jna.Platform.isWindows() ?
		//(com.sun.jna.Platform.is64() ? "OpenGL64" : 
			"OpenGL32"
		//	) 
		: "OpenGL";
	//public static final java.lang.String JNA_LIBRARY_NAME = com.ochafik.lang.jnaerator.runtime.LibraryExtractor.getLibraryPath("OpenGL", true, OpenGLApple.class);
	//public static final com.sun.jna.NativeLibrary JNA_NATIVE_LIB = com.sun.jna.NativeLibrary.getInstance(OpenGLApple.JNA_LIBRARY_NAME, com.ochafik.lang.jnaerator.runtime.MangledFunctionMapper.DEFAULT_OPTIONS);
	public static final OpenGLContextUtils INSTANCE = (OpenGLContextUtils)com.sun.jna.Native.loadLibrary(JNA_LIBRARY_NAME, OpenGLContextUtils.class);//OpenGLApple.JNA_LIBRARY_NAME, OpenGLApple.class, com.ochafik.lang.jnaerator.runtime.MangledFunctionMapper.DEFAULT_OPTIONS);
	
	/// Original signature : <code>CGLShareGroupObj CGLGetShareGroup(CGLContextObj)</code>
	com.ochafik.lang.jnaerator.runtime.NativeSize CGLGetShareGroup(com.ochafik.lang.jnaerator.runtime.NativeSize ctx);
	/**
	 * * Current context functions<br>
	 * Original signature : <code>CGLError CGLSetCurrentContext(CGLContextObj)</code>
	 */
	int CGLSetCurrentContext(com.sun.jna.Pointer ctx);
	/// Original signature : <code>CGLContextObj CGLGetCurrentContext()</code>
	com.ochafik.lang.jnaerator.runtime.NativeSize CGLGetCurrentContext();
	
	/**
	 * * Version numbers<br>
	 * Original signature : <code>void CGLGetVersion(GLint*, GLint*)</code>
	 */
	void CGLGetVersion(java.nio.IntBuffer majorvers, java.nio.IntBuffer minorvers);
	/**
	 * * Convert an error code to a string<br>
	 * Original signature : <code>char* CGLErrorString(CGLError)</code><br>
	 * @param error @see CGLError
	 */
	java.lang.String CGLErrorString(int error);

    com.ochafik.lang.jnaerator.runtime.NativeSize wglGetCurrentDC();
    com.ochafik.lang.jnaerator.runtime.NativeSize wglGetCurrentContext();
    com.ochafik.lang.jnaerator.runtime.NativeSize glXGetCurrentDisplay();
    com.ochafik.lang.jnaerator.runtime.NativeSize glXGetCurrentContext();
}
