/*
 * Copyright 2013 Hannes Janetzek
 * Copyright 2016-2017 devemux86
 * Copyright 2017 nebular
 * Copyright 2017 Longri
 *
 * This file is part of the OpenScienceMap project (http://www.opensciencemap.org).
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
package org.oscim.android.canvas;

import android.graphics.Color;
import android.graphics.PorterDuff;
import org.oscim.backend.canvas.Bitmap;
import org.oscim.backend.canvas.Canvas;
import org.oscim.backend.canvas.Paint;

public class AndroidCanvas implements Canvas {

    public final android.graphics.Canvas canvas;

    public AndroidCanvas() {
        canvas = new android.graphics.Canvas();
    }

    public AndroidCanvas(android.graphics.Canvas canvas) {
        this.canvas = canvas;
    }

    @Override
    public void setBitmap(Bitmap bitmap) {
        canvas.setBitmap(((AndroidBitmap) bitmap).mBitmap);
    }

    @Override
    public void drawText(String string, float x, float y, Paint paint) {
        if (string != null)
            canvas.drawText(string, x, y, ((AndroidPaint) paint).mPaint);
    }

    @Override
    public void drawText(String string, float x, float y, Paint fill, Paint stroke) {
        if (string != null) {
            if (stroke != null)
                canvas.drawText(string, x, y, ((AndroidPaint) stroke).mPaint);

            canvas.drawText(string, x, y, ((AndroidPaint) fill).mPaint);
        }
    }

    @Override
    public void drawBitmap(Bitmap bitmap, float x, float y) {
        canvas.drawBitmap(((AndroidBitmap) bitmap).mBitmap, x, y, null);
    }

    @Override
    public void drawBitmapScaled(Bitmap bitmap) {
        android.graphics.Bitmap scaledBitmap = android.graphics.Bitmap.createScaledBitmap(
                ((AndroidBitmap) bitmap).mBitmap, canvas.getWidth(), canvas.getHeight(), true);
        canvas.drawBitmap(scaledBitmap, 0, 0, null);
        scaledBitmap.recycle();
    }

    @Override
    public void drawCircle(float x, float y, float radius, Paint paint) {
        canvas.drawCircle(x, y, radius, ((AndroidPaint) paint).mPaint);
    }

    @Override
    public void drawLine(float x1, float y1, float x2, float y2, Paint paint) {
        canvas.drawLine(x1, y1, x2, y2, ((AndroidPaint) paint).mPaint);
    }

    @Override
    public void fillColor(int color) {
        canvas.drawColor(color, color == Color.TRANSPARENT ? PorterDuff.Mode.CLEAR : PorterDuff.Mode.SRC_OVER);
    }

    @Override
    public int getHeight() {
        return canvas.getHeight();
    }

    @Override
    public int getWidth() {
        return canvas.getWidth();
    }
}
