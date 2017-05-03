/*
 * Copyright 2016 Longri
 * Copyright 2016 devemux86
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

import apple.coregraphics.struct.CGRect;
import apple.coregraphics.struct.CGSize;
import apple.uikit.UIImage;
import org.oscim.backend.CanvasAdapter;
import org.oscim.utils.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import svg.SVGRenderer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class IosSvgBitmap extends IosBitmap {
    private static final Logger log = LoggerFactory.getLogger(IosSvgBitmap.class);

    /**
     * Default size is 20x20px (400px) at 160dpi.
     */
    public static float DEFAULT_SIZE = 400f;

    private static String getStringFromInputStream(InputStream is) {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = null;
        String line;
        try {
            br = new BufferedReader(new InputStreamReader(is));
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        } finally {
            IOUtils.closeQuietly(br);
        }
        return sb.toString();
    }

    public static UIImage getResourceBitmap(InputStream inputStream, float scaleFactor, float defaultSize, int width, int height, int percent) {
        String svg = getStringFromInputStream(inputStream);

        SVGRenderer renderer =  SVGRenderer.alloc();
        renderer.initWithString(svg);
        CGRect viewRect = renderer.viewRect();

        float viewWidth= (float) viewRect.size().width();
        float viewHeight= (float) viewRect.size().height();

        double scale = scaleFactor / Math.sqrt((viewHeight* viewWidth) / defaultSize);

        float bitmapWidth = (float) (viewWidth * scale);
        float bitmapHeight = (float) (viewHeight* scale);

        float aspectRatio = (float) (viewWidth / viewHeight);

        if (width != 0 && height != 0) {
            // both width and height set, override any other setting
            bitmapWidth = width;
            bitmapHeight = height;
        } else if (width == 0 && height != 0) {
            // only width set, calculate from aspect ratio
            bitmapWidth = height * aspectRatio;
            bitmapHeight = height;
        } else if (width != 0 && height == 0) {
            // only height set, calculate from aspect ratio
            bitmapHeight = width / aspectRatio;
            bitmapWidth = width;
        }

        if (percent != 100) {
            bitmapWidth *= percent / 100f;
            bitmapHeight *= percent / 100f;
        }

        return renderer.asImageWithSizeAndScale(new CGSize(bitmapWidth, bitmapHeight), 1);
    }

    private static UIImage getResourceBitmapImpl(InputStream inputStream, int width, int height, int percent) {
        return getResourceBitmap(inputStream, CanvasAdapter.dpi / CanvasAdapter.DEFAULT_DPI, DEFAULT_SIZE, width, height, percent);
    }

    public IosSvgBitmap(InputStream inputStream, int width, int height, int percent) throws IOException {
        super(getResourceBitmapImpl(inputStream, width, height, percent));
    }
}
