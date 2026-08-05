package com.returntosirandora.scenes;

import com.badlogic.gdx.graphics.GL32;
import com.returntosirandora.core.protocol.ApplicationInterface;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class Menu extends BaseScene {
    public Menu(ApplicationInterface game) {
        super(game);
        System.out.println(router.getName());
    }

    @Override
    public void create(ApplicationInterface game) {
        System.out.println(router.getName());
    }

    @Override
    public void update(float deltaTime) {
        if (Gdx.input.isKeyPressed(Input.Keys.W))
            router.redirectingTo("Test");
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 0, 0, 0);
        Gdx.gl.glClear(GL32.GL_COLOR_BUFFER_BIT);
    }
}
