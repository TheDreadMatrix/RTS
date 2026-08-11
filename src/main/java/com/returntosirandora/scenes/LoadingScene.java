package com.returntosirandora.scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class LoadingScene extends BaseScene {
        private Stage stage;

        private ProgressBar progressBar;
        private BitmapFont font;
        private Label progressLabel;

        private Texture barBackgroundTexture;
        private Texture barFillTexture;

        private float timer;

        @Override
        public void create() {
                stage = new Stage(new ScreenViewport());

                // Фон прогресс-бара
                barBackgroundTexture = createTexture(
                                1, 1,
                                Color.DARK_GRAY);

                // Заполнение прогресс-бара
                barFillTexture = createTexture(
                                1, 1,
                                Color.WHITE);

                ProgressBar.ProgressBarStyle style = new ProgressBar.ProgressBarStyle();

                style.background = new TextureRegionDrawable(
                                new com.badlogic.gdx.graphics.g2d.TextureRegion(
                                                barBackgroundTexture));

                style.knob = new TextureRegionDrawable(
                                new com.badlogic.gdx.graphics.g2d.TextureRegion(
                                                barFillTexture));

                style.knobBefore = new TextureRegionDrawable(
                                new com.badlogic.gdx.graphics.g2d.TextureRegion(
                                                barFillTexture));

                progressBar = new ProgressBar(
                                0f,
                                1f,
                                0.01f,
                                false,
                                style);

                progressBar.setValue(0f);

                font = new BitmapFont();

                Label.LabelStyle labelStyle = new Label.LabelStyle();
                labelStyle.font = font;

                progressLabel = new Label("Loading... 0%", labelStyle);

                Table table = new Table();
                table.setFillParent(true);

                table.add(progressLabel)
                                .padBottom(15)
                                .row();

                table.add(progressBar)
                                .width(400)
                                .height(25);

                stage.addActor(table);

                // Твой ресурс
                assets.load(paths.getMusic("menu.ogg").path(), Music.class);

        }

        @Override
        public void update(float deltaTime) {
                timer += deltaTime;

                if (timer >= 2.5) {
                        boolean finished = assets.update();

                        float progress = assets.getProgress();

                        progressBar.setValue(progress);

                        progressLabel.setText("Loading... " + (int) (progress * 100) + "%");

                        if (finished) {

                                router.redirectingTo("Menu");
                        }
                }
        }

        @Override
        public void resize(int width, int height) {
                stage.getViewport().update(width, height, true);
        }

        @Override
        public void render() {
                game.clear(0.5f, 0.5f, 0.5f);

                stage.act(Gdx.graphics.getDeltaTime());
                stage.draw();
        }

        @Override
        public void end() {
                stage.dispose();

                barBackgroundTexture.dispose();
                barFillTexture.dispose();
        }

        private Texture createTexture(int width, int height, Color color) {
                Pixmap pixmap = new Pixmap(
                                width,
                                height,
                                Pixmap.Format.RGBA8888);

                pixmap.setColor(color);
                pixmap.fill();

                Texture texture = new Texture(pixmap);

                pixmap.dispose();

                return texture;
        }
}
