package com.returntosirandora.scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class Menu extends BaseScene {

    Texture texture;
    TextureRegion textureReg;
    SpriteBatch batch;
    Sprite sprite;
    Sprite sprite2;

    FitViewport viewport;

    ShaderProgram shader;
    OrthographicCamera camera;

    public void create() {

        // Runtime render
        batch = new SpriteBatch();

        texture = new Texture(paths.getImages("icon-region.png"));
        textureReg = new TextureRegion(texture, 197, 282, 183, 212);

        sprite = new Sprite(texture);
        sprite.flip(false, true);

        sprite2 = new Sprite(textureReg);
        sprite2.flip(false, true);

        shader = new ShaderProgram(paths.getShader("basic.vert"), paths.getShader("basic.frag"));

        camera = new OrthographicCamera();
        camera.setToOrtho(true, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.update();

        Music music = assets.get(paths.getMusic("menu.ogg").path(), Music.class);
        music.play();

        viewport = new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), camera);

    }

    public void resize(int width, int height) {
        camera.setToOrtho(true, width, height);
        camera.update();

        viewport.update(width, height, true);
    }

    public void update(float deltaTime) {

        if (Gdx.input.isKeyJustPressed(Input.Keys.W))
            router.redirectingTo("Test");

    }

    public void render() {
        game.clear(1, 0, 0);

        camera.update();
        viewport.apply();

        batch.setProjectionMatrix(viewport.getCamera().combined);
        batch.setShader(shader);

        batch.begin();

        sprite.setPosition(0, 0);
        sprite.draw(batch);

        sprite2.setPosition(100, 100);
        sprite2.draw(batch);

        batch.end();
    }

    public void end() {
        assets.unload(paths.getMusic("menu.ogg").path());

        shader.dispose();
        texture.dispose();
        batch.dispose();

    }
}
