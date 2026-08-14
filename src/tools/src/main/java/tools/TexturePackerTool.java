package tools;

import com.badlogic.gdx.graphics.Texture;

import com.badlogic.gdx.tools.texturepacker.TexturePacker;

public class TexturePackerTool {
    public static void main(String[] args) {

        TexturePacker.Settings settings = new TexturePacker.Settings();

        // Для pixel art
        settings.filterMin = Texture.TextureFilter.Nearest;
        settings.filterMag = Texture.TextureFilter.Nearest;

        // Небольшой отступ между изображениями
        settings.duplicatePadding = true;

        settings.maxWidth = 2048;
        settings.maxHeight = 2048;

        settings.paddingX = 2;
        settings.paddingY = 2;

        TexturePacker.process(settings, "src/main/resources/assets/images/icons",
                "src/main/resources/assets/images/atlas", "icons");
    }
}