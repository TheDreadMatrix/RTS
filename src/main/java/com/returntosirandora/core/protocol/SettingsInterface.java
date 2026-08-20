package com.returntosirandora.core.protocol;

public interface SettingsInterface {
    public int getInt(String key);

    public int getInt(String key, int defaultValue);

    public float getFloat(String key);

    public float getFloat(String key, float defaultValue);

    public boolean getBoolean(String key);

    public boolean getBoolean(String key, boolean defaultValue);
}
