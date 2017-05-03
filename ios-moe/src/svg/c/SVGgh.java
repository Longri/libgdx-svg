package svg.c;


import apple.corefoundation.opaque.CFMutableDataRef;
import apple.coregraphics.opaque.CGContextRef;
import apple.coregraphics.opaque.CGPathRef;
import apple.coregraphics.struct.CGAffineTransform;
import apple.coregraphics.struct.CGRect;
import apple.uikit.UIColor;
import org.moe.natj.c.CRuntime;
import org.moe.natj.c.ann.CFunction;
import org.moe.natj.c.ann.CVariable;
import org.moe.natj.general.NatJ;
import org.moe.natj.general.ann.*;
import org.moe.natj.general.ann.Runtime;
import org.moe.natj.objc.map.ObjCStringMapper;

@Generated
@Library("SVGgh")
@Runtime(CRuntime.class)
public final class SVGgh {
	static {
		NatJ.register();
	}

	@Generated
	private SVGgh() {
	}

	@Generated
	@CFunction
	public static native UIColor UIColorFromSVGColorString(
			@Mapped(ObjCStringMapper.class) String stringToConvert);

	@Generated
	@CFunction
	public static native CGPathRef CreatePathFromSVGPathString(
			@Mapped(ObjCStringMapper.class) String dAttribute,
			@ByValue CGAffineTransform transformToApply);

	@Generated
	@CFunction
	public static native CGContextRef CreatePDFContext(
			@ByValue CGRect mediaRect, CFMutableDataRef theData);

	@Generated
	@CFunction
	public static native void MakeSureSVGghLinks();

	@Generated
	@CVariable()
	@NFloat
	public static native double kRingThickness();

	@Generated
	@CVariable()
	@NFloat
	public static native double kRoundButtonRadius();

	@Generated
	@CVariable()
	@NFloat
	public static native double kShadowInset();

	@Generated
	@CVariable()
	@MappedReturn(ObjCStringMapper.class)
	public static native String kImageAddedToCacheNotificationName();

	@Generated
	@CVariable()
	@MappedReturn(ObjCStringMapper.class)
	public static native String kImageAddedKey();

	@Generated
	@CVariable()
	@MappedReturn(ObjCStringMapper.class)
	public static native String kImageURLAddedKey();

	@Generated
	@CVariable()
	@MappedReturn(ObjCStringMapper.class)
	public static native String kFacesAddedToCacheNotificationName();

	@Generated
	@CVariable()
	@MappedReturn(ObjCStringMapper.class)
	public static native String kFacesAddedKey();

	@Generated
	@CVariable()
	@MappedReturn(ObjCStringMapper.class)
	public static native String kFacesURLsAddedKey();

	@Generated
	@CVariable()
	public static native int kColoringRenderingIntent();
}