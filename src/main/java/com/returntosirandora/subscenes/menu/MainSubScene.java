package com.returntosirandora.subscenes.menu;

import com.badlogic.gdx.scenes.scene2d.Stage;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar.ProgressBarStyle;

import com.returntosirandora.utils.ui.DrawableManager;
import com.returntosirandora.utils.ui.ListenerUtils;
import com.returntosirandora.utils.ui.TrueTypeFont;
import com.returntosirandora.subscenes.BaseSubScene;

public class MainSubScene extends BaseSubScene {
        private Table root;
        private DrawableManager drawableMan = new DrawableManager();

        @Override
        public void create(Stage stage) {
                root = new Table();
                root.setFillParent(true);
                root.pad(10);

                BitmapFont font = TrueTypeFont.getFont(game.getPaths().getFont("PixelFont.ttf"), 16, Color.BLACK,
                                Color.WHITE);

                TextButtonStyle btnStyle = new TextButtonStyle();
                btnStyle.font = font;
                btnStyle.up = drawableMan.getDrawable(180, 60, Color.RED);
                btnStyle.down = drawableMan.getDrawable(180, 60, Color.GREEN);
                btnStyle.over = drawableMan.getDrawable(180, 60, Color.YELLOW);
                btnStyle.checked = drawableMan.getDrawable(180, 60, Color.BLUE);

                TextButton profile = new TextButton("PlayerName", btnStyle);
                profile.setTransform(true);

                profile.addListener(ListenerUtils.redirect("profile", redirect));
                profile.addListener(ListenerUtils.scaleHover(profile));

                TextButton brawlers = new TextButton("Brawlers", btnStyle);
                brawlers.setTransform(true);
                brawlers.addListener(ListenerUtils.redirect("brawlers", redirect));
                brawlers.addListener(ListenerUtils.scaleHover(brawlers));

                Table trophies = new Table();
                trophies.setTransform(true);

                LabelStyle lblStyle = new LabelStyle();
                lblStyle.font = font;

                Label trophiesLabel = new Label("Trophie Road", lblStyle);

                ProgressBarStyle prbStyle = new ProgressBarStyle();
                prbStyle.knobAfter = drawableMan.getDrawable(1, 25, Color.RED);
                prbStyle.knob = drawableMan.getDrawable(2, 25, Color.YELLOW);
                prbStyle.knobBefore = drawableMan.getDrawable(1, 25, Color.BLUE);

                ProgressBar progress = new ProgressBar(0f, 320f, 1f, false, prbStyle);

                progress.setValue(65);

                trophies.add(trophiesLabel)
                                .left()
                                .row();

                trophies.add(progress)
                                .width(300)
                                .height(25)
                                .left();

                trophies.addListener(ListenerUtils.scaleHoverMouse(trophies));
                trophies.addListener(new InputListener() {

                        @Override
                        public boolean touchDown(
                                        InputEvent event,
                                        float x,
                                        float y,
                                        int pointer,
                                        int button) {

                                redirect.accept("trophie-road");

                                return true;
                        }
                });

                TextButton settings = new TextButton("Settings", btnStyle);
                settings.setTransform(true);
                settings.addListener(ListenerUtils.redirect("settings", redirect));
                settings.addListener(ListenerUtils.scaleHover(settings));

                TextButton play = new TextButton("PLAY", btnStyle);
                play.setTransform(true);
                play.addListener(ListenerUtils.scaleHover(play));

                Table leftBlock = new Table();

                leftBlock.add(profile)
                                .width(180)
                                .height(60)
                                .left()
                                .row();

                leftBlock.add(brawlers)
                                .width(180)
                                .height(60)
                                .left()
                                .padTop(10);

                Table topBar = new Table();

                topBar.add(leftBlock)
                                .left()
                                .top();

                topBar.add(trophies)
                                .width(320)
                                .left()
                                .top()
                                .padLeft(25);

                topBar.add()
                                .growX();

                topBar.add(settings)
                                .width(140)
                                .height(60)
                                .right()
                                .top();

                Table bottomBar = new Table();

                bottomBar.add()
                                .growX();

                bottomBar.add(play)
                                .width(220)
                                .height(70)
                                .right();

                root.add(topBar)
                                .growX()
                                .top()
                                .row();

                root.add()
                                .grow()
                                .row();

                root.add(bottomBar)
                                .growX()
                                .bottom();

                stage.addActor(root);

        }

        @Override
        public void dispose() {
                root.remove();
                drawableMan.dispose();

        }
}