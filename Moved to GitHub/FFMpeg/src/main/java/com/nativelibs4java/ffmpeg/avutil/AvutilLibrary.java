package com.nativelibs4java.ffmpeg.avutil;
import com.nativelibs4java.ffmpeg.avformat.AvformatLibrary.AVTreeNode;
import java.util.Collections;
import java.util.Iterator;
import org.bridj.BridJ;
import org.bridj.Callback;
import org.bridj.FlagSet;
import org.bridj.IntValuedEnum;
import org.bridj.Pointer;
import org.bridj.SizeT;
import org.bridj.ValuedEnum;
import org.bridj.ann.Array;
import org.bridj.ann.Library;
import org.bridj.ann.Ptr;
import org.bridj.ann.Runtime;
import org.bridj.cpp.CPPRuntime;
import org.bridj.util.DefaultParameterizedType;
/**
 * Wrapper for library <b>avutil</b><br>
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.free.fr/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> or <a href="http://bridj.googlecode.com/">BridJ</a> .
 */
@Library("avutil") 
@Runtime(CPPRuntime.class) 
public class AvutilLibrary {
	static {
		BridJ.register();
	}
	public enum AVRounding implements IntValuedEnum<AVRounding > {
		AV_ROUND_ZERO(0),
		AV_ROUND_INF(1),
		AV_ROUND_DOWN(2),
		AV_ROUND_UP(3),
		AV_ROUND_NEAR_INF(5);
		AVRounding(long value) {
			this.value = value;
		}
		public final long value;
		public long value() {
			return this.value;
		}
		public Iterator<AVRounding > iterator() {
			return Collections.singleton(this).iterator();
		}
		public static ValuedEnum<AVRounding > fromValue(long value) {
			return FlagSet.fromValue(value, values());
		}
	};
	public enum AVOptionType implements IntValuedEnum<AVOptionType > {
		FF_OPT_TYPE_FLAGS(0),
		FF_OPT_TYPE_INT(1),
		FF_OPT_TYPE_INT64(2),
		FF_OPT_TYPE_DOUBLE(3),
		FF_OPT_TYPE_FLOAT(4),
		FF_OPT_TYPE_STRING(5),
		FF_OPT_TYPE_RATIONAL(6),
		FF_OPT_TYPE_BINARY(7),
		FF_OPT_TYPE_CONST(128);
		AVOptionType(long value) {
			this.value = value;
		}
		public final long value;
		public long value() {
			return this.value;
		}
		public Iterator<AVOptionType > iterator() {
			return Collections.singleton(this).iterator();
		}
		public static ValuedEnum<AVOptionType > fromValue(long value) {
			return FlagSet.fromValue(value, values());
		}
	};
	public enum AVCRCId implements IntValuedEnum<AVCRCId > {
		AV_CRC_8_ATM(0),
		AV_CRC_16_ANSI(1),
		AV_CRC_16_CCITT(2),
		AV_CRC_32_IEEE(3),
		AV_CRC_32_IEEE_LE(4),
		AV_CRC_MAX(5);
		AVCRCId(long value) {
			this.value = value;
		}
		public final long value;
		public long value() {
			return this.value;
		}
		public Iterator<AVCRCId > iterator() {
			return Collections.singleton(this).iterator();
		}
		public static ValuedEnum<AVCRCId > fromValue(long value) {
			return FlagSet.fromValue(value, values());
		}
	};
	public enum AVMediaType implements IntValuedEnum<AVMediaType > {
		AVMEDIA_TYPE_UNKNOWN(-1),
		AVMEDIA_TYPE_VIDEO(0),
		AVMEDIA_TYPE_AUDIO(1),
		AVMEDIA_TYPE_DATA(2),
		AVMEDIA_TYPE_SUBTITLE(3),
		AVMEDIA_TYPE_ATTACHMENT(4),
		AVMEDIA_TYPE_NB(5);
		AVMediaType(long value) {
			this.value = value;
		}
		public final long value;
		public long value() {
			return this.value;
		}
		public Iterator<AVMediaType > iterator() {
			return Collections.singleton(this).iterator();
		}
		public static ValuedEnum<AVMediaType > fromValue(long value) {
			return FlagSet.fromValue(value, values());
		}
	};
	public enum PixelFormat implements IntValuedEnum<PixelFormat > {
		PIX_FMT_NONE(-1),
		PIX_FMT_YUV420P(0),
		PIX_FMT_YUYV422(1),
		PIX_FMT_RGB24(2),
		PIX_FMT_BGR24(3),
		PIX_FMT_YUV422P(4),
		PIX_FMT_YUV444P(5),
		PIX_FMT_YUV410P(6),
		PIX_FMT_YUV411P(7),
		PIX_FMT_GRAY8(8),
		PIX_FMT_MONOWHITE(9),
		PIX_FMT_MONOBLACK(10),
		PIX_FMT_PAL8(11),
		PIX_FMT_YUVJ420P(12),
		PIX_FMT_YUVJ422P(13),
		PIX_FMT_YUVJ444P(14),
		PIX_FMT_XVMC_MPEG2_MC(15),
		PIX_FMT_XVMC_MPEG2_IDCT(16),
		PIX_FMT_UYVY422(17),
		PIX_FMT_UYYVYY411(18),
		PIX_FMT_BGR8(19),
		PIX_FMT_BGR4(20),
		PIX_FMT_BGR4_BYTE(21),
		PIX_FMT_RGB8(22),
		PIX_FMT_RGB4(23),
		PIX_FMT_RGB4_BYTE(24),
		PIX_FMT_NV12(25),
		PIX_FMT_NV21(26),
		PIX_FMT_ARGB(27),
		PIX_FMT_RGBA(28),
		PIX_FMT_ABGR(29),
		PIX_FMT_BGRA(30),
		PIX_FMT_GRAY16BE(31),
		PIX_FMT_GRAY16LE(32),
		PIX_FMT_YUV440P(33),
		PIX_FMT_YUVJ440P(34),
		PIX_FMT_YUVA420P(35),
		PIX_FMT_VDPAU_H264(36),
		PIX_FMT_VDPAU_MPEG1(37),
		PIX_FMT_VDPAU_MPEG2(38),
		PIX_FMT_VDPAU_WMV3(39),
		PIX_FMT_VDPAU_VC1(40),
		PIX_FMT_RGB48BE(41),
		PIX_FMT_RGB48LE(42),
		PIX_FMT_RGB565BE(43),
		PIX_FMT_RGB565LE(44),
		PIX_FMT_RGB555BE(45),
		PIX_FMT_RGB555LE(46),
		PIX_FMT_BGR565BE(47),
		PIX_FMT_BGR565LE(48),
		PIX_FMT_BGR555BE(49),
		PIX_FMT_BGR555LE(50),
		PIX_FMT_VAAPI_MOCO(51),
		PIX_FMT_VAAPI_IDCT(52),
		PIX_FMT_VAAPI_VLD(53),
		PIX_FMT_YUV420P16LE(54),
		PIX_FMT_YUV420P16BE(55),
		PIX_FMT_YUV422P16LE(56),
		PIX_FMT_YUV422P16BE(57),
		PIX_FMT_YUV444P16LE(58),
		PIX_FMT_YUV444P16BE(59),
		PIX_FMT_VDPAU_MPEG4(60),
		PIX_FMT_DXVA2_VLD(61),
		PIX_FMT_RGB444BE(62),
		PIX_FMT_RGB444LE(63),
		PIX_FMT_BGR444BE(64),
		PIX_FMT_BGR444LE(65),
		PIX_FMT_Y400A(66),
		PIX_FMT_NB(67);
		PixelFormat(long value) {
			this.value = value;
		}
		public final long value;
		public long value() {
			return this.value;
		}
		public Iterator<PixelFormat > iterator() {
			return Collections.singleton(this).iterator();
		}
		public static ValuedEnum<PixelFormat > fromValue(long value) {
			return FlagSet.fromValue(value, values());
		}
	};
	/**
	 * Conversion Error : a.num<br>
	 * SKIPPED:<br>
	 * <i>native declaration : libavutil/rational.h</i><br>
	 * const int64_t tmp = a.num * (int64_t)b.den - b.num * (int64_t)a.den;
	 */
	/// <i>native declaration : libavutil/x86_cpu.h</i>
	public static final String REG_BP = (String)"rbp";
	/// <i>native declaration : libavutil/cpu.h</i>
	public static final int AV_CPU_FLAG_SSSE3 = (int)128;
	/// <i>native declaration : libavutil/log.h</i>
	public static final int AV_LOG_SKIP_REPEATED = (int)1;
	/// <i>native declaration : libavutil/avconfig.h</i>
	public static final int AV_HAVE_FAST_UNALIGNED = (int)1;
	/// <i>native declaration : libavutil/log.h</i>
	public static final int AV_LOG_WARNING = (int)24;
	/// <i>native declaration : libavutil/cpu.h</i>
	public static final int AV_CPU_FLAG_SSE2SLOW = (int)1073741824;
	/// <i>native declaration : libavutil/cpu.h</i>
	public static final int AV_CPU_FLAG_SSE3SLOW = (int)536870912;
	/// <i>native declaration : libavutil/avutil.h</i>
	public static final int LIBAVUTIL_VERSION_MAJOR = (int)50;
	/// <i>native declaration : libavutil/x86_cpu.h</i>
	public static final String OPSIZE = (String)"q";
	/// <i>native declaration : libavutil/lzo.h</i>
	public static final int AV_LZO_ERROR = (int)8;
	/// <i>native declaration : libavutil/softfloat.h</i>
	public static final int MIN_EXP = (int)-126;
	/// <i>native declaration : libavutil/x86_cpu.h</i>
	public static final String REG_SP = (String)"rsp";
	/// <i>native declaration : libavutil/lzo.h</i>
	public static final int AV_LZO_INPUT_PADDING = (int)8;
	/// <i>native declaration : libavutil/x86_cpu.h</i>
	public static final String PTR_SIZE = (String)"8";
	/// <i>native declaration : libavutil/cpu.h</i>
	public static final int AV_CPU_FLAG_SSE = (int)8;
	/// <i>native declaration : libavutil/avutil.h</i>
	public static final int LIBAVUTIL_VERSION_MINOR = (int)36;
	/// <i>native declaration : libavutil/avutil.h</i>
	public static final String LIBAVUTIL_IDENT = (String)"Lavu";
	/// <i>native declaration : libavutil/avutil.h</i>
	public static final int FF_LAMBDA_SHIFT = (int)7;
	/// <i>native declaration : libavutil/avutil.h</i>
	public static final int FF_LAMBDA_MAX = (int)(256 * 128 - 1);
	/// <i>native declaration : libavutil/softfloat.h</i>
	public static final int MAX_EXP = (int)126;
	/// <i>native declaration : libavutil/pixdesc.h</i>
	public static final int PIX_FMT_HWACCEL = (int)8;
	/// <i>native declaration : libavutil/cpu.h</i>
	public static final int AV_CPU_FLAG_SSE2 = (int)16;
	/// <i>native declaration : libavutil/cpu.h</i>
	public static final int AV_CPU_FLAG_SSE3 = (int)64;
	/// <i>native declaration : libavutil/cpu.h</i>
	public static final int AV_CPU_FLAG_SSE4 = (int)256;
	/// <i>native declaration : libavutil/lls.h</i>
	public static final int MAX_VARS = (int)32;
	/// <i>native declaration : libavutil/log.h</i>
	public static final int AV_LOG_INFO = (int)32;
	/// <i>native declaration : libavutil/cpu.h</i>
	public static final int AV_CPU_FLAG_MMX2 = (int)2;
	/// <i>native declaration : libavutil/lzo.h</i>
	public static final int AV_LZO_INPUT_DEPLETED = (int)1;
	/// <i>native declaration : libavutil/lzo.h</i>
	public static final int AV_LZO_OUTPUT_PADDING = (int)12;
	/// <i>native declaration : libavutil/opt.h</i>
	public static final int AV_OPT_FLAG_SUBTITLE_PARAM = (int)32;
	/// <i>native declaration : libavutil/lzo.h</i>
	public static final int AV_LZO_OUTPUT_FULL = (int)2;
	/// <i>native declaration : libavutil/x86_cpu.h</i>
	public static final String REG_D = (String)"rdi";
	/// <i>native declaration : libavutil/x86_cpu.h</i>
	public static final String REG_S = (String)"rsi";
	/// <i>native declaration : libavutil/x86_cpu.h</i>
	public static final String REG_b = (String)"rbx";
	/// <i>native declaration : libavutil/x86_cpu.h</i>
	public static final String REG_a = (String)"rax";
	/// <i>native declaration : libavutil/x86_cpu.h</i>
	public static final String REG_d = (String)"rdx";
	/// <i>native declaration : libavutil/x86_cpu.h</i>
	public static final String REG_c = (String)"rcx";
	/// <i>native declaration : libavutil/cpu.h</i>
	public static final int AV_CPU_FLAG_SSE42 = (int)512;
	/// <i>native declaration : libavutil/log.h</i>
	public static final int AV_LOG_ERROR = (int)16;
	/// <i>native declaration : libavutil/log.h</i>
	public static final int AV_LOG_FATAL = (int)8;
	/// <i>native declaration : libavutil/cpu.h</i>
	public static final int AV_CPU_FLAG_IWMMXT = (int)256;
	/// <i>native declaration : libavutil/mathematics.h</i>
	public static final double M_LOG2_10 = (double)3.321928094887362;
	/// <i>native declaration : libavutil/cpu.h</i>
	public static final int AV_CPU_FLAG_MMX = (int)1;
	/// <i>native declaration : libavutil/mathematics.h</i>
	public static final double M_PHI = (double)1.618033988749895;
	/// <i>native declaration : libavutil/integer.h</i>
	public static final int AV_INTEGER_SIZE = (int)8;
	/// <i>native declaration : libavutil/opt.h</i>
	public static final int AV_OPT_FLAG_ENCODING_PARAM = (int)1;
	/// <i>native declaration : libavutil/opt.h</i>
	public static final int AV_OPT_FLAG_METADATA = (int)4;
	/// <i>native declaration : libavutil/log.h</i>
	public static final int AV_LOG_QUIET = (int)-8;
	/// <i>native declaration : libavutil/avutil.h</i>
	public static final int FF_QP2LAMBDA = (int)118;
	/// <i>native declaration : libavutil/cpu.h</i>
	public static final int AV_CPU_FLAG_FORCE = (int)-2147483648;
	/// <i>native declaration : libavutil/lzo.h</i>
	public static final int AV_LZO_INVALID_BACKPTR = (int)4;
	/// <i>native declaration : libavutil/cpu.h</i>
	public static final int AV_CPU_FLAG_ALTIVEC = (int)1;
	/// <i>native declaration : libavutil/pixdesc.h</i>
	public static final int PIX_FMT_BE = (int)1;
	/// <i>native declaration : libavutil/pixdesc.h</i>
	public static final int PIX_FMT_PAL = (int)2;
	/// <i>native declaration : libavutil/avutil.h</i>
	public static final int LIBAVUTIL_VERSION_MICRO = (int)0;
	/// <i>native declaration : libavutil/log.h</i>
	public static final int AV_LOG_PANIC = (int)0;
	/// <i>native declaration : libavutil/opt.h</i>
	public static final int AV_OPT_FLAG_DECODING_PARAM = (int)2;
	/// <i>native declaration : libavutil/log.h</i>
	public static final int AV_LOG_DEBUG = (int)48;
	/// <i>native declaration : libavutil/softfloat.h</i>
	public static final int ONE_BITS = (int)29;
	/// <i>native declaration : libavutil/log.h</i>
	public static final int AV_LOG_VERBOSE = (int)40;
	/// <i>native declaration : libavutil/opt.h</i>
	public static final int AV_OPT_FLAG_VIDEO_PARAM = (int)16;
	/// <i>native declaration : libavutil/avconfig.h</i>
	public static final int AV_HAVE_BIGENDIAN = (int)0;
	/// <i>native declaration : libavutil/opt.h</i>
	public static final int AV_OPT_FLAG_AUDIO_PARAM = (int)8;
	/// <i>native declaration : libavutil/cpu.h</i>
	public static final int AV_CPU_FLAG_3DNOW = (int)4;
	/// <i>native declaration : libavutil/pixdesc.h</i>
	public static final int PIX_FMT_BITSTREAM = (int)4;
	/// <i>native declaration : libavutil/cpu.h</i>
	public static final int AV_CPU_FLAG_3DNOWEXT = (int)32;
	/// <i>native declaration : libavutil/colorspace.h</i>
	public static final int SCALEBITS = (int)10;
	/// <i>native declaration : libavutil/avutil.h</i>
	public static final boolean FF_API_OLD_EVAL_NAMES = (boolean)(AvutilLibrary.LIBAVUTIL_VERSION_MAJOR < 51);
	/// <i>native declaration : libavutil/colorspace.h</i>
	public static final int ONE_HALF = (int)(1 << (AvutilLibrary.SCALEBITS - 1));
	/// <i>native declaration : libavutil/avutil.h</i>
	public static final int FF_LAMBDA_SCALE = (int)(1 << AvutilLibrary.FF_LAMBDA_SHIFT);
	/// <i>native declaration : libavutil/log.h:133</i>
	public static abstract class av_log_set_callback_arg1_callback extends Callback<av_log_set_callback_arg1_callback > {
		public abstract void apply(Pointer<? > voidPtr1, int int1, Pointer<Byte > charPtr1);
	};
	/// <i>native declaration : libavutil/eval.h</i>
	public static abstract class av_expr_parse_and_eval_funcs1_callback extends Callback<av_expr_parse_and_eval_funcs1_callback > {
		public abstract double apply(Pointer<? > voidPtr1, double double1);
	};
	/// <i>native declaration : libavutil/eval.h</i>
	public static abstract class av_expr_parse_and_eval_funcs2_callback extends Callback<av_expr_parse_and_eval_funcs2_callback > {
		public abstract double apply(Pointer<? > voidPtr1, double double1, double double2);
	};
	/// <i>native declaration : libavutil/eval.h</i>
	public static abstract class av_expr_parse_funcs1_callback extends Callback<av_expr_parse_funcs1_callback > {
		public abstract double apply(Pointer<? > voidPtr1, double double1);
	};
	/// <i>native declaration : libavutil/eval.h</i>
	public static abstract class av_expr_parse_funcs2_callback extends Callback<av_expr_parse_funcs2_callback > {
		public abstract double apply(Pointer<? > voidPtr1, double double1, double double2);
	};
	/// <i>native declaration : libavutil/tree.h:44</i>
	public static abstract class av_tree_find_arg1_cmp_callback extends Callback<av_tree_find_arg1_cmp_callback > {
		public abstract int apply(Pointer<? > key, Pointer<? > b);
	};
	/// <i>native declaration : libavutil/tree.h:79</i>
	public static abstract class av_tree_insert_arg1_cmp_callback extends Callback<av_tree_insert_arg1_cmp_callback > {
		public abstract int apply(Pointer<? > key, Pointer<? > b);
	};
	/// <i>native declaration : libavutil/tree.h:92</i>
	public static abstract class av_tree_enumerate_arg1_cmp_callback extends Callback<av_tree_enumerate_arg1_cmp_callback > {
		public abstract int apply(Pointer<? > opaque, Pointer<? > elem);
	};
	/// <i>native declaration : libavutil/tree.h:92</i>
	public static abstract class av_tree_enumerate_arg2_enu_callback extends Callback<av_tree_enumerate_arg2_enu_callback > {
		public abstract int apply(Pointer<? > opaque, Pointer<? > elem);
	};
	/// <i>native declaration : libavutil/fifo.h:76</i>
	public static abstract class av_fifo_generic_read_arg1_func_callback extends Callback<av_fifo_generic_read_arg1_func_callback > {
		public abstract void apply(Pointer<? > voidPtr1, Pointer<? > voidPtr2, int int1);
	};
	/// <i>native declaration : libavutil/fifo.h:91</i>
	public static abstract class av_fifo_generic_write_arg1_func_callback extends Callback<av_fifo_generic_write_arg1_func_callback > {
		public abstract int apply(Pointer<? > voidPtr1, Pointer<? > voidPtr2, int int1);
	};
	public static native int av_sha_init(Pointer<AvutilLibrary.AVSHA > context, int bits);
	public static native void av_sha_update(Pointer<AvutilLibrary.AVSHA > context, Pointer<Byte > data, int len);
	public static native void av_sha_final(Pointer<AvutilLibrary.AVSHA > context, Pointer<Byte > digest);
	public static native int av_get_cpu_flags();
	public static native int ff_get_cpu_flags_arm();
	public static native int ff_get_cpu_flags_ppc();
	public static native int ff_get_cpu_flags_x86();
	public static native int av_strerror(int errnum, Pointer<Byte > errbuf, @Ptr long errbuf_size);
	public static native Pointer<? > av_malloc(int size);
	public static native Pointer<? > av_realloc(Pointer<? > ptr, int size);
	public static native void av_free(Pointer<? > ptr);
	public static native Pointer<? > av_mallocz(int size);
	public static native Pointer<Byte > av_strdup(Pointer<Byte > s);
	public static native void av_freep(Pointer<? > ptr);
	public static native short av_bswap16(short x);
	public static native int av_bswap32(int x);
	public static native AvutilLibrary.av_const av_bswap64(long x);
	public static native void av_sha1_init(Pointer<AvutilLibrary.AVSHA1 > context);
	public static native void av_sha1_update(Pointer<AvutilLibrary.AVSHA1 > context, Pointer<Byte > data, int len);
	public static native void av_sha1_final(Pointer<AvutilLibrary.AVSHA1 > context, Pointer<Byte > digest);
	public static native int av_aes_init(Pointer<AvutilLibrary.AVAES > a, Pointer<Byte > key, int key_bits, int decrypt);
	public static native void av_aes_crypt(Pointer<AvutilLibrary.AVAES > a, Pointer<Byte > dst, Pointer<Byte > src, int count, Pointer<Byte > iv, int decrypt);
	public static native AvutilLibrary.av_const av_gcd(long a, long b);
	public static native int av_compare_ts(long ts_a, AVRational tb_a, long ts_b, AVRational tb_b);
	public static native long av_compare_mod(long a, long b, long mod);
	public static native void av_read_image_line(Pointer<Short > dst, Pointer<Pointer<Byte > > data, Pointer<Integer > linesize, Pointer<AVPixFmtDescriptor > desc, int x, int y, int c, int w, int read_pal_component);
	public static native void av_write_image_line(Pointer<Short > src, Pointer<Pointer<Byte > > data, Pointer<Integer > linesize, Pointer<AVPixFmtDescriptor > desc, int x, int y, int c, int w);
	public static native com.nativelibs4java.ffmpeg.swscale.SwscaleLibrary.PixelFormat av_get_pix_fmt(Pointer<Byte > name);
	public static native Pointer<Byte > av_get_pix_fmt_string(Pointer<Byte > buf, int buf_size, com.nativelibs4java.ffmpeg.swscale.SwscaleLibrary.PixelFormat pix_fmt);
	public static native int av_get_bits_per_pixel(Pointer<AVPixFmtDescriptor > pixdesc);
	public static native void av_log(Pointer<? > avcl, int level, Pointer<Byte > fmt, Object... args);
	public static native void av_vlog(Pointer<? > avcl, int level, Pointer<Byte > fmt, Object... args);
	public static native int av_log_get_level();
	public static native void av_log_set_level(int int1);
	public static native void av_log_set_callback(Pointer<AvutilLibrary.av_log_set_callback_arg1_callback > arg1);
	public static native void av_log_default_callback(Pointer<? > ptr, int level, Pointer<Byte > fmt, Pointer<? > vl);
	public static native Pointer<Byte > av_default_item_name(Pointer<? > ctx);
	public static native void av_log_set_flags(int arg);
	public static native Pointer<AVOption > av_find_opt(Pointer<? > obj, Pointer<Byte > name, Pointer<Byte > unit, int mask, int flags);
	public static native int av_set_string3(Pointer<? > obj, Pointer<Byte > name, Pointer<Byte > val, int alloc, Pointer<Pointer<AVOption > > o_out);
	public static native Pointer<AVOption > av_set_double(Pointer<? > obj, Pointer<Byte > name, double n);
	public static native Pointer<AVOption > av_set_q(Pointer<? > obj, Pointer<Byte > name, AVRational n);
	public static native Pointer<AVOption > av_set_int(Pointer<? > obj, Pointer<Byte > name, long n);
	public static native double av_get_double(Pointer<? > obj, Pointer<Byte > name, Pointer<Pointer<AVOption > > o_out);
	public static native AVRational av_get_q(Pointer<? > obj, Pointer<Byte > name, Pointer<Pointer<AVOption > > o_out);
	public static native long av_get_int(Pointer<? > obj, Pointer<Byte > name, Pointer<Pointer<AVOption > > o_out);
	public static native Pointer<Byte > av_get_string(Pointer<? > obj, Pointer<Byte > name, Pointer<Pointer<AVOption > > o_out, Pointer<Byte > buf, int buf_len);
	public static native Pointer<AVOption > av_next_option(Pointer<? > obj, Pointer<AVOption > last);
	public static native int av_opt_show2(Pointer<? > obj, Pointer<? > av_log_obj, int req_flags, int rej_flags);
	public static native void av_opt_set_defaults(Pointer<? > s);
	public static native void av_opt_set_defaults2(Pointer<? > s, int mask, int flags);
	public static native int av_set_options_string(Pointer<? > ctx, Pointer<Byte > opts, Pointer<Byte > key_val_sep, Pointer<Byte > pairs_sep);
	public static native int av_log2_c(int v);
	public static native int av_log2_16bit_c(int v);
	public static native int av_clip_c(int a, int amin, int amax);
	public static native byte av_clip_uint8_c(int a);
	public static native byte av_clip_int8_c(int a);
	public static native short av_clip_uint16_c(int a);
	public static native short av_clip_int16_c(int a);
	public static native int av_des_init(Pointer<AVDES > d, Pointer<Byte > key, int key_bits, int decrypt);
	public static native void av_des_crypt(Pointer<AVDES > d, Pointer<Byte > dst, Pointer<Byte > src, int count, Pointer<Byte > iv, int decrypt);
	public static native int av_rc4_init(Pointer<AVRC4 > d, Pointer<Byte > key, int key_bits, int decrypt);
	public static native void av_rc4_crypt(Pointer<AVRC4 > d, Pointer<Byte > dst, Pointer<Byte > src, int count, Pointer<Byte > iv, int decrypt);
	public static native int av_expr_parse_and_eval(Pointer<Double > res, Pointer<Byte > s, Pointer<Pointer<Byte > > const_names, Pointer<Double > const_values, Pointer<Pointer<Byte > > func1_names, Pointer<Pointer<AvutilLibrary.av_expr_parse_and_eval_funcs1_callback > > funcs1, Pointer<Pointer<Byte > > func2_names, Pointer<Pointer<AvutilLibrary.av_expr_parse_and_eval_funcs2_callback > > funcs2, Pointer<? > opaque, int log_offset, Pointer<? > log_ctx);
	public static native int av_expr_parse(Pointer<Pointer<AvutilLibrary.AVExpr > > expr, Pointer<Byte > s, Pointer<Pointer<Byte > > const_names, Pointer<Pointer<Byte > > func1_names, Pointer<Pointer<AvutilLibrary.av_expr_parse_funcs1_callback > > funcs1, Pointer<Pointer<Byte > > func2_names, Pointer<Pointer<AvutilLibrary.av_expr_parse_funcs2_callback > > funcs2, int log_offset, Pointer<? > log_ctx);
	public static native double av_expr_eval(Pointer<AvutilLibrary.AVExpr > e, Pointer<Double > const_values, Pointer<? > opaque);
	public static native void av_expr_free(Pointer<AvutilLibrary.AVExpr > e);
	public static native double av_strtod(Pointer<Byte > numstr, Pointer<Pointer<Byte > > tail);
	public static native int av_strstart(Pointer<Byte > str, Pointer<Byte > pfx, Pointer<Pointer<Byte > > ptr);
	public static native int av_stristart(Pointer<Byte > str, Pointer<Byte > pfx, Pointer<Pointer<Byte > > ptr);
	public static native Pointer<Byte > av_stristr(Pointer<Byte > haystack, Pointer<Byte > needle);
	@Ptr 
	public static native long av_strlcpy(Pointer<Byte > dst, Pointer<Byte > src, @Ptr long size);
	@Ptr 
	public static native long av_strlcat(Pointer<Byte > dst, Pointer<Byte > src, @Ptr long size);
	@Ptr 
	public static native long av_strlcatf(Pointer<Byte > dst, @Ptr long size, Pointer<Byte > fmt, Object... args);
	public static native Pointer<Byte > av_d2str(double d);
	public static native Pointer<Byte > av_get_token(Pointer<Pointer<Byte > > buf, Pointer<Byte > term);
	public static native int av_file_map(Pointer<Byte > filename, Pointer<Pointer<Byte > > bufptr, Pointer<SizeT > size, int log_offset, Pointer<? > log_ctx);
	public static native void av_file_unmap(Pointer<Byte > bufptr, @Ptr long size);
	public static native SoftFloat av_normalize_sf(SoftFloat a);
	public static native SoftFloat av_div_sf(SoftFloat a, SoftFloat b);
	public static native int av_crc_init(Pointer<Integer > ctx, int le, int bits, int poly, int ctx_size);
	public static native Pointer<Integer > av_crc_get_table(ValuedEnum<AvutilLibrary.AVCRCId > crc_id);
	public static native int av_crc(Pointer<Integer > ctx, int start_crc, Pointer<Byte > buffer, @Ptr long length);
	public static native void avutil_version();
	public static native Pointer<Byte > avutil_configuration();
	public static native Pointer<Byte > avutil_license();
	public static native AVInteger av_add_i(AVInteger a, AVInteger b);
	public static native AVInteger av_sub_i(AVInteger a, AVInteger b);
	public static native int av_log2_i(AVInteger a);
	public static native AVInteger av_mul_i(AVInteger a, AVInteger b);
	public static native int av_cmp_i(AVInteger a, AVInteger b);
	public static native AVInteger av_shr_i(AVInteger a, int s);
	public static native AVInteger av_mod_i(Pointer<AVInteger > quot, AVInteger a, AVInteger b);
	public static native AVInteger av_div_i(AVInteger a, AVInteger b);
	public static native AVInteger av_int2i(long a);
	public static native long av_i2int(AVInteger a);
	public static native void av_md5_init(Pointer<AvutilLibrary.AVMD5 > ctx);
	public static native void av_md5_update(Pointer<AvutilLibrary.AVMD5 > ctx, Pointer<Byte > src, int len);
	public static native void av_md5_final(Pointer<AvutilLibrary.AVMD5 > ctx, Pointer<Byte > dst);
	public static native void av_md5_sum(Pointer<Byte > dst, Pointer<Byte > src, int len);
	public static native Pointer<? > av_tree_find(Pointer<AVTreeNode > root, Pointer<? > key, Pointer<AvutilLibrary.av_tree_find_arg1_cmp_callback > arg1, Pointer<Pointer<? > > next);
	public static native Pointer<? > av_tree_insert(Pointer<Pointer<AVTreeNode > > rootp, Pointer<? > key, Pointer<AvutilLibrary.av_tree_insert_arg1_cmp_callback > arg1, Pointer<Pointer<AVTreeNode > > next);
	public static native void av_tree_destroy(Pointer<AVTreeNode > t);
	public static native void av_tree_enumerate(Pointer<AVTreeNode > t, Pointer<? > opaque, Pointer<AvutilLibrary.av_tree_enumerate_arg1_cmp_callback > arg1, Pointer<AvutilLibrary.av_tree_enumerate_arg2_enu_callback > arg2);
	public static native int av_lzo1x_decode(Pointer<? > out, Pointer<Integer > outlen, Pointer<? > in, Pointer<Integer > inlen);
	public static native void av_memcpy_backptr(Pointer<Byte > dst, int back, int cnt);
	public static native void av_init_lls(Pointer<LLSModel > m, int indep_count);
	public static native void av_update_lls(Pointer<LLSModel > m, Pointer<Double > param, double decay);
	public static native void av_solve_lls(Pointer<LLSModel > m, double threshold, int min_order);
	public static native double av_evaluate_lls(Pointer<LLSModel > m, Pointer<Double > param, int order);
	public static native int av_base64_decode(Pointer<Byte > out, Pointer<Byte > in, int out_size);
	public static native Pointer<Byte > av_base64_encode(Pointer<Byte > out, int out_size, Pointer<Byte > in, int in_size);
	public static native Pointer<AVFifoBuffer > av_fifo_alloc(int size);
	public static native void av_fifo_free(Pointer<AVFifoBuffer > f);
	public static native void av_fifo_reset(Pointer<AVFifoBuffer > f);
	public static native int av_fifo_size(Pointer<AVFifoBuffer > f);
	public static native int av_fifo_space(Pointer<AVFifoBuffer > f);
	public static native int av_fifo_generic_read(Pointer<AVFifoBuffer > f, Pointer<? > dest, int buf_size, Pointer<AvutilLibrary.av_fifo_generic_read_arg1_func_callback > arg1);
	public static native int av_fifo_generic_write(Pointer<AVFifoBuffer > f, Pointer<? > src, int size, Pointer<AvutilLibrary.av_fifo_generic_write_arg1_func_callback > arg1);
	public static native int av_fifo_realloc2(Pointer<AVFifoBuffer > f, int size);
	public static native void av_fifo_drain(Pointer<AVFifoBuffer > f, int size);
	public static native double av_int2dbl(long v);
	public static native float av_int2flt(int v);
	public static native double av_ext2dbl(AVExtFloat ext);
	public static native long av_dbl2int(double d);
	public static native int av_flt2int(float d);
	public static native AVExtFloat av_dbl2ext(double d);
	public static native void av_lfg_init(Pointer<AVLFG > c, int seed);
	public static native void av_bmg_get(Pointer<AVLFG > lfg, Pointer<Double > out);
	public static native Pointer<AvutilLibrary.PCA > ff_pca_init(int n);
	public static native void ff_pca_free(Pointer<AvutilLibrary.PCA > pca);
	public static native void ff_pca_add(Pointer<AvutilLibrary.PCA > pca, Pointer<Double > v);
	public static native int ff_pca(Pointer<AvutilLibrary.PCA > pca, Pointer<Double > eigenvector, Pointer<Double > eigenvalue);
	public static native int av_reduce(Pointer<Integer > dst_num, Pointer<Integer > dst_den, long num, long den, long max);
	public static native AVRational av_mul_q(AVRational b, AVRational c);
	public static native AVRational av_div_q(AVRational b, AVRational c);
	public static native AVRational av_add_q(AVRational b, AVRational c);
	public static native AVRational av_sub_q(AVRational b, AVRational c);
	public static native AVRational av_d2q(double d, int max);
	public static native int av_nearer_q(AVRational q, AVRational q1, AVRational q2);
	public static native int av_find_nearest_q_idx(AVRational q, Pointer<AVRational > q_list);
	public static native int av_get_random_seed();
	public int av_sha_size() {
		try {
			return (int)BridJ.getNativeLibrary("avutil").getSymbolPointer("av_sha_size").as(int.class).get();
		}catch (Throwable $ex$) {
			throw new RuntimeException($ex$);
		}
	}
	public AvutilLibrary av_sha_size(int av_sha_size) {
		try {
			{
				BridJ.getNativeLibrary("avutil").getSymbolPointer("av_sha_size").as(int.class).set(av_sha_size);
				return this;
			}
		}catch (Throwable $ex$) {
			throw new RuntimeException($ex$);
		}
	}
	public final int av_sha_size_$eq(int av_sha_size) {
		av_sha_size(av_sha_size);
		return av_sha_size;
	}
	public int av_sha1_size() {
		try {
			return (int)BridJ.getNativeLibrary("avutil").getSymbolPointer("av_sha1_size").as(int.class).get();
		}catch (Throwable $ex$) {
			throw new RuntimeException($ex$);
		}
	}
	public AvutilLibrary av_sha1_size(int av_sha1_size) {
		try {
			{
				BridJ.getNativeLibrary("avutil").getSymbolPointer("av_sha1_size").as(int.class).set(av_sha1_size);
				return this;
			}
		}catch (Throwable $ex$) {
			throw new RuntimeException($ex$);
		}
	}
	public final int av_sha1_size_$eq(int av_sha1_size) {
		av_sha1_size(av_sha1_size);
		return av_sha1_size;
	}
	public int av_aes_size() {
		try {
			return (int)BridJ.getNativeLibrary("avutil").getSymbolPointer("av_aes_size").as(int.class).get();
		}catch (Throwable $ex$) {
			throw new RuntimeException($ex$);
		}
	}
	public AvutilLibrary av_aes_size(int av_aes_size) {
		try {
			{
				BridJ.getNativeLibrary("avutil").getSymbolPointer("av_aes_size").as(int.class).set(av_aes_size);
				return this;
			}
		}catch (Throwable $ex$) {
			throw new RuntimeException($ex$);
		}
	}
	public final int av_aes_size_$eq(int av_aes_size) {
		av_aes_size(av_aes_size);
		return av_aes_size;
	}
	/// Conversion Error : null (void type !)
	/// Conversion Error : null (void type !)
	/// Conversion Error : null (void type !)
	/// Conversion Error : null (void type !)
	/**
	 * The array of all the pixel format descriptors.<br>
	 * C type : extern const AVPixFmtDescriptor[]
	 */
	public Pointer<AVPixFmtDescriptor > av_pix_fmt_descriptors() {
		try {
			return (Pointer<AVPixFmtDescriptor >)BridJ.getNativeLibrary("avutil").getSymbolPointer("av_pix_fmt_descriptors").as(org.bridj.util.DefaultParameterizedType.paramType(org.bridj.Pointer.class, com.nativelibs4java.ffmpeg.avutil.AVPixFmtDescriptor.class)).get();
		}catch (Throwable $ex$) {
			throw new RuntimeException($ex$);
		}
	}
	/**
	 * The array of all the pixel format descriptors.<br>
	 * C type : extern const AVPixFmtDescriptor[]
	 */
	public AvutilLibrary av_pix_fmt_descriptors(Pointer<AVPixFmtDescriptor > av_pix_fmt_descriptors) {
		try {
			{
				BridJ.getNativeLibrary("avutil").getSymbolPointer("av_pix_fmt_descriptors").as(org.bridj.util.DefaultParameterizedType.paramType(org.bridj.Pointer.class, com.nativelibs4java.ffmpeg.avutil.AVPixFmtDescriptor.class)).set(av_pix_fmt_descriptors);
				return this;
			}
		}catch (Throwable $ex$) {
			throw new RuntimeException($ex$);
		}
	}
	/// C type : extern const AVPixFmtDescriptor[]
	public final Pointer<AVPixFmtDescriptor > av_pix_fmt_descriptors_$eq(Pointer<AVPixFmtDescriptor > av_pix_fmt_descriptors) {
		av_pix_fmt_descriptors(av_pix_fmt_descriptors);
		return av_pix_fmt_descriptors;
	}
	/**
	 * misc math functions<br>
	 * C type : extern const uint8_t[256]
	 */
	@Array({256}) 
	public Pointer<Byte > ff_log2_tab() {
		try {
			return (Pointer<Byte >)BridJ.getNativeLibrary("avutil").getSymbolPointer("ff_log2_tab").as(org.bridj.util.DefaultParameterizedType.paramType(org.bridj.Pointer.class, java.lang.Byte.class)).get();
		}catch (Throwable $ex$) {
			throw new RuntimeException($ex$);
		}
	}
	/// C type : extern const uint8_t[256]
	@Array({256}) 
	public Pointer<Byte > av_reverse() {
		try {
			return (Pointer<Byte >)BridJ.getNativeLibrary("avutil").getSymbolPointer("av_reverse").as(org.bridj.util.DefaultParameterizedType.paramType(org.bridj.Pointer.class, java.lang.Byte.class)).get();
		}catch (Throwable $ex$) {
			throw new RuntimeException($ex$);
		}
	}
	/// Conversion Error : null (void type !)
	public int av_md5_size() {
		try {
			return (int)BridJ.getNativeLibrary("avutil").getSymbolPointer("av_md5_size").as(int.class).get();
		}catch (Throwable $ex$) {
			throw new RuntimeException($ex$);
		}
	}
	public AvutilLibrary av_md5_size(int av_md5_size) {
		try {
			{
				BridJ.getNativeLibrary("avutil").getSymbolPointer("av_md5_size").as(int.class).set(av_md5_size);
				return this;
			}
		}catch (Throwable $ex$) {
			throw new RuntimeException($ex$);
		}
	}
	public final int av_md5_size_$eq(int av_md5_size) {
		av_md5_size(av_md5_size);
		return av_md5_size;
	}
	public int av_tree_node_size() {
		try {
			return (int)BridJ.getNativeLibrary("avutil").getSymbolPointer("av_tree_node_size").as(int.class).get();
		}catch (Throwable $ex$) {
			throw new RuntimeException($ex$);
		}
	}
	public AvutilLibrary av_tree_node_size(int av_tree_node_size) {
		try {
			{
				BridJ.getNativeLibrary("avutil").getSymbolPointer("av_tree_node_size").as(int.class).set(av_tree_node_size);
				return this;
			}
		}catch (Throwable $ex$) {
			throw new RuntimeException($ex$);
		}
	}
	public final int av_tree_node_size_$eq(int av_tree_node_size) {
		av_tree_node_size(av_tree_node_size);
		return av_tree_node_size;
	}
	/// C type : extern const uint32_t[257]
	@Array({257}) 
	public Pointer<Integer > ff_inverse() {
		try {
			return (Pointer<Integer >)BridJ.getNativeLibrary("avutil").getSymbolPointer("ff_inverse").as(org.bridj.util.DefaultParameterizedType.paramType(org.bridj.Pointer.class, java.lang.Integer.class)).get();
		}catch (Throwable $ex$) {
			throw new RuntimeException($ex$);
		}
	}
	/// C type : extern const uint8_t[256]
	@Array({256}) 
	public Pointer<Byte > ff_sqrt_tab() {
		try {
			return (Pointer<Byte >)BridJ.getNativeLibrary("avutil").getSymbolPointer("ff_sqrt_tab").as(org.bridj.util.DefaultParameterizedType.paramType(org.bridj.Pointer.class, java.lang.Byte.class)).get();
		}catch (Throwable $ex$) {
			throw new RuntimeException($ex$);
		}
	}
	public int b() {
		try {
			return (int)BridJ.getNativeLibrary("avutil").getSymbolPointer("b").as(int.class).get();
		}catch (Throwable $ex$) {
			throw new RuntimeException($ex$);
		}
	}
	public AvutilLibrary b(int b) {
		try {
			{
				BridJ.getNativeLibrary("avutil").getSymbolPointer("b").as(int.class).set(b);
				return this;
			}
		}catch (Throwable $ex$) {
			throw new RuntimeException($ex$);
		}
	}
	public final int b_$eq(int b) {
		b(b);
		return b;
	}
	/// Undefined type
	public static interface AVExpr {
		
	};
	/// Undefined type
	public static interface AVSHA {
		
	};
	/// Undefined type
	public static interface AVAES {
		
	};
	/// Undefined type
	public static interface AVSHA1 {
		
	};
	/// Undefined type
	public static interface av_const {
		
	};
	/// Undefined type
	public static interface AVMD5 {
		
	};
	/// Undefined type
	public static interface PCA {
		
	};
}
