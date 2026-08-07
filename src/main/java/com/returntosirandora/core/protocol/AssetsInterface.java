package com.returntosirandora.core.protocol;

public interface AssetsInterface {
    public void regMusic(String key, String musicPath, Boolean isGlobal);

    public MusicInterface getMusic(String key);

}
