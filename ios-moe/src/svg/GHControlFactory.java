package svg;


import apple.NSObject;
import apple.coregraphics.opaque.CGGradientRef;
import apple.coregraphics.opaque.CGPathRef;
import apple.coregraphics.struct.CGRect;
import apple.foundation.*;
import apple.uikit.UIColor;
import org.moe.natj.c.ann.FunctionPtr;
import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.general.ann.*;
import org.moe.natj.general.ann.Runtime;
import org.moe.natj.general.ptr.VoidPtr;
import org.moe.natj.objc.Class;
import org.moe.natj.objc.ObjCRuntime;
import org.moe.natj.objc.SEL;
import org.moe.natj.objc.ann.ObjCClassBinding;
import org.moe.natj.objc.ann.Selector;
import org.moe.natj.objc.map.ObjCObjectMapper;

@Generated
@Library("SVGgh")
@Runtime(ObjCRuntime.class)
@ObjCClassBinding
public class GHControlFactory extends NSObject {
	static {
		NatJ.register();
	}

	@Generated
	protected GHControlFactory(Pointer peer) {
		super(peer);
	}

	@Generated
	@Selector("accessInstanceVariablesDirectly")
	public static native boolean accessInstanceVariablesDirectly();

	@Generated
	@Owned
	@Selector("alloc")
	public static native GHControlFactory alloc();

	@Generated
	@Selector("allocWithZone:")
	@MappedReturn(ObjCObjectMapper.class)
	public static native Object allocWithZone(VoidPtr zone);

	@Generated
	@Selector("automaticallyNotifiesObserversForKey:")
	public static native boolean automaticallyNotifiesObserversForKey(String key);

	@Generated
	@Selector("buttonTint")
	public static native UIColor buttonTint();

	@Generated
	@Selector("cancelPreviousPerformRequestsWithTarget:")
	public static native void cancelPreviousPerformRequestsWithTarget(
			@Mapped(ObjCObjectMapper.class) Object aTarget);

	@Generated
	@Selector("cancelPreviousPerformRequestsWithTarget:selector:object:")
	public static native void cancelPreviousPerformRequestsWithTargetSelectorObject(
			@Mapped(ObjCObjectMapper.class) Object aTarget, SEL aSelector,
			@Mapped(ObjCObjectMapper.class) Object anArgument);

	@Generated
	@Selector("class")
	public static native Class class_objc_static();

	@Generated
	@Selector("classFallbacksForKeyedArchiver")
	public static native NSArray<String> classFallbacksForKeyedArchiver();

	@Generated
	@Selector("classForKeyedUnarchiver")
	public static native Class classForKeyedUnarchiver();

	@Generated
	@Selector("debugDescription")
	public static native String debugDescription_static();

	@Generated
	@Selector("defaultScheme")
	@NUInt
	public static native long defaultScheme();

	@Generated
	@Selector("description")
	public static native String description_static();

	@Generated
	@Selector("findInterfaceBuilderArtwork:")
	public static native NSURL findInterfaceBuilderArtwork(String artworkSubPath);

	@Generated
	@Selector("hash")
	@NUInt
	public static native long hash_static();

	@Generated
	@Selector("init")
	public native GHControlFactory init();

	@Generated
	@Selector("initialize")
	public static native void initialize();

	@Generated
	@Selector("instanceMethodForSelector:")
	@FunctionPtr(name = "call_instanceMethodForSelector_ret")
	public static native Function_instanceMethodForSelector_ret instanceMethodForSelector(
			SEL aSelector);

	@Generated
	@Selector("instanceMethodSignatureForSelector:")
	public static native NSMethodSignature instanceMethodSignatureForSelector(
			SEL aSelector);

	@Generated
	@Selector("instancesRespondToSelector:")
	public static native boolean instancesRespondToSelector(SEL aSelector);

	@Generated
	@Selector("isSubclassOfClass:")
	public static native boolean isSubclassOfClass(Class aClass);

	@Generated
	@Selector("isValidColorScheme:")
	public static native boolean isValidColorScheme(@NUInt long scheme);

	@Generated
	@Selector("keyPathsForValuesAffectingValueForKey:")
	public static native NSSet<String> keyPathsForValuesAffectingValueForKey(
			String key);

