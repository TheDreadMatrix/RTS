package com.returntosirandora.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.utils.ScreenUtils;
import com.returntosirandora.core.protocol.ApplicationInterface;
import com.returntosirandora.core.protocol.SettingsInterface;
import com.returntosirandora.core.runtime.RTSPath;
import com.returntosirandora.core.runtime.RTSRouter;

// Stage debug util
public class RTSApplication extends ApplicationAdapter implements ApplicationInterface {

    private RTSPath paths;
    private RTSRouter router;
    private AssetManager assets;
    private SettingsInterface settings;

    public RTSApplication(SettingsInterface settings) {
        this.settings = settings;
    }

    @Override
    public SettingsInterface getSettings() {
        return settings;
    }

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
    public void clear(float r, float g, float b) {
        ScreenUtils.clear(r, g, b, 1.0f);
    }

    @Override
    public void render() {
        router.update(Gdx.graphics.getDeltaTime());

        ScreenUtils.clear(0.5f, 0.5f, 0.5f, 1);

        router.render();

    }

    @Override
    public void dispose() {
        assets.dispose();
    }

}