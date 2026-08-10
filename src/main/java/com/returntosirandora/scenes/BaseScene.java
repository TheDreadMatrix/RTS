package com.returntosirandora.scenes;

import com.returntosirandora.core.protocol.ApplicationInterface;
import com.returntosirandora.core.protocol.SceneInterface;
import com.returntosirandora.core.protocol.runtime.PathsInterface;
import com.returntosirandora.core.protocol.runtime.RouterInterface;

import com.badlogic.gdx.assets.AssetManager;

public class BaseScene implements SceneInterface {
    String sceneName;

    ApplicationInterface game;
    PathsInterface paths;
    RouterInterface router;

    AssetManager assets;

    public BaseScene _initScene(ApplicationInterface game, String sceneName) {
        this.game = game;
        this.sceneName = sceneName;

        paths = game.getPaths();
        router = game.getRouter();
        assets = game.getAssets();

        return this;

    }

    @Override
    public void create() {

    }

    @Override
    public void update(float deltaTime) {

    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void render() {

    }

    @Override
    public void end() {

    }
}
