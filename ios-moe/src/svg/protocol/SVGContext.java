package svg.protocol;


import apple.foundation.NSArray;
import apple.foundation.NSURL;
import apple.uikit.UIColor;
import org.moe.natj.general.ann.*;
import org.moe.natj.general.ann.Runtime;
import org.moe.natj.objc.ObjCRuntime;
import org.moe.natj.objc.ann.ObjCProtocolName;
import org.moe.natj.objc.ann.Selector;
import org.moe.natj.objc.map.ObjCObjectMapper;

@Generated
@Library("SVGgh")
@Runtime(ObjCRuntime.class)
@ObjCProtocolName("SVGContext")
public interface SVGContext {
	@Generated
	@Selector("absoluteURL:")
	NSURL absoluteURL(String absolutePath);

	@Generated
	@Selector("attributeNamed:classes:entityName:")
	String attributeNamedClassesEntityName(String attributeName,
                                           NSArray<String> listOfClasses, String entityName);

	@Generated
	@Selector("colorForSVGColorString:")
	UIColor colorForSVGColorString(String svgColorString);

	@Generated
	@Selector("currentColor")
	UIColor currentColor();

	@Generated
	@Selector("explicitLineScaling")
	@NFloat
	double explicitLineScaling();

	@Generated
	@Selector("hasCSSAttributes")
	boolean hasCSSAttributes();

	@Generated
	@Selector("isoLanguage")
	String isoLanguage();

	@Generated
	@Selector("objectAtURL:")
	@MappedReturn(ObjCObjectMapper.class)
	Object objectAtURL(String aLocation);

	@Generated
	@Selector("objectNamed:")
	@MappedReturn(ObjCObjectMapper.class)
	Object objectNamed(String objectName);

	@Generated
	@Selector("opacity")
	@NFloat
	double opacity();

	@Generated
	@Selector("relativeURL:")
	NSURL relativeURL(String subPath);

	@Generated
	@Selector("setCurrentColor:")
	void setCurrentColor(UIColor startingCurrentColor);

	@Generated
	@Selector("setOpacity:")
	void setOpacity(@NFloat double opacity);
}