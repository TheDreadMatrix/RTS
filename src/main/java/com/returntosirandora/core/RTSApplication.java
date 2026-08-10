package com.returntosirandora.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.utils.ScreenUtils;

import com.returntosirandora.core.protocol.ApplicationInterface;
import com.returntosirandora.core.runtime.RTSPath;
import com.returntosirandora.core.runtime.RTSRouter;
import com.returntosirandora.Johnson.MrProper;

public class RTSApplication extends ApplicationAdapter implements ApplicationInterface {

    public RTSPath paths;
    public RTSRouter router;
    public AssetManager assets;

    public static Lwjgl3ApplicationConfiguration _giveConfiguration() {
        MrProper game_settings = new MrProper("settings.properties");

        // Creating configuration
        Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();

        config.setWindowIcon("assets/icon.png");
        config.setTitle("Return to Sirandora");
        config.setWindowedMode(game_settings.getInt("window.width", 800), game_settings.getInt("window.height", 600));
        config.setForegroundFPS(game_settings.getInt("window.fps", 60));
        config.useVsync(game_settings.getBoolean("window.vsync", false));
        config.setIdleFPS(10);
        config.setWindowSizeLimits(799, 599, 10000, 10000);

        return config;
    }

    // Game methods
    @Override
    public RTSPath getPaths() {
        return paths;
    }

    @Override
    public RTSRouter getRouter() {
        return router;
    }

    @Override
    public AssetManager getAssets() {
        return assets;
    }

    @Override
    public void create() {

        paths = new RTSPath();
        assets = new AssetManager();

        router = new RTSRouter(this);
        router.afterInit();

    }

    @Override
    public void resize(int width, int height) {
        router.resize(width, height);
    }

    @Override
    public void pause() {
        router.pause();
    }

    @Override
    public void resume() {
        router.resume();
    }

    @Override
    public void render() {
        router.update(Gdx.graphics.getDeltaTime());

        ScreenUtils.clear(0, 0, 0, 1);

        router.render();

    }

    @Override
    public void dispose() {
        assets.dispose();
    }

}