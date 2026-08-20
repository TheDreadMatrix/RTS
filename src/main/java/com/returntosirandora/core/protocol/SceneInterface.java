package com.returntosirandora.core.protocol;

public interface SceneInterface {
    public SceneInterface initScene(ApplicationInterface game);

    public void create(String sceneName);

    public void update(float deltaTime);

    public void resize(int width, int height);

    public void render();

    public void end();
}
