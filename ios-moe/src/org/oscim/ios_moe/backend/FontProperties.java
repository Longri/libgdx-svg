package org.oscim.ios_moe.backend;

import apple.NSObject;
import apple.corefoundation.c.CoreFoundation;
import apple.corefoundation.opaque.CFMutableDictionaryRef;
import apple.coretext.c.CoreText;
import apple.foundation.NSNumber;
import apple.uikit.UIColor;
import apple.uikit.UIFont;
import org.moe.natj.general.Pointer;
import org.moe.natj.general.ann.NFloat;
import org.moe.natj.general.ptr.*;
import org.moe.natj.general.ptr.impl.PtrFactory;
import org.moe.natj.objc.ObjCRuntime;

/**
 * Created by longri on 06.05.17.
 */
public class FontProperties implements CFMutableDictionaryRef {

    private static CFMutableDictionaryRef attributes = CoreFoundation.CFDictionaryCreateMutable(null, 20, CoreFoundation.kCFTypeDictionaryKeyCallBacks(), CoreFoundation.kCFTypeDictionaryValueCallBacks());


    @Override
    public Pointer getPeer() {
        return attributes.getPeer();
    }

    @Override
    public boolean isConstPtr() {
        return attributes.isConstPtr();
    }

    @Override
    public int getDepth() {
        return attributes.getDepth();
    }

    @Override
    public void free() {
        attributes.free();
    }

    @Override
    public void forceFree() {
        attributes.forceFree();
    }

    @Override
    public ConstBoolPtr getBoolPtr() {
        return attributes.getBoolPtr();
    }

    @Override
    public ConstBytePtr getBytePtr() {
        return attributes.getBytePtr();
    }

    @Override
    public ConstShortPtr getShortPtr() {
        return attributes.getShortPtr();
    }

    @Override
    public ConstCharPtr getCharPtr() {
        return attributes.getCharPtr();
    }

    @Override
    public ConstIntPtr getIntPtr() {
        return attributes.getIntPtr();
    }

    @Override
    public ConstLongPtr getLongPtr() {
        return attributes.getLongPtr();
    }

    @Override
    public ConstFloatPtr getFloatPtr() {
        return attributes.getFloatPtr();
    }

    @Override
    public ConstDoublePtr getDoublePtr() {
        return attributes.getDoublePtr();
    }

    @Override
    public ConstNFloatPtr getNFloatPtr() {
        return attributes.getNFloatPtr();
    }

    @Override
    public ConstNUIntPtr getNUIntPtr() {
        return attributes.getNUIntPtr();
    }

    @Override
    public ConstNIntPtr getNIntPtr() {
        return attributes.getNIntPtr();
    }

    @Override
    public ConstNULongPtr getNULongPtr() {
        return attributes.getNULongPtr();
    }

    @Override
    public ConstNLongPtr getNLongPtr() {
        return attributes.getNLongPtr();
    }

    public void setFont(UIFont uiFont) {
        CoreFoundation.CFDictionarySetValue(attributes, CoreText.kCTFontAttributeName(), new Ref(uiFont));
    }

    public void setForgroundColor(UIColor uiColor) {
        CoreFoundation.CFDictionarySetValue(attributes, CoreText.kCTForegroundColorAttributeName(), new Ref(uiColor));
    }

    public void setStrokeColor(UIColor uiColor) {
        CoreFoundation.CFDictionarySetValue(attributes, CoreText.kCTStrokeColorAttributeName(), new Ref(uiColor));
    }

    public void setStrokeWidth(double strokeWidthPercent) {
        NSNumber number = NSNumber.numberWithDouble(strokeWidthPercent);
        CoreFoundation.CFDictionarySetValue(attributes, CoreText.kCTStrokeWidthAttributeName(), new Ref(number));
    }


    private class Ref extends NSObject implements ConstVoidPtr {

        private Ref(NSObject ref) {
            super(ref.getPeer());
        }


        @Override
        public boolean isConstPtr() {
            return true;
        }

        @Override
        public int getDepth() {
            return 0;
        }

        @Override
        public void free() {

        }

        @Override
        public void forceFree() {

        }

        @Override
        public ConstBoolPtr getBoolPtr() {
            return null;
        }

        @Override
        public ConstBytePtr getBytePtr() {
            return null;
        }

        @Override
        public ConstShortPtr getShortPtr() {
            return null;
        }

        @Override
        public ConstCharPtr getCharPtr() {
            return null;
        }

        @Override
        public ConstIntPtr getIntPtr() {
            return null;
        }

        @Override
        public ConstLongPtr getLongPtr() {
            return null;
        }

        @Override
        public ConstFloatPtr getFloatPtr() {
            return null;
        }

        @Override
        public ConstDoublePtr getDoublePtr() {
            return null;
        }

        @Override
        public ConstNFloatPtr getNFloatPtr() {
            return null;
        }

        @Override
        public ConstNUIntPtr getNUIntPtr() {
            return null;
        }

        @Override
        public ConstNIntPtr getNIntPtr() {
            return null;
        }

        @Override
        public ConstNULongPtr getNULongPtr() {
            return null;
        }

        @Override
        public ConstNLongPtr getNLongPtr() {
            return null;
        }
    }
}
