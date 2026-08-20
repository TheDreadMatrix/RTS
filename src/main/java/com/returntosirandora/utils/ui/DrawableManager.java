package com.returntosirandora.utils.ui;

import java.util.ArrayList;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class DrawableManager {
    private ArrayList<Texture> textures = new ArrayList<>();

    public Drawable getDrawable(int width, int height, Color color) {
        Pixmap pixmap = new Pixmap(width, height, Pixmap.Format.RGB888);
        pixmap.setColor(color);
        pixmap.fill();

        Texture texture = new Texture(pixmap);
        textures.add(texture);
        pixmap.dispose();

        return new TextureRegionDrawable(texture);
    }

    public Drawable getDrawable(FileHandle path) {
        Texture texture = new Texture(path);
        textures.add(texture);

        return new TextureRegionDrawable(texture);
    }

    public void dispose() {
        for (Texture texture : textures) {
            texture.dispose();
        }

        textures.clear();
    }
}
