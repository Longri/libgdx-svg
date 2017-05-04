/*
 * Copyright 2016-2017 Longri
 *
 * This program is free software: you can redistribute it and/or modify it under the
 * terms of the GNU Lesser General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A
 * PARTICULAR PURPOSE. See the GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
 */
package org.oscim.ios_moe.backend;

import apple.coregraphics.c.CoreGraphics;
import apple.coregraphics.enums.CGImageAlphaInfo;
import apple.coregraphics.opaque.CGColorRef;
import apple.coregraphics.opaque.CGColorSpaceRef;
import apple.coregraphics.opaque.CGContextRef;
import apple.coregraphics.opaque.CGImageRef;
import apple.coregraphics.struct.CGPoint;
import apple.coregraphics.struct.CGRect;
import apple.coregraphics.struct.CGSize;
import apple.foundation.NSData;
import apple.uikit.UIColor;
import apple.uikit.UIGraphicsImageRendererContext;
import apple.uikit.UIImage;
import apple.uikit.c.UIKit;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.utils.BufferUtils;
import org.moe.natj.general.ptr.BytePtr;
import org.moe.natj.general.ptr.VoidPtr;
import org.moe.natj.general.ptr.impl.PtrFactory;
import org.oscim.backend.AssetAdapter;
import org.oscim.backend.GL;
import org.oscim.backend.canvas.Bitmap;
import org.oscim.backend.canvas.Color;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;

import static apple.coregraphics.c.CoreGraphics.*;

/**
 * iOS specific implementation of {@link Bitmap}.
 */
public class IosBitmap implements Bitmap {

    static final Logger log = LoggerFactory.getLogger(IosBitmap.class);
    CGContextRef cgBitmapContext;
    int width;
    int height;
    private int glInternalFormat = Integer.MIN_VALUE;
    private int glFormat = Integer.MIN_VALUE;
    private int glType = Integer.MIN_VALUE;
    private Buffer directPixelBuffer;
    UIImage image;

    /**
     * Constructor<br>
     * Create a IosBitmap with given width and height. <br>
     * The format is ignored and set always to ARGB8888
     *
     * @param width
     * @param height
     * @param format ignored always ARGB8888
     */
    public IosBitmap(int width, int height, int format) {
        this.width = width;
        this.height = height;
        CGColorSpaceRef rgbColorSpace = CGColorSpaceCreateDeviceRGB();
        this.cgBitmapContext = CoreGraphics.CGBitmapContextCreate(null, width, height, 8, 4 * width,
                rgbColorSpace, CGImageAlphaInfo.PremultipliedLast);
        this.image = UIImage.imageWithCGImage(CGBitmapContextCreateImage(this.cgBitmapContext));
    }

    /**
     * Constructor<br>
     * Create a IosBitmap from given InputStream
     *
     * @param inputStream
     * @throws IOException
     */
    public IosBitmap(InputStream inputStream) throws IOException {
        byte[] array = toByteArray(inputStream);
        BytePtr ptr = PtrFactory.newByteArray(array);
        NSData data = NSData.dataWithBytesLength(ptr, array.length);
        this.image = UIImage.imageWithData(data);
        this.width = (int) this.image.size().width();
        this.height = (int) this.image.size().height();
    }

    /**
     * Constructor<br>
     * Load a IosBitmap from Asset with given FilePath
     *
     * @param fileName
     * @throws IOException
     */
    public IosBitmap(String fileName) throws IOException {
        if (fileName == null || fileName.length() == 0) {
            // no image source defined
            this.cgBitmapContext = null;
            this.width = 0;
            this.height = 0;
            this.image = null;
            return;
        }

        InputStream inputStream = AssetAdapter.readFileAsStream(fileName);
        if (inputStream == null) {
            log.error("invalid bitmap source: " + fileName);
            // no image source defined
            this.cgBitmapContext = null;
            this.width = 0;
            this.height = 0;
            this.image = null;
            return;
        }
        byte[] array = toByteArray(inputStream);
        BytePtr ptr = PtrFactory.newByteArray(array);
        NSData data = NSData.dataWithBytesLength(ptr, array.length);
        this.image = UIImage.imageWithData(data);
        this.width = (int) this.image.size().width();
        this.height = (int) this.image.size().height();
    }

