package com.returntosirandora.scenes;

import com.returntosirandora.core.protocol.ApplicationInterface;
import com.returntosirandora.core.protocol.SceneInterface;
import com.returntosirandora.core.protocol.SettingsInterface;
import com.returntosirandora.core.protocol.runtime.PathsInterface;
import com.returntosirandora.core.protocol.runtime.RouterInterface;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class BaseScene implements SceneInterface {
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

        mainStage = new Stage(new ScreenViewport());

        Gdx.input.setInputProcessor(mainStage);

        return this;

    }

    @Override
    public void create(String sceneName) {

    }

    @Override
    public void update(float deltaTime) {
        mainStage.act(deltaTime);

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
