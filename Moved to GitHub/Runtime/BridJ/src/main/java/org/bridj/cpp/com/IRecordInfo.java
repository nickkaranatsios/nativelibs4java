package org.bridj.cpp.com;
import org.bridj.Pointer;
import org.bridj.ann.Library;
import org.bridj.ann.Runtime;
import org.bridj.ann.Virtual;
/**
 * <i>native declaration : line 176</i><br>
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.free.fr/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> or <a href="http://bridj.googlecode.com/">BridJ</a> .
 */
@IID("0000002F-0000-0000-C000-000000000046")
public class IRecordInfo extends IUnknown {
	public IRecordInfo() {
		super();
	}
	public IRecordInfo(Pointer pointer) {
		super(pointer);
	}
	@Virtual(0) 
	public native int RecordInit(Pointer<? > pvNew);
	@Virtual(1) 
	public native int RecordClear(Pointer<? > pvExisting);
	@Virtual(2) 
	public native int RecordCopy(Pointer<? > pvExisting, Pointer<? > pvNew);
	@Virtual(3) 
	public native int GetGuid(Pointer<GUID > pguid);
	@Virtual(4) 
	public native int GetName(Pointer<Pointer<Byte > > pbstrName);
	@Virtual(5) 
	public native int GetSize(Pointer<Integer > pcbSize);
	@Virtual(6) 
	public native int GetTypeInfo(Pointer<Pointer<ITypeInfo > > ppTypeInfo);
	@Virtual(7) 
	public native int GetField(Pointer<? > pvData, Pointer<Byte > szFieldName, Pointer<VARIANT > pvarField);
	@Virtual(8) 
	public native int GetFieldNoCopy(Pointer<? > pvData, Pointer<Byte > szFieldName, Pointer<VARIANT > pvarField, Pointer<Pointer<? > > ppvDataCArray);
	@Virtual(9) 
	public native int PutField(int wFlags, Pointer<? > pvData, Pointer<Byte > szFieldName, Pointer<VARIANT > pvarField);
	@Virtual(10) 
	public native int PutFieldNoCopy(int wFlags, Pointer<? > pvData, Pointer<Byte > szFieldName, Pointer<VARIANT > pvarField);
	@Virtual(11) 
	public native int GetFieldNames(Pointer<Integer > pcNames, Pointer<Pointer<Byte > > rgBstrNames);
	@Virtual(12) 
	public native boolean IsMatchingType(Pointer<IRecordInfo > pRecordInfo);
	@Virtual(13) 
	public native Pointer<? > RecordCreate();
	@Virtual(14) 
	public native int RecordCreateCopy(Pointer<? > pvSource, Pointer<Pointer<? > > ppvDest);
	@Virtual(15) 
	public native int RecordDestroy(Pointer<? > pvRecord);
}