    /**
     * Protected constructor for create IosBitmap from IosSvgBitmap.
     *
     * @param image
     */
    protected IosBitmap(UIImage image) {
        this.image = image;
    }


    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public int getHeight() {
        return this.height;
    }

    @Override
    public void recycle() {
        //CGContext.close() will close the object and release any system resources it holds.
        if (this.cgBitmapContext != null) {
//            this.cgBitmapContext.close();
            this.cgBitmapContext = null;
        }
        if (this.directPixelBuffer != null) {
            this.directPixelBuffer.clear();
            this.directPixelBuffer = null;
        }
    }

    @Override
    public int[] getPixels() {
        //Todo fill a int[] with pixmap.getPixel(x,y)
        return new int[0];
    }


    public void createContext() {
        if (this.cgBitmapContext == null) {
            CGSize size = new CGSize(this.width, this.height);
            UIKit.UIGraphicsBeginImageContext(size);
            this.cgBitmapContext = UIKit.UIGraphicsGetCurrentContext();
//            UIKit.UIGraphicsEndImageContext();
        }
    }


    @Override
    public void eraseColor(int color) {
        createContext();

        //delete all pixels and fill with given color
        CGSize size = new CGSize(this.width, this.height);
        CGContextSetFillColorWithColor(this.cgBitmapContext, getCGColor(color));
        CGRect rect = new CGRect(new CGPoint(0, 0), size);

        CGContextFillRect(this.cgBitmapContext, rect);
        createImageFromContext();
    }

    public void createImageFromContext() {
        CGImageRef ref = CGBitmapContextCreateImage(this.cgBitmapContext);
        this.image = UIImage.imageWithCGImage(ref);
//        this.image = UIKit.UIGraphicsGetImageFromCurrentImageContext();
    }

    @Override
    public void uploadToTexture(boolean replace) {

        //create a pixel buffer for upload from direct memory pointer
        if (directPixelBuffer == null) {

            //create Pixmap from cgBitmapContext for extract glFormat info's
            byte[] encodedData = getPngEncodedData();
            Pixmap pixmap = new Pixmap(encodedData, 0, encodedData.length);

            glInternalFormat = pixmap.getGLInternalFormat();
            glFormat = pixmap.getGLFormat();
            glType = pixmap.getGLType();

//            directPixelBuffer = cgBitmapContext.getData().asIntBuffer(encodedData.length / 4);
            pixmap.dispose();

        }

        Gdx.gl.glTexImage2D(GL.TEXTURE_2D, 0, glInternalFormat, this.width, this.height, 0
                , glFormat, glType, directPixelBuffer);
    }

    @Override
    public boolean isValid() {
        return this.cgBitmapContext != null;
    }

    /**
     * Returns a ByteArray from InputStream
     *
     * @param in InputStream
     * @return
     * @throws IOException
     */
    static byte[] toByteArray(InputStream in) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] buff = new byte[8192];
        while (in.read(buff) > 0) {
            out.write(buff);
        }
        out.close();
        return out.toByteArray();
    }

    /**
     * Returns the CGColor from given int
     *
     * @param color
     * @return
     */
    static CGColorRef getCGColor(int color) {

        return UIColor.colorWithRedGreenBlueAlpha(
                Color.r(color) / 255.0,
                Color.g(color) / 255.0,
                Color.b(color) / 255.0,
                Color.a(color) / 255.0
        ).CGColor();
    }

    @Override
    public byte[] getPngEncodedData() {
        NSData data = UIKit.UIImagePNGRepresentation(this.image);
        long arrayLength = data.length();
        ByteBuffer buffer = BufferUtils.newByteBuffer((int) arrayLength);
        VoidPtr ptr = PtrFactory.newPtr(buffer);
        data.getBytesLength(ptr, arrayLength);
        int length = (int) arrayLength - 4;
        byte[] array = new byte[length];
        System.arraycopy(buffer.array(), 4, array, 0, length);
        return array;
    }
}
