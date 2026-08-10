package com.returntosirandora.scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class TestScene extends BaseScene {

    public void create() {

    }

    public void update(float deltaTime) {
        if (Gdx.input.isKeyJustPressed(Input.Keys.W)) {
            router.redirectingTo("Menu");
        }
    }

}
