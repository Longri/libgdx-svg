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
package org.oscim.backend.canvas;

/**
 * The Interface Canvas.
 */
public interface Canvas {

    /**
     * Sets the backing {@link Bitmap}.
     */
    void setBitmap(Bitmap bitmap);

    /**
     * Draw text to Canvas.
     */
    void drawText(String string, float x, float y, Paint paint);

    /**
     * Draw text to Canvas.
     */
    void drawText(String string, float x, float y, Paint fill, Paint stroke);

    /**
     * Draw Bitmap to Canvas.
     */
    void drawBitmap(Bitmap bitmap, float x, float y);

    /**
     * Draw scaled Bitmap to fill target.
     */
    void drawBitmapScaled(Bitmap bitmap);

    void drawCircle(float x, float y, float radius, Paint paint);

    void drawLine(float x1, float y1, float x2, float y2, Paint paint);

    void fillColor(int color);

    int getHeight();

    int getWidth();
}
