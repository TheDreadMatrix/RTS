package com.returntosirandora.core.protocol;

public interface SceneInterface {
    public void create(ApplicationInterface game);

    public void update(float deltaTime);

    public void resize(int width, int height);

    public void render();

    public void end();
}
