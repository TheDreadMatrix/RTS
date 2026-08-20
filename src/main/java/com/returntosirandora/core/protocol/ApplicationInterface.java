package com.returntosirandora.core.protocol;

import com.badlogic.gdx.assets.AssetManager;
import com.returntosirandora.core.runtime.RTSPath;
import com.returntosirandora.core.runtime.RTSRouter;

public interface ApplicationInterface {
    public RTSPath getPaths();

    public RTSRouter getRouter();

    public AssetManager getAssets();

    public SettingsInterface getSettings();

    public void clear(float r, float g, float b);
}
