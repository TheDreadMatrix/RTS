package com.returntosirandora.subscenes;

import java.util.function.Consumer;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.returntosirandora.core.protocol.ApplicationInterface;

public class BaseSubScene {
    public ApplicationInterface game;
    public Consumer<String> redirect;

    public BaseSubScene initSubScene(ApplicationInterface game, Consumer<String> redirect) {
        this.game = game;
        this.redirect = redirect;

        return this;
    }

    public void create(Stage stage) {

    }

    public void dispose() {

    }
}
