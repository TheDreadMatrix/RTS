package com.returntosirandora.utils.ui;

import java.util.function.Consumer;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.Align;

public class ListenerUtils {
    public static ChangeListener redirect(String redirectScene, Consumer<String> redirectFactory) {
        return new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                redirectFactory.accept(redirectScene);
            }
        };
    }

    public static InputListener scaleHoverMouse(Actor mainActor) {
        mainActor.setOrigin(Align.center);
        return new InputListener() {
            @Override
            public void enter(InputEvent event, float x, float y, int pointer, Actor actor) {
                mainActor.clearActions();
                mainActor.addAction(Actions.scaleTo(0.9f, 0.9f, 0.15f));

            }

            @Override
            public void exit(InputEvent event, float x, float y, int pointer, Actor actor) {
                mainActor.clearActions();
                mainActor.addAction(Actions.scaleTo(1f, 1f, 0.15f));
            }
        };
    }

    public static InputListener scaleHover(Actor mainActor) {
        mainActor.setOrigin(Align.center);
        return new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                mainActor.clearActions();
                mainActor.addAction(Actions.scaleTo(0.9f, 0.9f, 0.15f));
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                mainActor.clearActions();
                mainActor.addAction(Actions.scaleTo(1f, 1f, 0.15f));
            }
        };
    }

}
