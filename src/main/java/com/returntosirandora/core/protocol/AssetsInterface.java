package com.returntosirandora.core.protocol;

public interface AssetsInterface {

    public void beginScene(String sceneName);

    public void clearSceneResources();

    public void regMusic(String key, String musicPath, Boolean isGlobal);

    public MusicInterface getMusic(String key);

}
