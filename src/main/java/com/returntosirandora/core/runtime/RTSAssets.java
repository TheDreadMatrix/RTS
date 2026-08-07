package com.returntosirandora.core.runtime;

import com.returntosirandora.core.protocol.ApplicationInterface;
import com.returntosirandora.core.protocol.AssetsInterface;
import com.returntosirandora.core.protocol.MusicInterface;

public class RTSAssets implements AssetsInterface {

    ApplicationInterface game;

    public RTSAssets(ApplicationInterface game) {
        this.game = game;
    }

    @Override
    public void regMusic(String key, String musicPath, Boolean is_global) {

    }

    @Override
    public MusicInterface getMusic(String key) {

    }
}
