package com.returntosirandora.scenes;

import com.badlogic.gdx.graphics.GL32;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class Menu extends BaseScene {

    public void create() {

        System.out.println(sceneName);
    }

    public void update(float deltaTime) {
        if (Gdx.input.isKeyJustPressed(Input.Keys.W))
            router.redirectingTo("Test");
    }

    public void render() {
        Gdx.gl.glClearColor(1, 0, 0, 0);
        Gdx.gl.glClear(GL32.GL_COLOR_BUFFER_BIT);
    }

    public void end() {

    }
}
