package com.returntosirandora;

import java.util.HashMap;
import java.util.Map;

public class Bootloader {
    public static final String START_SCENE = "Gameplay";
    public static final HashMap<String, String> SCENES = new HashMap<>(Map.of(
            "Menu", "com.returntosirandora.scenes.Menu",
            "LoadingGame", "com.returntosirandora.scenes.LoadingScene$LoadingGame",
            "LoadingMenu", "com.returntosirandora.scenes.LoadingScene$LoadingMenu",
            "Gameplay", "com.returntosirandora.scenes.GamePlay"));

}
