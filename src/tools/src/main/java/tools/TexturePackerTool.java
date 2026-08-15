package tools;

import com.badlogic.gdx.graphics.Texture;

import com.badlogic.gdx.tools.texturepacker.TexturePacker;

public class TexturePackerTool {
    public static void main(String[] args) {
        String typePacker = args.length > 0 ? args[0] : "icons";
        String currentType = null;

        switch (typePacker) {
            case "icons":
                currentType = "icons";
                break;

            case "classes":
                currentType = "classes";
                break;

        }

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

        TexturePacker.process(settings, "src/main/resources/assets/images/" + currentType,
                "src/main/resources/assets/images/atlas/" + currentType, currentType);
    }
}