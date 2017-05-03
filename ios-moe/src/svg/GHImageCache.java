package svg;


import apple.NSObject;
import apple.foundation.*;
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
import org.moe.natj.objc.ann.ObjCBlock;
import org.moe.natj.objc.ann.ObjCClassBinding;
import org.moe.natj.objc.ann.Selector;
import org.moe.natj.objc.map.ObjCObjectMapper;

@Generated
@Library("SVGgh")
@Runtime(ObjCRuntime.class)
@ObjCClassBinding
public class GHImageCache extends NSObject {
	static {
		NatJ.register();
	}

	@Generated
	protected GHImageCache(Pointer peer) {
		super(peer);
	}

	@Generated
	@Selector("aSyncRetrieveCachedImageFromURL:intoCallback:")
	public static native void aSyncRetrieveCachedImageFromURLIntoCallback(
			NSURL aURL,
			@ObjCBlock(name = "call_aSyncRetrieveCachedImageFromURLIntoCallback") Block_aSyncRetrieveCachedImageFromURLIntoCallback retrievalCallback);

	@Runtime(ObjCRuntime.class)
	@Generated
	public interface Block_aSyncRetrieveCachedImageFromURLIntoCallback {
		@Generated
		void call_aSyncRetrieveCachedImageFromURLIntoCallback(UIImage arg0,
                                                              NSURL arg1);
	}

	@Generated
	@Selector("accessInstanceVariablesDirectly")
	public static native boolean accessInstanceVariablesDirectly();

	@Generated
	@Owned
	@Selector("alloc")
	public static native GHImageCache alloc();

	@Generated
	@Selector("allocWithZone:")
	@MappedReturn(ObjCObjectMapper.class)
	public static native Object allocWithZone(VoidPtr zone);

	@Generated
	@Selector("automaticallyNotifiesObserversForKey:")
	public static native boolean automaticallyNotifiesObserversForKey(String key);

	@Generated
	@Selector("cacheImage:forName:")
	public static native void cacheImageForName(UIImage anImage, String aName);

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
	@Selector("extractFaceImageFromPickedImage:withCallback:")
	public static native void extractFaceImageFromPickedImageWithCallback(
			UIImage anImage,
			@ObjCBlock(name = "call_extractFaceImageFromPickedImageWithCallback") Block_extractFaceImageFromPickedImageWithCallback callback);

	@Runtime(ObjCRuntime.class)
	@Generated
	public interface Block_extractFaceImageFromPickedImageWithCallback {
		@Generated
		void call_extractFaceImageFromPickedImageWithCallback(NSError arg0,
                                                              NSArray<?> arg1, NSArray<?> arg2);
	}

	@Generated
	@Selector("hash")
	@NUInt
	public static native long hash_static();

	@Generated
	@Selector("init")
	public native GHImageCache init();

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
	@Selector("invalidateImageWithName:")
	public static native void invalidateImageWithName(String aName);

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
	@Selector("retrieveCachedImageFromURL:intoCallback:")
	public static native void retrieveCachedImageFromURLIntoCallback(
			NSURL aURL,
			@ObjCBlock(name = "call_retrieveCachedImageFromURLIntoCallback") Block_retrieveCachedImageFromURLIntoCallback retrievalCallback);

	@Runtime(ObjCRuntime.class)
	@Generated
	public interface Block_retrieveCachedImageFromURLIntoCallback {
		@Generated
		void call_retrieveCachedImageFromURLIntoCallback(UIImage arg0,
                                                         NSURL arg1);
	}

	@Generated
	@Selector("saveImageData:withName:withCallback:")
	public static native void saveImageDataWithNameWithCallback(
			NSData imageData,
			String preferredName,
			@ObjCBlock(name = "call_saveImageDataWithNameWithCallback") Block_saveImageDataWithNameWithCallback callback);

	@Runtime(ObjCRuntime.class)
	@Generated
	public interface Block_saveImageDataWithNameWithCallback {
		@Generated
		void call_saveImageDataWithNameWithCallback(UIImage arg0, NSURL arg1);
	}

	@Generated
	@Selector("setCachedImage:forURL:")
	public static native void setCachedImageForURL(UIImage anImage,
			NSURL aFileURL);

	@Generated
	@Selector("setVersion:")
	public static native void setVersion(@NInt long aVersion);

	@Generated
	@Selector("superclass")
	public static native Class superclass_static();

	@Generated
	@Selector("uncacheImageForName:")
	public static native UIImage uncacheImageForName(String uniqueName);

	@Generated
	@Selector("uniqueFilenameWithExtension:")
	public static native String uniqueFilenameWithExtension(String extension);

	@Generated
	@Selector("version")
	@NInt
	public static native long version_static();
}