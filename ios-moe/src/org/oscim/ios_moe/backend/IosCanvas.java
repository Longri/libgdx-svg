/*
 * Copyright 2016-2017 Longri
 * Copyright 2016-2017 devemux86
 * Copyright 2017 nebular
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

import apple.coregraphics.opaque.CGContextRef;
import apple.coregraphics.struct.CGPoint;
import apple.coregraphics.struct.CGRect;
import apple.coregraphics.struct.CGSize;
import apple.uikit.c.UIKit;
import org.oscim.backend.canvas.Bitmap;
import org.oscim.backend.canvas.Canvas;
import org.oscim.backend.canvas.Paint;

import static apple.coregraphics.c.CoreGraphics.*;
import static org.oscim.ios_moe.backend.IosBitmap.getCGColor;

/**
 * iOS specific implementation of {@link Canvas}.
 */
public class IosCanvas implements Canvas {

    IosBitmap bmp;

    @Override
    public void setBitmap(Bitmap bitmap) {
        this.bmp = ((IosBitmap) bitmap);
    }

    @Override
    public void drawText(String string, float x, float y, Paint paint) {
        bmp.createContext();
        //flip Y-axis
        y = bmp.height - y;

        IosPaint iosPaint = (IosPaint) paint;
        iosPaint.drawLine(bmp.cgBitmapContext, string, x, y);
        bmp.createImageFromContext();
    }

    @Override
    public void drawText(String string, float x, float y, Paint fill, Paint stroke) {
        bmp.createContext();
        //flip Y-axis
        y = bmp.height - y;

        IosPaint iosFill = (IosPaint) fill;
        if (stroke != null) {
            IosPaint iosStroke = (IosPaint) stroke;
            iosFill.setStrokeWidth(iosStroke.strokeWidth);
            iosFill.setStrokeColor(iosStroke.getColor());
            iosStroke.drawLine(bmp.cgBitmapContext, string, x, y);
        }
        iosFill.drawLine(bmp.cgBitmapContext, string, x, y);
        bmp.createImageFromContext();
    }

    @Override
    public void drawBitmap(Bitmap bitmap, float x, float y) {
        bmp.createContext();
        CGContextSaveGState(bmp.cgBitmapContext);
        IosBitmap iosBitmap = ((IosBitmap) bitmap);
        float flipY = bmp.height - y - iosBitmap.height;
        CGContextTranslateCTM(bmp.cgBitmapContext, x, flipY);
        CGRect rect = new CGRect(new CGPoint(0, 0), new CGSize(iosBitmap.width, iosBitmap.height));
        CGContextDrawImage(bmp.cgBitmapContext, rect, iosBitmap.image.CGImage());
        CGContextRestoreGState(bmp.cgBitmapContext);
        bmp.createImageFromContext();
    }

    @Override
    public void drawBitmapScaled(Bitmap bitmap) {
        bmp.createContext();
        CGContextSaveGState(bmp.cgBitmapContext);
        CGRect rect = new CGRect(new CGPoint(0, 0), new CGSize(bmp.width, bmp.height));
        CGContextTranslateCTM(bmp.cgBitmapContext, 0, 0);
        IosBitmap iosBitmap = ((IosBitmap) bitmap);
        CGContextDrawImage(bmp.cgBitmapContext, rect, iosBitmap.image.CGImage());
        CGContextRestoreGState(bmp.cgBitmapContext);
        bmp.createImageFromContext();
    }

    @Override
    public void drawCircle(float x, float y, float radius, Paint paint) {
        bmp.createContext();
        float flipY = bmp.height - y - (radius * 2);
        CGRect rect = new CGRect(new CGPoint(x-radius, flipY+radius), new CGSize(radius * 2, radius * 2));
        switch (paint.getStyle()) {
            case FILL:
                setFillColor(bmp.cgBitmapContext, paint.getColor());
                CGContextFillEllipseInRect(bmp.cgBitmapContext, rect);
                break;
            case STROKE:
                // set Stroke properties
                CGContextSetLineWidth(bmp.cgBitmapContext, ((IosPaint) paint).strokeWidth);
                CGContextSetLineCap(bmp.cgBitmapContext, ((IosPaint) paint).getIosStrokeCap());
                CGContextSetLineJoin(bmp.cgBitmapContext, ((IosPaint) paint).getIosStrokeJoin());
                setStrokeColor(bmp.cgBitmapContext, (paint.getColor()));
                CGContextStrokeEllipseInRect(bmp.cgBitmapContext, rect);
                break;
        }
        bmp.createImageFromContext();
    }

