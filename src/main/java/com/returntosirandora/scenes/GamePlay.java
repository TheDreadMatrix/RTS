package com.returntosirandora.scenes;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.returntosirandora.GameCamera;
import com.returntosirandora.characters.content.Characters;
import com.returntosirandora.characters.logic.Character;

public class GamePlay extends BaseScene {
    GameCamera camera;

    SpriteBatch batch;
    Character player;

    @Override
    public void create(String sceneName) {
        camera = new GameCamera();

        batch = new SpriteBatch();

        player = new Character().initChr(Characters.REDIS, 100f, 100f);

    }

    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);
        player.update(deltaTime);
        camera.update(deltaTime, player.getX(), player.getY());

    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
        camera.resize(width, height);

    }

    @Override
    public void render() {
        super.render();

        batch.setProjectionMatrix(camera.getCombined());
        batch.begin();

        player.render(batch);

        batch.end();
    }

    @Override
    public void end() {
        super.end();
        batch.dispose();
        player.end();
    }
}
