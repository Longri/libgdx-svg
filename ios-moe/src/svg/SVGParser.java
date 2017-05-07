package svg;


import apple.NSObject;
import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.general.ann.Generated;
import org.moe.natj.general.ann.Library;
import org.moe.natj.general.ann.NInt;
import org.moe.natj.general.ann.Runtime;
import org.moe.natj.objc.ObjCRuntime;
import org.moe.natj.objc.ann.ObjCClassBinding;
import org.moe.natj.objc.ann.Selector;

@Generated
@Library("SVGgh")
@Runtime(ObjCRuntime.class)
@ObjCClassBinding
public class SVGParser extends NSObject {
    static {
        NatJ.register();
    }

    @Generated
    protected SVGParser(Pointer peer) {
        super(peer);
    }


    @Generated
    @Selector("init")
    public native SVGParser init();


    @Generated
    @Selector("initWithString:")
    public native SVGParser initWithString(String utf8String);

    @Generated
    @Selector("setVersion:")
    public static native void setVersion(@NInt long aVersion);

}