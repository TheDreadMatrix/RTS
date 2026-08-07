package com.returntosirandora.core.protocol;

public interface SceneInterface {
    public SceneInterface _initScene(ApplicationInterface game, String sceneName);

    public void create();

    public void update(float deltaTime);

    public void resize(int width, int height);

    public void pause();

    public void resume();

    public void render();

    public void end();
}
