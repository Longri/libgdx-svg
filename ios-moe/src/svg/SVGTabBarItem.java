package svg;


import apple.foundation.NSArray;
import apple.foundation.NSCoder;
import apple.foundation.NSMethodSignature;
import apple.foundation.NSSet;
import apple.uikit.UIColor;
import apple.uikit.UIImage;
import apple.uikit.UITabBarItem;
import apple.uikit.UITraitCollection;
import org.moe.natj.c.ann.FunctionPtr;
import org.moe.natj.c.ann.Variadic;
import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.general.ann.*;
import org.moe.natj.general.ann.Runtime;
import org.moe.natj.general.ptr.VoidPtr;
import org.moe.natj.objc.Class;
import org.moe.natj.objc.ObjCRuntime;
import org.moe.natj.objc.SEL;
import org.moe.natj.objc.ann.ObjCClassBinding;
import org.moe.natj.objc.ann.ProtocolClassMethod;
import org.moe.natj.objc.ann.Selector;
import org.moe.natj.objc.map.ObjCObjectMapper;

@Generated
@Library("SVGgh")
@Runtime(ObjCRuntime.class)
@ObjCClassBinding
public class SVGTabBarItem extends UITabBarItem {
	static {
		NatJ.register();
	}

	@Generated
	protected SVGTabBarItem(Pointer peer) {
		super(peer);
	}

	@Generated
	@Selector("accessInstanceVariablesDirectly")
	public static native boolean accessInstanceVariablesDirectly();

	@Generated
	@Owned
	@Selector("alloc")
	public static native SVGTabBarItem alloc();

	@Generated
	@Selector("allocWithZone:")
	@MappedReturn(ObjCObjectMapper.class)
	public static native Object allocWithZone(VoidPtr zone);

	@Generated
	@Selector("appearance")
	@MappedReturn(ObjCObjectMapper.class)
	public static native Object appearance();

	@Generated
	@ProtocolClassMethod("appearance")
	@MappedReturn(ObjCObjectMapper.class)
	public Object _appearance() {
		return appearance();
	}

	@Generated
	@Selector("appearanceForTraitCollection:")
	@MappedReturn(ObjCObjectMapper.class)
	public static native Object appearanceForTraitCollection(
			UITraitCollection trait);

	@Generated
	@ProtocolClassMethod("appearanceForTraitCollection")
	@MappedReturn(ObjCObjectMapper.class)
	public Object _appearanceForTraitCollection(UITraitCollection trait) {
		return appearanceForTraitCollection(trait);
	}

	@Generated
	@Variadic()
	@Deprecated
	@Selector("appearanceForTraitCollection:whenContainedIn:")
	@MappedReturn(ObjCObjectMapper.class)
	public static native Object appearanceForTraitCollectionWhenContainedIn(
			UITraitCollection trait,
			@Mapped(ObjCObjectMapper.class) Object ContainerClass,
			Object... varargs);

	@Generated
	@Deprecated
	@ProtocolClassMethod("appearanceForTraitCollectionWhenContainedIn")
	@MappedReturn(ObjCObjectMapper.class)
	public Object _appearanceForTraitCollectionWhenContainedIn(
			UITraitCollection trait,
			@Mapped(ObjCObjectMapper.class) Object ContainerClass,
			Object... varargs) {
		return appearanceForTraitCollectionWhenContainedIn(trait,
				ContainerClass, varargs);
	}

	@Generated
	@Selector("appearanceForTraitCollection:whenContainedInInstancesOfClasses:")
	@MappedReturn(ObjCObjectMapper.class)
	public static native Object appearanceForTraitCollectionWhenContainedInInstancesOfClasses(
			UITraitCollection trait, NSArray<?> containerTypes);

