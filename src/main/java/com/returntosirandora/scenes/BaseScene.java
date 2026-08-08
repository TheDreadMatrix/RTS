package com.returntosirandora.scenes;

import com.returntosirandora.core.protocol.ApplicationInterface;
import com.returntosirandora.core.protocol.AssetsInterface;
import com.returntosirandora.core.protocol.PathsInterface;
import com.returntosirandora.core.protocol.RouterInterface;
import com.returntosirandora.core.protocol.SceneInterface;

import com.badlogic.gdx.scenes.scene2d.Stage;

public class BaseScene implements SceneInterface {
    String sceneName;

    ApplicationInterface game;
    PathsInterface paths;
    RouterInterface router;
    AssetsInterface assets;

    Stage stage;

    public BaseScene _initScene(ApplicationInterface game, String sceneName) {
        this.game = game;
        this.sceneName = sceneName;

        paths = game.getPaths();
        router = game.getRouter();
        assets = game.getAssets();

        stage = new Stage();

        assets.beginScene(sceneName);

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
        stage.getViewport().update(width, height, true);
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
