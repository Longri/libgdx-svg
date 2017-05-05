package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.oscim.backend.CanvasAdapter;
import org.oscim.backend.canvas.Bitmap;
import org.oscim.backend.canvas.Canvas;
import org.oscim.backend.canvas.Color;
import org.oscim.backend.canvas.Paint;

import java.io.InputStream;

public class MyGdxGame extends ApplicationAdapter {
    SpriteBatch batch;
    Texture img, svg, png, draw;
    Bitmap cbBitmap;

    @Override
    public void create() {
        batch = new SpriteBatch();
        img = new Texture("badlogic.jpg");

        try {
            FileHandle svgFile = Gdx.files.internal("powered_by_libGDX.svg");
            InputStream stream = svgFile.read();
            Bitmap bitmap = CanvasAdapter.decodeSvgBitmap(stream, 0, 0, 1000);
            stream.close();


            byte[] bitmapData = bitmap.getPngEncodedData();
            Pixmap pixmap = new Pixmap(bitmapData, 0, bitmapData.length);
            svg = new Texture(pixmap);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            FileHandle svgFile = Gdx.files.internal("cb.png");
            InputStream stream = svgFile.read();
            cbBitmap = CanvasAdapter.decodeBitmap(stream);
            stream.close();

            byte[] bitmapData = cbBitmap.getPngEncodedData();
            Pixmap pixmap = new Pixmap(bitmapData, 0, bitmapData.length);
            png = new Texture(pixmap);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Bitmap bmp = CanvasAdapter.newBitmap(200, 200, 0);

            Canvas canvas = CanvasAdapter.newCanvas();
            canvas.setBitmap(bmp);
            canvas.fillColor(Color.YELLOW);
            canvas.drawBitmap(cbBitmap, 10, 20);


            Paint paint = CanvasAdapter.newPaint();
            paint.setColor(Color.GREEN);
            paint.setStrokeWidth(30);
            paint.setStrokeCap(Paint.Cap.ROUND);
            canvas.drawLine(10, 10, 50, 50, paint);


            Paint circlePaint = CanvasAdapter.newPaint();
            circlePaint.setStrokeWidth(7);
            circlePaint.setColor(Color.RED);
            circlePaint.setStyle(Paint.Style.FILL);
            canvas.drawCircle(150, 150, 50, circlePaint);
            circlePaint.setColor(Color.CYAN);
            circlePaint.setStyle(Paint.Style.STROKE);
            canvas.drawCircle(150, 150, 25, circlePaint);


            Paint textPaint = CanvasAdapter.newPaint();
            textPaint.setColor(Color.BLUE);
            textPaint.setTypeface(Paint.FontFamily.DEFAULT, Paint.FontStyle.ITALIC);
            textPaint.setTextSize(16);

            canvas.drawText("HALLO LibGdx", 10, 100, textPaint);

            Paint textPaintFill = CanvasAdapter.newPaint();
            textPaintFill.setColor(Color.YELLOW);
            textPaintFill.setTypeface(Paint.FontFamily.DEFAULT, Paint.FontStyle.ITALIC);
            textPaintFill.setTextSize(12);
            textPaint.setTextSize(12);
            textPaint.setStrokeWidth(5);
            canvas.drawText("HALLO LibGdx", 10, 150, textPaintFill, textPaint);

            byte[] bitmapData = bmp.getPngEncodedData();
            Pixmap pixmap = new Pixmap(bitmapData, 0, bitmapData.length);
            draw = new Texture(pixmap);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    int renderCount = 0;

    @Override
    public void render() {

        renderCount++;

        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(img, 0, 0);
        if (svg != null) batch.draw(svg, 0, 300);
        if (png != null) batch.draw(png, 300, 0);
        if (draw != null) batch.draw(draw, 300, 100);


        if (renderCount == 100) {
            cbBitmap.eraseColor(Color.GREEN);
            byte[] bitmapData = cbBitmap.getPngEncodedData();
            Pixmap pixmap = new Pixmap(bitmapData, 0, bitmapData.length);
            png = new Texture(pixmap);
        }

        if (renderCount == 200) {
            Canvas canvas = CanvasAdapter.newCanvas();
            canvas.setBitmap(cbBitmap);

            canvas.fillColor(Color.YELLOW);
            byte[] bitmapData = cbBitmap.getPngEncodedData();
            Pixmap pixmap = new Pixmap(bitmapData, 0, bitmapData.length);
            png = new Texture(pixmap);
        }

        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
    }
}
