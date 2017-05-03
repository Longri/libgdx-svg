package svg.protocol;


import apple.uikit.UIColor;
import org.moe.natj.general.ann.Generated;
import org.moe.natj.general.ann.Library;
import org.moe.natj.general.ann.Owned;
import org.moe.natj.general.ann.Runtime;
import org.moe.natj.objc.ObjCRuntime;
import org.moe.natj.objc.ann.ObjCProtocolName;
import org.moe.natj.objc.ann.Selector;

@Generated
@Library("SVGgh")
@Runtime(ObjCRuntime.class)
@ObjCProtocolName("FillColorProtocol")
public interface FillColorProtocol {
	@Generated
	@Owned
	@Selector("copyFillColor")
	UIColor copyFillColor();
}