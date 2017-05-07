package com.mygdx.game;

import apple.glkit.enums.GLKViewDrawableStencilFormat;
import com.badlogic.gdx.backends.iosmoe.IOSApplication;
import com.badlogic.gdx.backends.iosmoe.IOSApplicationConfiguration;
import org.moe.natj.general.Pointer;
import com.mygdx.game.MyGdxGame;

import apple.uikit.c.UIKit;
import org.oscim.ios_moe.backend.IosGraphics;

public class IOSMoeLauncher extends IOSApplication.Delegate {

    protected IOSMoeLauncher(Pointer peer) {
        super(peer);
    }

    @Override
    protected IOSApplication createApplication() {
        IOSApplicationConfiguration config = new IOSApplicationConfiguration();
        config.useAccelerometer = false;
        config.stencilFormat= GLKViewDrawableStencilFormat.Format8;

        IosGraphics.init();

        return new IOSApplication(new MyGdxGame(), config);
    }

    public static void main(String[] argv) {
        UIKit.UIApplicationMain(0, null, null, IOSMoeLauncher.class.getName());
    }
}
