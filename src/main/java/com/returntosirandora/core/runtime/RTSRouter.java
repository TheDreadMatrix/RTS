package com.returntosirandora.core.runtime;

import java.util.HashMap;
import java.util.function.Supplier;

import com.returntosirandora.core.protocol.ApplicationInterface;
import com.returntosirandora.core.protocol.RouterInterface;
import com.returntosirandora.core.protocol.SceneInterface;
import com.returntosirandora.scenes.Menu;

public class RTSRouter implements RouterInterface {

    private HashMap<String, Supplier<SceneInterface>> sceneDict = new HashMap<>();
    private SceneInterface currentScene;

    private final ApplicationInterface game;

    private String currentName;
    private String whichScene;

    public RTSRouter(ApplicationInterface game) {
        this.game = game;

        sceneDict.put("Menu", () -> new Menu(game));

    }

    public void afterInit(String StartScene) {
        whichScene = StartScene;
        currentName = StartScene;

        currentScene = sceneDict.get(currentName).get();
        currentScene.create(game);
    }

    @Override
    public void redirectingTo(String sceneName) {
        currentName = sceneName;
    }

    @Override
    public String getName() {
        return currentName;
    }

    public void update(float deltaTime) {
        String stateScene = currentName;

        if (stateScene != whichScene) {
            whichScene = stateScene;
            currentScene.end();

            currentScene = sceneDict.get(whichScene).get();
            currentScene.create(game);

        }

        currentScene.update(deltaTime);
    }

    public void resize(int width, int height) {
        currentScene.resize(width, height);
    }

    public void render() {
        currentScene.render();
    }

}