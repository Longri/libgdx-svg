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

public class MyGdxGame extends ApplicationAdapter {
    SpriteBatch batch;
    Texture img, svg;

    @Override
    public void create() {
        batch = new SpriteBatch();
        img = new Texture("badlogic.jpg");

        try {
            FileHandle svgFile = Gdx.files.internal("powered_by_libGDX.svg");
            Bitmap bitmap = CanvasAdapter.decodeSvgBitmap(svgFile.read(), 0, 0, 1000);

            byte[] bitmapData = bitmap.getPngEncodedData();
            Pixmap pixmap = new Pixmap(bitmapData, 0, bitmapData.length);
            svg = new Texture(pixmap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(img, 0, 0);
        if (svg != null) batch.draw(svg, 0, 300);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
    }
}
