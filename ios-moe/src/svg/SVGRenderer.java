package svg;


import apple.NSObject;
import apple.coregraphics.opaque.CGContextRef;
import apple.coregraphics.struct.CGAffineTransform;
import apple.coregraphics.struct.CGPoint;
import apple.coregraphics.struct.CGRect;
import apple.coregraphics.struct.CGSize;
import apple.foundation.*;
import apple.uikit.UIColor;
import apple.uikit.UIImage;
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
import svg.protocol.GHRenderable;
import svg.protocol.SVGContext;

@Generated
@Library("SVGgh")
@Runtime(ObjCRuntime.class)
@ObjCClassBinding
public class SVGRenderer extends SVGParser implements SVGContext, GHRenderable {
	static {
		NatJ.register();
	}

	@Generated
	public SVGRenderer(Pointer peer) {
		super(peer);
	}


	@Generated
	@Selector("absoluteURL:")
	public native NSURL absoluteURL(String absolutePath);

	@Generated
	@Selector("accessInstanceVariablesDirectly")
	public static native boolean accessInstanceVariablesDirectly();

	@Generated
	@Selector("addToClipForContext:withSVGContext:objectBoundingBox:")
	public native void addToClipForContextWithSVGContextObjectBoundingBox(
			CGContextRef quartzContext,
			@Mapped(ObjCObjectMapper.class) Object svgContext,
			@ByValue CGRect objectBox);

	@Generated
	@Selector("addToClipPathForContext:withSVGContext:objectBoundingBox:")
	public native void addToClipPathForContextWithSVGContextObjectBoundingBox(
			CGContextRef quartzContext,
			@Mapped(ObjCObjectMapper.class) Object svgContext,
			@ByValue CGRect objectBox);

	@Generated
	@Owned
	@Selector("alloc")
	public static native SVGRenderer alloc();

	@Generated
	@Selector("allocWithZone:")
	@MappedReturn(ObjCObjectMapper.class)
	public static native Object allocWithZone(VoidPtr zone);

	@Generated
	@Selector("asImageWithSize:andScale:")
	public native UIImage asImageWithSizeAndScale(@ByValue CGSize maximumSize,
			@NFloat double scale);

	@Generated
	@Selector("attributeNamed:classes:entityName:")
	public native String attributeNamedClassesEntityName(String attributeName,
			NSArray<String> listOfClasses, String entityName);

	@Generated
	@Selector("attributes")
	public native NSDictionary<?, ?> attributes();

	@Generated
	@Selector("automaticallyNotifiesObserversForKey:")
	public static native boolean automaticallyNotifiesObserversForKey(String key);

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
	@Selector("colorForSVGColorString:")
	public native UIColor colorForSVGColorString(String svgColorString);

	@Generated
	@Selector("cssPseudoClass")
	@NUInt
	public native long cssPseudoClass();

	@Generated
	@Selector("currentColor")
	public native UIColor currentColor();

	@Generated
	@Selector("debugDescription")
	public static native String debugDescription_static();

	@Generated
	@Selector("description")
	public static native String description_static();

	@Generated
	@Selector("explicitLineScaling")
	@NFloat
	public native double explicitLineScaling();

//	@Generated
//	@Selector("findRenderableObject:")
//	@MappedReturn(ObjCObjectMapper.class)
//	public native GHRenderable findRenderableObject(@ByValue CGPoint testPoint);

	@Generated
	@Selector("findRenderableObject:withSVGContext:")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object findRenderableObjectWithSVGContext(
			@ByValue CGPoint testPoint,
			@Mapped(ObjCObjectMapper.class) Object svgContext);

	@Generated
	@Selector("getBoundingBoxWithSVGContext:")
	@ByValue
	public native CGRect getBoundingBoxWithSVGContext(
			@Mapped(ObjCObjectMapper.class) Object svgContext);

	@Generated
	@Selector("getClippingTypeWithSVGContext:")
	public native int getClippingTypeWithSVGContext(
			@Mapped(ObjCObjectMapper.class) Object svgContext);

	@Generated
	@Selector("hasCSSAttributes")
	public native boolean hasCSSAttributes();

	@Generated
	@Selector("hash")
	@NUInt
	public static native long hash_static();

	@Generated
	@Selector("hidden")
	public native boolean hidden();

	@Generated
	@Selector("init")
	public native SVGRenderer init();

	@Generated
	@Selector("initWithContentsOfURL:")
	public native SVGRenderer initWithContentsOfURL(NSURL url);

	@Generated
	@Selector("initWithDataAssetNamed:withBundle:")
	public native SVGRenderer initWithDataAssetNamedWithBundle(
			String assetName, NSBundle bundle);

	@Generated
	@Selector("initWithInputStream:")
	public native SVGRenderer initWithInputStream(NSInputStream inputStream);

	@Generated
	@Selector("initWithResourceName:inBundle:")
	public native SVGRenderer initWithResourceNameInBundle(String resourceName,
			NSBundle bundle);

	@Generated
	@Selector("initWithString:")
	public native SVGRenderer initWithString(String utf8String);

	@Generated
	@Selector("initialize")
	public static native void initialize();

	@Generated
	@Selector("instanceMethodForSelector:")
	@FunctionPtr(name = "call_instanceMethodForSelector_ret")
	public static native NSObject.Function_instanceMethodForSelector_ret instanceMethodForSelector(
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
	@Selector("isoLanguage")
	public native String isoLanguage();

	@Generated
	@Selector("keyPathsForValuesAffectingValueForKey:")
	public static native NSSet<String> keyPathsForValuesAffectingValueForKey(
			String key);

	@Generated
	@Selector("load")
	public static native void load_objc_static();

	@Generated
	@Owned
	@Selector("new")
	@MappedReturn(ObjCObjectMapper.class)
	public static native Object new_objc();

	@Generated
	@Selector("objectAtURL:")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object objectAtURL(String aLocation);

	@Generated
	@Selector("objectNamed:")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object objectNamed(String objectName);

	@Generated
	@Selector("opacity")
	@NFloat
	public native double opacity();

	@Generated
	@Selector("relativeURL:")
	public native NSURL relativeURL(String subPath);

	@Generated
	@Selector("renderIntoContext:")
	public native void renderIntoContext(CGContextRef quartzContext);

	@Generated
	@Selector("renderIntoContext:withSVGContext:")
	public native void renderIntoContextWithSVGContext(
			CGContextRef quartzContext,
			@Mapped(ObjCObjectMapper.class) Object svgContext);

	@Generated
	@Selector("rendererQueue")
	public static native NSOperationQueue rendererQueue();

	@Generated
	@Selector("resolveClassMethod:")
	public static native boolean resolveClassMethod(SEL sel);

	@Generated
	@Selector("resolveInstanceMethod:")
	public static native boolean resolveInstanceMethod(SEL sel);

	@Generated
	@Selector("setCssPseudoClass:")
	public native void setCssPseudoClass(@NUInt long value);

	@Generated
	@Selector("setCurrentColor:")
	public native void setCurrentColor(UIColor startingCurrentColor);

	@Generated
	@Selector("setOpacity:")
	public native void setOpacity(@NFloat double opacity);

	@Generated
	@Selector("setVersion:")
	public static native void setVersion(@NInt long aVersion);

	@Generated
	@Selector("superclass")
	public static native Class superclass_static();

	@Generated
	@Selector("transform")
	@ByValue
	public native CGAffineTransform transform();

	@Generated
	@Selector("version")
	@NInt
	public static native long version_static();

	@Generated
	@Selector("viewRect")
	@ByValue
	public native CGRect viewRect();
}