	@Generated
	@ProtocolClassMethod("appearanceForTraitCollectionWhenContainedInInstancesOfClasses")
	@MappedReturn(ObjCObjectMapper.class)
	public Object _appearanceForTraitCollectionWhenContainedInInstancesOfClasses(
			UITraitCollection trait, NSArray<?> containerTypes) {
		return appearanceForTraitCollectionWhenContainedInInstancesOfClasses(
				trait, containerTypes);
	}

	@Generated
	@Variadic()
	@Deprecated
	@Selector("appearanceWhenContainedIn:")
	@MappedReturn(ObjCObjectMapper.class)
	public static native Object appearanceWhenContainedIn(
			@Mapped(ObjCObjectMapper.class) Object ContainerClass,
			Object... varargs);

	@Generated
	@Deprecated
	@ProtocolClassMethod("appearanceWhenContainedIn")
	@MappedReturn(ObjCObjectMapper.class)
	public Object _appearanceWhenContainedIn(
			@Mapped(ObjCObjectMapper.class) Object ContainerClass,
			Object... varargs) {
		return appearanceWhenContainedIn(ContainerClass, varargs);
	}

	@Generated
	@Selector("appearanceWhenContainedInInstancesOfClasses:")
	@MappedReturn(ObjCObjectMapper.class)
	public static native Object appearanceWhenContainedInInstancesOfClasses(
			NSArray<?> containerTypes);

	@Generated
	@ProtocolClassMethod("appearanceWhenContainedInInstancesOfClasses")
	@MappedReturn(ObjCObjectMapper.class)
	public Object _appearanceWhenContainedInInstancesOfClasses(
			NSArray<?> containerTypes) {
		return appearanceWhenContainedInInstancesOfClasses(containerTypes);
	}

	@Generated
	@Selector("artworkPath")
	public native String artworkPath();

	@Generated
	@Selector("automaticallyNotifiesObserversForKey:")
	public static native boolean automaticallyNotifiesObserversForKey(String key);

	@Generated
	@Selector("baseColor")
	public native UIColor baseColor();

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
	@Selector("description")
	public static native String description_static();

	@Generated
	@Selector("hash")
	@NUInt
	public static native long hash_static();

	@Generated
	@Selector("init")
	public native SVGTabBarItem init();

	@Generated
	@Selector("initWithCoder:")
	public native SVGTabBarItem initWithCoder(NSCoder aDecoder);

	@Generated
	@Selector("initWithTabBarSystemItem:tag:")
	public native SVGTabBarItem initWithTabBarSystemItemTag(
			@NInt long systemItem, @NInt long tag);

	@Generated
	@Selector("initWithTitle:image:selectedImage:")
	public native SVGTabBarItem initWithTitleImageSelectedImage(String title,
			UIImage image, UIImage selectedImage);

	@Generated
	@Selector("initWithTitle:image:tag:")
	public native SVGTabBarItem initWithTitleImageTag(String title,
			UIImage image, @NInt long tag);

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
	@Selector("load")
	public static native void load_objc_static();

	@Generated
	@Selector("makeSureLoaded")
	public static native void makeSureLoaded();

	@Generated
	@Owned
	@Selector("new")
	@MappedReturn(ObjCObjectMapper.class)
	public static native Object new_objc();

	@Generated
	@Selector("resolveClassMethod:")
	public static native boolean resolveClassMethod(SEL sel);

	@Generated
	@Selector("resolveInstanceMethod:")
	public static native boolean resolveInstanceMethod(SEL sel);

	@Generated
	@Selector("selectedArtworkPath")
	public native String selectedArtworkPath();

	@Generated
	@Selector("selectedColor")
	public native UIColor selectedColor();

	@Generated
	@Selector("setArtworkPath:")
	public native void setArtworkPath(String value);

	@Generated
	@Selector("setBaseColor:")
	public native void setBaseColor(UIColor value);

	@Generated
	@Selector("setSelectedArtworkPath:")
	public native void setSelectedArtworkPath(String value);

	@Generated
	@Selector("setSelectedColor:")
	public native void setSelectedColor(UIColor value);

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