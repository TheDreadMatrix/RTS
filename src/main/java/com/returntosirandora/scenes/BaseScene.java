package com.returntosirandora.scenes;

import com.returntosirandora.core.protocol.ApplicationInterface;
import com.returntosirandora.core.protocol.SceneInterface;
import com.returntosirandora.core.protocol.runtime.PathsInterface;
import com.returntosirandora.core.protocol.runtime.RouterInterface;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

public class BaseScene implements SceneInterface {
    String sceneName;
    boolean isDebug = false;

    protected static final float MIN_WORLD_WIDTH = 800f;
    protected static final float MIN_WORLD_HEIGHT = 400f;
    protected static final float MAX_WORLD_WIDTH = 1600f;
    protected static final float MAX_WORLD_HEIGHT = 720f;

    ApplicationInterface game;
    PathsInterface paths;
    RouterInterface router;

    AssetManager assets;
    ExtendViewport mainViewport;
    Stage mainStage;

    public BaseScene _initScene(ApplicationInterface game, String sceneName) {
        this.game = game;
        this.sceneName = sceneName;

        paths = game.getPaths();
        router = game.getRouter();
        assets = game.getAssets();

        mainViewport = new ExtendViewport(MIN_WORLD_WIDTH, MIN_WORLD_HEIGHT, MAX_WORLD_WIDTH, MAX_WORLD_HEIGHT);

        mainStage = new Stage(mainViewport);

        Gdx.input.setInputProcessor(mainStage);

        return this;

    }

    @Override
    public void create() {

    }

    @Override
    public void update(float deltaTime) {
        mainStage.act(deltaTime);

        if (Gdx.input.isKeyJustPressed(Input.Keys.F3)) {
            isDebug = !isDebug;
            mainStage.setDebugAll(isDebug);
        }
    }

    @Override
    public void resize(int width, int height) {
        mainStage.getViewport().update(width, height, true);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void render() {
        mainStage.draw();
    }

    @Override
    public void end() {
        mainStage.dispose();
    }
}
