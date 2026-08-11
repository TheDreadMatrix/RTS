package com.returntosirandora.core.runtime;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

import com.badlogic.gdx.Gdx;
import com.returntosirandora.Johnson;
import com.returntosirandora.core.protocol.ApplicationInterface;
import com.returntosirandora.core.protocol.SceneInterface;
import com.returntosirandora.core.protocol.runtime.RouterInterface;

public class RTSRouter implements RouterInterface {

    private HashMap<String, Supplier<SceneInterface>> sceneDict = new HashMap<>();
    private SceneInterface currentScene;

    private final ApplicationInterface game;

    private List<String> allScenes = new ArrayList<>();

    private String StartScene;
    private String currentName;
    private String whichScene;

    private void registerScene(String key, String className) {
        try {
            Class<? extends SceneInterface> sceneClass = Class.forName(className).asSubclass(SceneInterface.class);
            sceneDict.put(key, () -> {
                try {
                    return sceneClass.getDeclaredConstructor().newInstance()._initScene(game, key);
                } catch (Exception exception) {
                    throw new RuntimeException("Failed to create scene: " + className, exception);
                }
            });

            allScenes.add(key);

        } catch (ClassNotFoundException e) {
            Gdx.app.error("ERROR", "Class not found", e);
        }
    }

    public RTSRouter(ApplicationInterface game) {
        this.game = game;

        Johnson joshua = new Johnson(game.getPaths()._forInternal("scenes.json")).loadData();

        StartScene = joshua.getString("StartScene");

        Map<?, ?> scenes = joshua.getDict("Scenes");

        for (Map.Entry<?, ?> entry : scenes.entrySet()) {
            String key = (String) entry.getKey();
            String value = (String) entry.getValue();

            registerScene(key, value);
        }

    }

    public void afterInit() {

        whichScene = StartScene;
        currentName = StartScene;

        currentScene = sceneDict.get(currentName).get();

        currentScene.create();
    }

    @Override
    public void redirectingTo(String sceneName) {
        currentName = sceneName;
    }

    @Override
    public String getName() {
        return currentName;
    }

    @Override
    public List<String> getAllScenes() {
        return allScenes;
    }

    public void update(float deltaTime) {
        String stateScene = currentName;

        if (!stateScene.equals(whichScene)) {
            whichScene = stateScene;
            currentScene.end();

            currentScene = sceneDict.get(whichScene).get();

            currentScene.create();

        }

        currentScene.update(deltaTime);
    }

    public void resize(int width, int height) {
        currentScene.resize(width, height);
    }

    public void pause() {
        currentScene.pause();
    }

    public void resume() {
        currentScene.resume();
    }

    public void render() {
        currentScene.render();
    }

}