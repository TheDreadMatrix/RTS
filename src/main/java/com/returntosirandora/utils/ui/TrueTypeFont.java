package com.returntosirandora.utils.ui;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

public class TrueTypeFont {

    public static BitmapFont getFont(FileHandle fontPath, int fontSize, Color fontColor) {
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(fontPath);

        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();

        parameter.size = fontSize;
        parameter.color = fontColor;

        BitmapFont font = generator.generateFont(parameter);

        generator.dispose();

        return font;
    }

    public static BitmapFont getFont(FileHandle fontPath, int fontSize, Color fontColor, Color backFontColor) {

        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(fontPath);

        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();

        parameter.size = fontSize;
        parameter.color = fontColor;
        parameter.borderWidth = 2f;
        parameter.borderColor = backFontColor;

        BitmapFont font = generator.generateFont(parameter);

        generator.dispose();

        return font;
    }

}
