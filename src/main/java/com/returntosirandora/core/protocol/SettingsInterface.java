package com.returntosirandora.core.protocol;

public interface SettingsInterface {
    public <T> T get(String key, Class<T> type);

    public <T> T get(String key, Class<T> type, T defaultValue);

    public void set(String key, Object value);

    public <T> T getSet(String key, Class<T> type, T defaultValue);

    public void saveData();
}
