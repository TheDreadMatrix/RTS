package com.returntosirandora;

import java.io.Reader;
import java.io.Writer;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.files.FileHandle;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import com.returntosirandora.core.protocol.SettingsInterface;

public class Johnson implements SettingsInterface {

    private Path filePath;
    private FileHandle gdxFile;

    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private Map<String, Object> gsonDict;

    public Johnson(String filePath) {
        this.filePath = Path.of(filePath);
    }

    public Johnson(FileHandle file) {
        this.gdxFile = file;
    }

    public Johnson loadData() {
        try {
            if (gdxFile != null) {
                try (Reader reader = new InputStreamReader(gdxFile.read(), StandardCharsets.UTF_8)) {
                    gsonDict = gson.fromJson(reader, new TypeToken<Map<String, Object>>() {
                    }.getType());
                }
            } else {
                try (Reader reader = Files.newBufferedReader(filePath, StandardCharsets.UTF_8)) {
                    gsonDict = gson.fromJson(reader, new TypeToken<Map<String, Object>>() {
                    }.getType());
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
            gsonDict = new HashMap<>();
        }

        return this;
    }

    public void saveData(Map<String, Object> data) {
        try {
            Path parent = filePath.getParent();

            if (parent != null) {
                Files.createDirectories(parent);
            }

            try (Writer writer = Files.newBufferedWriter(filePath)) {
                gson.toJson(data, writer);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getInt(String key) {
        Object value = gsonDict.get(key);
        return value instanceof Number ? ((Number) value).intValue() : 0;
    }

    public int getInt(String key, int defaultValue) {
        Object value = gsonDict.get(key);
        return value instanceof Number ? ((Number) value).intValue() : defaultValue;
    }

    public float getFloat(String key) {
        Object value = gsonDict.get(key);
        return value instanceof Number ? ((Number) value).floatValue() : 0.0f;
    }

    public float getFloat(String key, float defaultValue) {
        Object value = gsonDict.get(key);
        return value instanceof Number ? ((Number) value).floatValue() : defaultValue;
    }

    public boolean getBoolean(String key) {
        Object value = gsonDict.get(key);
        return value instanceof Boolean ? (Boolean) value : false;
    }

    public boolean getBoolean(String key, boolean defaultValue) {
        Object value = gsonDict.get(key);
        return value instanceof Boolean ? (Boolean) value : defaultValue;
    }

    public String getString(String key) {
        Object value = gsonDict.get(key);
        return value instanceof String ? (String) value : "";
    }

    public String getString(String key, String defaultValue) {
        Object value = gsonDict.get(key);
        return value instanceof String ? (String) value : defaultValue;
    }

    public Map<String, Object> getDict(String key) {
        Object value = gsonDict.get(key);

        if (!(value instanceof Map<?, ?> map)) {
            return new HashMap<>();
        }

        Map<String, Object> result = new HashMap<>();

        for (Map.Entry<?, ?> entry : map.entrySet()) {
            if (entry.getKey() instanceof String stringKey) {
                result.put(stringKey, entry.getValue());
            }
        }

        return result;
    }

    public Map<String, Object> getDict(String key, Map<String, Object> defaultValue) {
        Object value = gsonDict.get(key);

        if (!(value instanceof Map<?, ?> map)) {
            return defaultValue;
        }

        Map<String, Object> result = new HashMap<>();

        for (Map.Entry<?, ?> entry : map.entrySet()) {
            if (entry.getKey() instanceof String stringKey) {
                result.put(stringKey, entry.getValue());
            }
        }

        return result;
    }

}