	@Generated
	@Selector("load")
	public static native void load_objc_static();

	@Generated
	@Selector("locateArtworkForBundle:atSubpath:")
	public static native NSURL locateArtworkForBundleAtSubpath(
			NSBundle mayBeNil, String theArtworkPath);

	@Generated
	@Selector("locateArtworkForObject:atSubpath:")
	public static native NSURL locateArtworkForObjectAtSubpath(
			@Mapped(ObjCObjectMapper.class) apple.protocol.NSObject anObject,
			String theArtworkPath);

	@Generated
	@Owned
	@Selector("new")
	@MappedReturn(ObjCObjectMapper.class)
	public static native Object new_objc();

	@Generated
	@Selector("newButtonBackgroundGradientForScheme:")
	public static native CGGradientRef newButtonBackgroundGradientForScheme(
			@NUInt long scheme);

	@Generated
	@Selector("newButtonBackgroundGradientPressedForScheme:")
	public static native CGGradientRef newButtonBackgroundGradientPressedForScheme(
			@NUInt long scheme);

	@Generated
	@Selector("newButtonBackgroundGradientSelectedForScheme:")
	public static native CGGradientRef newButtonBackgroundGradientSelectedForScheme(
			@NUInt long scheme);

	@Generated
	@Owned
	@Selector("newButtonForScheme:")
	public static native GHButton newButtonForScheme(@NUInt long scheme);

	@Generated
	@Owned
	@Selector("newColor:withBrightnessDelta:")
	public static native UIColor newColorWithBrightnessDelta(
			UIColor originalColor, @NFloat double brightnessDelta);

	@Generated
	@Owned
	@Selector("newLightBackgroundColorForScheme:")
	public static native UIColor newLightBackgroundColorForScheme(
			@NUInt long scheme);

	@Generated
	@Owned
	@Selector("newPressedColorForColor:forScheme:")
	public static native UIColor newPressedColorForColorForScheme(
			UIColor originalColor, @NUInt long scheme);

	@Generated
	@Owned
	@Selector("newRingColorForScheme:")
	public static native UIColor newRingColorForScheme(@NUInt long scheme);

	@Generated
	@Selector("newRoundRectPathForRect:withRadius:")
	public static native CGPathRef newRoundRectPathForRectWithRadius(
			@ByValue CGRect aRect, @NFloat double radius);

	@Generated
	@Owned
	@Selector("newTextColorForScheme:")
	public static native UIColor newTextColorForScheme(@NUInt long scheme);

	@Generated
	@Owned
	@Selector("newTextColorPressedForScheme:")
	public static native UIColor newTextColorPressedForScheme(@NUInt long scheme);

	@Generated
	@Owned
	@Selector("newTextShadowColorForScheme:")
	public static native UIColor newTextShadowColorForScheme(@NUInt long scheme);

	@Generated
	@Selector("preferRadialGradientForScheme:")
	public static native boolean preferRadialGradientForScheme(
			@NUInt long scheme);

	@Generated
	@Selector("pressedTextColor")
	public static native UIColor pressedTextColor();

	@Generated
	@Selector("resolveClassMethod:")
	public static native boolean resolveClassMethod(SEL sel);

	@Generated
	@Selector("resolveInstanceMethod:")
	public static native boolean resolveInstanceMethod(SEL sel);

	@Generated
	@Selector("setDefaultButtonTint:")
	public static native void setDefaultButtonTint(UIColor buttonTint);

	@Generated
	@Selector("setDefaultPressedTextColor:")
	public static native void setDefaultPressedTextColor(
			UIColor defaultPressedTextColor);

	@Generated
	@Selector("setDefaultScheme:")
	public static native void setDefaultScheme(@NUInt long defaultScheme);

	@Generated
	@Selector("setDefaultTextColor:")
	public static native void setDefaultTextColor(UIColor defaultTextColor);

	@Generated
	@Selector("setVersion:")
	public static native void setVersion(@NInt long aVersion);

	@Generated
	@Selector("superclass")
	public static native Class superclass_static();

	@Generated
	@Selector("textColor")
	public static native UIColor textColor();

	@Generated
	@Selector("version")
	@NInt
	public static native long version_static();
}