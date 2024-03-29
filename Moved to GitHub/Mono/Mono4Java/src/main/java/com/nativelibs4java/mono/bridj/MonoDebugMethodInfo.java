package com.nativelibs4java.mono.bridj;
import com.nativelibs4java.mono.bridj.MonoLibrary.MonoMethod;
import org.bridj.Pointer;
import org.bridj.StructObject;
import org.bridj.ann.Field;
import org.bridj.ann.Library;
/**
 * <i>native declaration : mono/metadata/debug-mono-symfile.h:70</i><br>
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.free.fr/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> or <a href="http://bridj.googlecode.com/">BridJ</a> .
 */
@Library("mono") 
public class MonoDebugMethodInfo extends StructObject {
	public MonoDebugMethodInfo() {
		super();
	}
	public MonoDebugMethodInfo(Pointer pointer) {
		super(pointer);
	}
	/// C type : MonoMethod*
	@Field(0) 
	public Pointer<MonoMethod > method() {
		return this.io.getPointerField(this, 0);
	}
	/// C type : MonoMethod*
	@Field(0) 
	public MonoDebugMethodInfo method(Pointer<MonoMethod > method) {
		this.io.setPointerField(this, 0, method);
		return this;
	}
	/// C type : MonoDebugHandle*
	@Field(1) 
	public Pointer<MonoDebugHandle > handle() {
		return this.io.getPointerField(this, 1);
	}
	/// C type : MonoDebugHandle*
	@Field(1) 
	public MonoDebugMethodInfo handle(Pointer<MonoDebugHandle > handle) {
		this.io.setPointerField(this, 1, handle);
		return this;
	}
	@Field(2) 
	public int index() {
		return this.io.getIntField(this, 2);
	}
	@Field(2) 
	public MonoDebugMethodInfo index(int index) {
		this.io.setIntField(this, 2, index);
		return this;
	}
	@Field(3) 
	public int data_offset() {
		return this.io.getIntField(this, 3);
	}
	@Field(3) 
	public MonoDebugMethodInfo data_offset(int data_offset) {
		this.io.setIntField(this, 3, data_offset);
		return this;
	}
	@Field(4) 
	public int lnt_offset() {
		return this.io.getIntField(this, 4);
	}
	@Field(4) 
	public MonoDebugMethodInfo lnt_offset(int lnt_offset) {
		this.io.setIntField(this, 4, lnt_offset);
		return this;
	}
}
