package com.returntosirandora.scenes;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

import com.badlogic.gdx.graphics.Texture;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane.ScrollPaneStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.Slider.SliderStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.returntosirandora.characters.content.Characters;
import com.returntosirandora.utils.TrueTypeFont;

public class Menu extends BaseScene {

    Table table;

    BitmapFont font;

    @Override
    public void create() {
        font = TrueTypeFont.getFont(paths.getFont("PixelFont.ttf"), 32, 2, Color.WHITE, Color.BLACK);

        table = new Table();
        table.setFillParent(true);
        table.center();

        Skin skin = new Skin();
        TextureAtlas atlas = new TextureAtlas(paths.getImages("atlas/icons.atlas").path());

        SliderStyle sliderSt = new SliderStyle();

        sliderSt.background = new TextureRegionDrawable(new Texture(paths.getImages("ui/bg-slider.png")));
        sliderSt.knob = new TextureRegionDrawable(new Texture(paths.getImages("ui/knob-slider.png")));

        LabelStyle labelSt = new LabelStyle();

        labelSt.font = font;

        skin.add("myStyle", sliderSt);
        skin.add("myStyle", labelSt);

        Image image = new Image(atlas.findRegion("algol-icon-2026"));

        Label label = new Label("Hello", skin, "myStyle");
        label.setPosition(200, 200);
        Slider slider = new Slider(0, 100, 1, false, skin, "myStyle");

        table.add(image).padLeft(100).width(200).height(200);
        table.row();
        table.add(slider).width(300).height(30);

        mainStage.addActor(table);

    }

    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
    }

    @Override
    public void render() {
        super.render();

    }

    @Override
    public void end() {
        super.end();
        font.dispose();
    }
}
