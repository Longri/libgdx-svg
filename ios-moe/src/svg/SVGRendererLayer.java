package svg;


import apple.coregraphics.struct.CGPoint;
import apple.foundation.NSArray;
import apple.foundation.NSCoder;
import apple.foundation.NSMethodSignature;
import apple.foundation.NSSet;
import apple.quartzcore.CALayer;
import apple.quartzcore.protocol.CAAction;
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
import svg.protocol.GHRenderable;

@Generated
@Library("SVGgh")
@Runtime(ObjCRuntime.class)
@ObjCClassBinding
public class SVGRendererLayer extends CALayer {
	static {
		NatJ.register();
	}

	@Generated
	protected SVGRendererLayer(Pointer peer) {
		super(peer);
	}

	@Generated
	@Selector("accessInstanceVariablesDirectly")
	public static native boolean accessInstanceVariablesDirectly();

	@Generated
	@Owned
	@Selector("alloc")
	public static native SVGRendererLayer alloc();

	@Generated
	@Selector("allocWithZone:")
	@MappedReturn(ObjCObjectMapper.class)
	public static native Object allocWithZone(VoidPtr zone);

	@Generated
	@Selector("automaticallyNotifiesObserversForKey:")
	public static native boolean automaticallyNotifiesObserversForKey(String key);

	@Generated
	@Selector("beTransparent")
	public native boolean beTransparent();

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
	@Selector("defaultActionForKey:")
	@MappedReturn(ObjCObjectMapper.class)
	public static native CAAction defaultActionForKey(String event);

	@Generated
	@Selector("defaultColor")
	public native UIColor defaultColor();

	@Generated
	@Selector("defaultValueForKey:")
	@MappedReturn(ObjCObjectMapper.class)
	public static native Object defaultValueForKey(String key);

	@Generated
	@Selector("description")
	public static native String description_static();

	@Generated
	@Selector("findRenderableObject:")
	@MappedReturn(ObjCObjectMapper.class)
	public native GHRenderable findRenderableObject(@ByValue CGPoint testPoint);

	@Generated
	@Selector("hash")
	@NUInt
	public static native long hash_static();

	@Generated
	@Selector("init")
	public native SVGRendererLayer init();

	@Generated
	@Selector("initWithCoder:")
	public native SVGRendererLayer initWithCoder(NSCoder aDecoder);

	@Generated
	@Selector("initWithLayer:")
	public native SVGRendererLayer initWithLayer(
			@Mapped(ObjCObjectMapper.class) Object layer);

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
	@Selector("keyPathsForValuesAffectingValueForKey:")
	public static native NSSet<String> keyPathsForValuesAffectingValueForKey(
			String key);

	@Generated
	@Selector("layer")
	public static native SVGRendererLayer layer();

	@Generated
	@Selector("load")
	public static native void load_objc_static();

	@Generated
	@Selector("needsDisplayForKey:")
	public static native boolean needsDisplayForKey(String key);

	@Generated
	@Owned
	@Selector("new")
	@MappedReturn(ObjCObjectMapper.class)
	public static native Object new_objc();

	@Generated
	@Selector("renderer")
	public native SVGRenderer renderer();

	@Generated
	@Selector("resolveClassMethod:")
	public static native boolean resolveClassMethod(SEL sel);

	@Generated
	@Selector("resolveInstanceMethod:")
	public static native boolean resolveInstanceMethod(SEL sel);

	@Generated
	@Selector("setBeTransparent:")
	public native void setBeTransparent(boolean value);

	@Generated
	@Selector("setDefaultColor:")
	public native void setDefaultColor(UIColor value);

	@Generated
	@Selector("setRenderer:")
	public native void setRenderer(SVGRenderer value);

	@Generated
	@Selector("setVersion:")
	public static native void setVersion(@NInt long aVersion);

	@Generated
	@Selector("superclass")
	public static native Class superclass_static();

	@Generated
	@Selector("version")
	@NInt
	public static native long version_static();
}