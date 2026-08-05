package com.returntosirandora.scenes;

import com.returntosirandora.core.protocol.ApplicationInterface;
import com.returntosirandora.core.protocol.PathsInterface;
import com.returntosirandora.core.protocol.RouterInterface;
import com.returntosirandora.core.protocol.SceneInterface;

public class BaseScene implements SceneInterface {
    ApplicationInterface game;
    PathsInterface paths;
    RouterInterface router;

    public BaseScene(ApplicationInterface game) {
        this.game = game;
        paths = game.getPaths();
        router = game.getRouter();

    }

    @Override
    public void create(ApplicationInterface game) {

    }

    @Override
    public void update(float deltaTime) {

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void render() {

    }

    @Override
    public void end() {

    }
}
