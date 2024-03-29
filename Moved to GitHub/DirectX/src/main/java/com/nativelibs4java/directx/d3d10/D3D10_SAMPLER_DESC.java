package com.nativelibs4java.directx.d3d10;
import com.nativelibs4java.directx.d3d10.D3d10Library.D3D10_COMPARISON_FUNC;
import com.nativelibs4java.directx.d3d10.D3d10Library.D3D10_FILTER;
import com.nativelibs4java.directx.d3d10.D3d10Library.D3D10_TEXTURE_ADDRESS_MODE;
import org.bridj.Pointer;
import org.bridj.StructObject;
import org.bridj.ValuedEnum;
import org.bridj.ann.Array;
import org.bridj.ann.Field;
import org.bridj.ann.Library;
/**
 * <i>native declaration : d3d10.h:760</i><br>
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.free.fr/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> or <a href="http://bridj.googlecode.com/">BridJ</a> .
 */
@Library("d3d10") 
public class D3D10_SAMPLER_DESC extends StructObject {
	public D3D10_SAMPLER_DESC() {
		super();
	}
	public D3D10_SAMPLER_DESC(Pointer pointer) {
		super(pointer);
	}
	/// C type : D3D10_FILTER
	@Field(0) 
	public ValuedEnum<D3D10_FILTER > Filter() {
		return this.io.getEnumField(this, 0);
	}
	/// C type : D3D10_FILTER
	@Field(0) 
	public D3D10_SAMPLER_DESC Filter(ValuedEnum<D3D10_FILTER > Filter) {
		this.io.setEnumField(this, 0, Filter);
		return this;
	}
	/// C type : D3D10_TEXTURE_ADDRESS_MODE
	@Field(1) 
	public ValuedEnum<D3D10_TEXTURE_ADDRESS_MODE > AddressU() {
		return this.io.getEnumField(this, 1);
	}
	/// C type : D3D10_TEXTURE_ADDRESS_MODE
	@Field(1) 
	public D3D10_SAMPLER_DESC AddressU(ValuedEnum<D3D10_TEXTURE_ADDRESS_MODE > AddressU) {
		this.io.setEnumField(this, 1, AddressU);
		return this;
	}
	/// C type : D3D10_TEXTURE_ADDRESS_MODE
	@Field(2) 
	public ValuedEnum<D3D10_TEXTURE_ADDRESS_MODE > AddressV() {
		return this.io.getEnumField(this, 2);
	}
	/// C type : D3D10_TEXTURE_ADDRESS_MODE
	@Field(2) 
	public D3D10_SAMPLER_DESC AddressV(ValuedEnum<D3D10_TEXTURE_ADDRESS_MODE > AddressV) {
		this.io.setEnumField(this, 2, AddressV);
		return this;
	}
	/// C type : D3D10_TEXTURE_ADDRESS_MODE
	@Field(3) 
	public ValuedEnum<D3D10_TEXTURE_ADDRESS_MODE > AddressW() {
		return this.io.getEnumField(this, 3);
	}
	/// C type : D3D10_TEXTURE_ADDRESS_MODE
	@Field(3) 
	public D3D10_SAMPLER_DESC AddressW(ValuedEnum<D3D10_TEXTURE_ADDRESS_MODE > AddressW) {
		this.io.setEnumField(this, 3, AddressW);
		return this;
	}
	@Field(4) 
	public float MipLODBias() {
		return this.io.getFloatField(this, 4);
	}
	@Field(4) 
	public D3D10_SAMPLER_DESC MipLODBias(float MipLODBias) {
		this.io.setFloatField(this, 4, MipLODBias);
		return this;
	}
	@Field(5) 
	public int MaxAnisotropy() {
		return this.io.getIntField(this, 5);
	}
	@Field(5) 
	public D3D10_SAMPLER_DESC MaxAnisotropy(int MaxAnisotropy) {
		this.io.setIntField(this, 5, MaxAnisotropy);
		return this;
	}
	/// C type : D3D10_COMPARISON_FUNC
	@Field(6) 
	public ValuedEnum<D3D10_COMPARISON_FUNC > ComparisonFunc() {
		return this.io.getEnumField(this, 6);
	}
	/// C type : D3D10_COMPARISON_FUNC
	@Field(6) 
	public D3D10_SAMPLER_DESC ComparisonFunc(ValuedEnum<D3D10_COMPARISON_FUNC > ComparisonFunc) {
		this.io.setEnumField(this, 6, ComparisonFunc);
		return this;
	}
	/// C type : FLOAT[4]
	@Array({4}) 
	@Field(7) 
	public Pointer<Float > BorderColor() {
		return this.io.getPointerField(this, 7);
	}
	@Field(8) 
	public float MinLOD() {
		return this.io.getFloatField(this, 8);
	}
	@Field(8) 
	public D3D10_SAMPLER_DESC MinLOD(float MinLOD) {
		this.io.setFloatField(this, 8, MinLOD);
		return this;
	}
	@Field(9) 
	public float MaxLOD() {
		return this.io.getFloatField(this, 9);
	}
	@Field(9) 
	public D3D10_SAMPLER_DESC MaxLOD(float MaxLOD) {
		this.io.setFloatField(this, 9, MaxLOD);
		return this;
	}
}
