package com.returntosirandora;

import java.io.Reader;
import java.io.Writer;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import com.returntosirandora.core.protocol.SettingsInterface;

public class Johnson implements SettingsInterface {

    private Path filePath;

    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private Map<String, Object> gsonDict;

    public Johnson(String filePath) {
        this.filePath = Path.of(filePath);
    }

    public Johnson loadData() {
        try {

            try (Reader reader = Files.newBufferedReader(filePath)) {
                gsonDict = gson.fromJson(reader, new TypeToken<Map<String, Object>>() {
                }.getType());
            }

        } catch (IOException e) {
            e.printStackTrace();
            gsonDict = new HashMap<>();
        }

        return this;
    }

    @Override
    public void saveData() {
        try {
            Path parent = filePath.getParent();

            if (parent != null) {
                Files.createDirectories(parent);
            }

            try (Writer writer = Files.newBufferedWriter(filePath)) {
                gson.toJson(gsonDict, writer);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public <T> T getSet(String key, Class<T> type, T defaultValue) {
        T value = get(key, type);

        if (value == null) {
            set(key, defaultValue);
            return defaultValue;
        }

        return value;
    }

    @Override
    public <T> T get(String key, Class<T> type) {
        Object value = gsonDict.get(key);

        if (value == null) {
            return null;
        }

        return gson.fromJson(gson.toJson(value), type);
    }

    @Override
    public <T> T get(String key, Class<T> type, T defaultValue) {
        T value = get(key, type);

        return value != null ? value : defaultValue;
    }

    @Override
    public void set(String key, Object value) {
        gsonDict.put(key, value);
    }

}
