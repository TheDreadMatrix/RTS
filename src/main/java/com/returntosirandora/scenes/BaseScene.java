package com.returntosirandora.scenes;

import com.returntosirandora.core.protocol.ApplicationInterface;
import com.returntosirandora.core.protocol.SceneInterface;
import com.returntosirandora.core.protocol.SettingsInterface;
import com.returntosirandora.core.protocol.runtime.PathsInterface;
import com.returntosirandora.core.protocol.runtime.RouterInterface;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

public class BaseScene implements SceneInterface {
    boolean isDebug = false;

    ApplicationInterface game;
    PathsInterface paths;
    RouterInterface router;
    SettingsInterface settings;

    AssetManager assets;

    Stage mainStage;

    public BaseScene initScene(ApplicationInterface game) {
        this.game = game;

        paths = game.getPaths();
        router = game.getRouter();
        assets = game.getAssets();
        settings = game.getSettings();

        mainStage = new Stage(new ExtendViewport(800f, 400f, 1600f, 720f));

        Gdx.input.setInputProcessor(mainStage);

        return this;

    }

    @Override
    public void create(String sceneName) {

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
    public void render() {
        mainStage.draw();
    }

    @Override
    public void end() {
        mainStage.dispose();
    }
}
