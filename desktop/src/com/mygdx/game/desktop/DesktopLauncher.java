package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.MyGdxGame;
import oscim.awt.AwtGraphics;

public class DesktopLauncher {
    public static void main(String[] arg) {

        //initialize platform bitmap factory
        AwtGraphics.init();


        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        new LwjglApplication(new MyGdxGame(), config);
    }
}