    @Override
    public void drawLine(float x1, float y1, float x2, float y2, Paint paint) {
        bmp.createContext();

        //flip Y-axis
        y1 = (int) (this.bmp.getHeight() - y1);
        y2 = (int) (this.bmp.getHeight() - y2);

        // set Stroke properties
        CGContextSetLineWidth(bmp.cgBitmapContext, ((IosPaint) paint).strokeWidth);
        CGContextSetLineCap(bmp.cgBitmapContext, ((IosPaint) paint).getIosStrokeCap());
        CGContextSetLineJoin(bmp.cgBitmapContext, ((IosPaint) paint).getIosStrokeJoin());
        setStrokeColor(bmp.cgBitmapContext, (paint.getColor()));

        //draw line
        CGContextBeginPath(bmp.cgBitmapContext);
        CGContextMoveToPoint(bmp.cgBitmapContext, x1, y1);
        CGContextAddLineToPoint(bmp.cgBitmapContext, x2, y2);
        CGContextStrokePath(bmp.cgBitmapContext);
        bmp.createImageFromContext();
    }

    @Override
    public void fillColor(int color) {
        bmp.createContext();
        CGSize size = new CGSize(bmp.width, bmp.height);
        CGContextSetFillColorWithColor(bmp.cgBitmapContext, getCGColor(color));
        CGRect rect = new CGRect(new CGPoint(0, 0), size);
        CGContextFillRect(bmp.cgBitmapContext, rect);
        bmp.createImageFromContext();
    }

    @Override
    public int getHeight() {
        return this.bmp != null ? this.bmp.getHeight() : 0;
    }

    @Override
    public int getWidth() {
        return this.bmp != null ? this.bmp.getWidth() : 0;
    }

    //
    static void setFillColor(CGContextRef bctx, int color) {
        float blue = (color & 0xFF) / 255f;
        color >>= 8;
        float green = (color & 0xFF) / 255f;
        color >>= 8;
        float red = (color & 0xFF) / 255f;
        color >>= 8;
        float alpha = (color & 0xFF) / 255f;
        CGContextSetRGBFillColor(bctx, red, green, blue, alpha);

    }

    static void setStrokeColor(CGContextRef bctx, int color) {
        float blue = (color & 0xFF) / 255f;
        color >>= 8;
        float green = (color & 0xFF) / 255f;
        color >>= 8;
        float red = (color & 0xFF) / 255f;
        color >>= 8;
        float alpha = (color & 0xFF) / 255f;
        CGContextSetRGBStrokeColor(bctx, red, green, blue, alpha);
    }
//
//    CGContextRef cgBitmapContext;
//
//    @Override
//    public void setBitmap(Bitmap bitmap) {
//        cgBitmapContext = ((IosBitmap) bitmap).cgBitmapContext;
//    }
//
//
//
//    @Override
//    public void drawBitmap(Bitmap bitmap, float x, float y) {
//
//    }
//
//    @Override
//    public void drawBitmapScaled(Bitmap bitmap) {
//
//    }
//
//    @Override
//    public void drawCircle(float x, float y, float radius, Paint paint) {
//
//    }
//
//    @Override
//    public void drawLine(float x1, float y1, float x2, float y2, Paint paint) {
//        //flip Y-axis
//        y1 = (int) (this.cgBitmapContext.getHeight() - y1);
//        y2 = (int) (this.cgBitmapContext.getHeight() - y2);
//
//        // set Stroke properties
//        this.cgBitmapContext.setLineWidth(((IosPaint) paint).strokeWidth);
//        this.cgBitmapContext.setLineCap(((IosPaint) paint).getIosStrokeCap());
//        this.cgBitmapContext.setLineJoin(((IosPaint) paint).getIosStrokeJoin());
//        setStrokeColor(this.cgBitmapContext, (paint.getColor()));
//
//        //draw line
//        this.cgBitmapContext.beginPath();
//        this.cgBitmapContext.moveToPoint(x1, y1);
//        this.cgBitmapContext.addLineToPoint(x2, y2);
//        this.cgBitmapContext.strokePath();
//    }
//
//    @Override
//    public void fillColor(int color) {
//        CGRect rect = new CGRect(0, 0, this.cgBitmapContext.getWidth(), this.cgBitmapContext.getHeight());
//        setFillColor(this.cgBitmapContext, (color));
//        this.cgBitmapContext.setBlendMode(CGBlendMode.Clear);
//        this.cgBitmapContext.fillRect(rect);
//        this.cgBitmapContext.setBlendMode(CGBlendMode.Normal);
//        this.cgBitmapContext.fillRect(rect);
//    }
//
//    @Override
//    public int getHeight() {
//        return this.cgBitmapContext != null ? (int) this.cgBitmapContext.getHeight() : 0;
//    }
//
//    @Override
//    public int getWidth() {
//        return this.cgBitmapContext != null ? (int) this.cgBitmapContext.getWidth() : 0;
//    }


}
