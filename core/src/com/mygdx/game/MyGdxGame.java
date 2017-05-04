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

import java.io.InputStream;

public class MyGdxGame extends ApplicationAdapter {
    SpriteBatch batch;
    Texture img, svg, png, pngfile;
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
