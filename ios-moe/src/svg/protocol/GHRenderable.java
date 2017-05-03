package svg.protocol;


import apple.coregraphics.opaque.CGContextRef;
import apple.coregraphics.struct.CGAffineTransform;
import apple.coregraphics.struct.CGPoint;
import apple.coregraphics.struct.CGRect;
import apple.foundation.NSDictionary;
import org.moe.natj.general.ann.*;
import org.moe.natj.general.ann.Runtime;
import org.moe.natj.objc.ObjCRuntime;
import org.moe.natj.objc.ann.ObjCProtocolName;
import org.moe.natj.objc.ann.Selector;
import org.moe.natj.objc.map.ObjCObjectMapper;

@Generated
@Library("SVGgh")
@Runtime(ObjCRuntime.class)
@ObjCProtocolName("GHRenderable")
public interface GHRenderable {
	@Generated
	@Selector("addToClipForContext:withSVGContext:objectBoundingBox:")
	void addToClipForContextWithSVGContextObjectBoundingBox(
            CGContextRef quartzContext,
            @Mapped(ObjCObjectMapper.class) Object svgContext,
            @ByValue CGRect objectBox);

	@Generated
	@Selector("addToClipPathForContext:withSVGContext:objectBoundingBox:")
	void addToClipPathForContextWithSVGContextObjectBoundingBox(
            CGContextRef quartzContext,
            @Mapped(ObjCObjectMapper.class) Object svgContext,
            @ByValue CGRect objectBox);

	@Generated
	@Selector("attributes")
	NSDictionary<?, ?> attributes();

	@Generated
	@Selector("findRenderableObject:withSVGContext:")
	@MappedReturn(ObjCObjectMapper.class)
	Object findRenderableObjectWithSVGContext(@ByValue CGPoint testPoint,
                                              @Mapped(ObjCObjectMapper.class) Object svgContext);

	@Generated
	@Selector("getBoundingBoxWithSVGContext:")
	@ByValue
	CGRect getBoundingBoxWithSVGContext(
            @Mapped(ObjCObjectMapper.class) Object svgContext);

	@Generated
	@Selector("getClippingTypeWithSVGContext:")
	int getClippingTypeWithSVGContext(
            @Mapped(ObjCObjectMapper.class) Object svgContext);

	@Generated
	@Selector("hidden")
	boolean hidden();

	@Generated
	@Selector("renderIntoContext:withSVGContext:")
	void renderIntoContextWithSVGContext(CGContextRef quartzContext,
                                         @Mapped(ObjCObjectMapper.class) Object svgContext);

	@Generated
	@Selector("transform")
	@ByValue
	CGAffineTransform transform();
}