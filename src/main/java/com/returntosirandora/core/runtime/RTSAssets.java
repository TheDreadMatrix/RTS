package com.returntosirandora.core.runtime;

import com.returntosirandora.core.audio.RTSMusic;
import com.returntosirandora.core.protocol.ApplicationInterface;
import com.returntosirandora.core.protocol.AssetsInterface;
import com.returntosirandora.core.protocol.MusicInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RTSAssets implements AssetsInterface {

    private ApplicationInterface game;

    private String ownerScene;

    private HashMap<String, MusicInterface> musics = new HashMap<>();

    private HashMap<String, List<List<String>>> dictStack = new HashMap<>();

    public RTSAssets(ApplicationInterface game) {
        this.game = game;
    }

    @Override
    public void beginScene(String sceneName) {
        ownerScene = sceneName;
        dictStack.putIfAbsent(sceneName, new ArrayList<>());
    }

    @Override
    public void clearSceneResources() {
        List<List<String>> stack = dictStack.remove(ownerScene);

        for (List<String> entry : stack) {
            String resType = entry.get(0);
            String resKey = entry.get(1);

            if (resType.equals("MUSIC")) {
                MusicInterface music = musics.remove(resKey);
                music.dispose();

            } else if (resType.equals("SOUND")) {

            } else if (resType.equals("SHADER")) {

            } else if (resType.equals("IMAGES")) {

            } else if (resType.equals("FONTS")) {

            }

        }

    }

    private void setToStack(String sceneName, String resType, String resKey, Boolean isGlobal) {
        if (isGlobal) {
            return;
        }

        dictStack.computeIfAbsent(ownerScene, key -> new ArrayList<>()).add(List.of(resType, resKey));

    }

    // Overrides
    @Override
    public void regMusic(String key, String musicPath, Boolean isGlobal) {
        if (musics.containsKey(key)) {
            return;
        }

        musics.put(key, new RTSMusic(game).loadMusic(musicPath, true, 1.0f));
        setToStack(ownerScene, "MUSIC", key, isGlobal);
    }

    @Override
    public MusicInterface getMusic(String key) {
        return musics.get(key);
    }
}
