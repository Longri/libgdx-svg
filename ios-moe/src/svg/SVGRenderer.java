package svg;


import apple.coregraphics.struct.CGRect;
import apple.coregraphics.struct.CGSize;
import apple.uikit.UIImage;
import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.general.ann.*;
import org.moe.natj.general.ann.Runtime;
import org.moe.natj.objc.ObjCRuntime;
import org.moe.natj.objc.ann.ObjCClassBinding;
import org.moe.natj.objc.ann.Selector;

@Generated
@Library("SVGgh")
@Runtime(ObjCRuntime.class)
@ObjCClassBinding
public class SVGRenderer extends SVGParser {
    static {
        NatJ.register();
    }

    @Generated
    public SVGRenderer(Pointer peer) {
        super(peer);
    }


    @Generated
    @Owned
    @Selector("alloc")
    public static native SVGRenderer alloc();


    @Generated
    @Selector("asImageWithSize:andScale:")
    public native UIImage asImageWithSizeAndScale(@ByValue CGSize maximumSize,
                                                  @NFloat double scale);


    @Generated
    @Selector("viewRect")
    @ByValue
    public native CGRect viewRect();
}