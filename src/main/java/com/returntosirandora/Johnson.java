package com.returntosirandora;

import java.util.Properties;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
//import com.google.gson.Gson;

public class Johnson {
    public static class Joshua {
        public Joshua() {

        }
    }

    public static class MrProper {
        private final String filePath;

        private final Properties props = new Properties();

        public MrProper(String file_path) {
            this.filePath = file_path;
            try (FileInputStream in = new FileInputStream(filePath)) {
                props.load(in);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        public void save() {
            try (FileOutputStream out = new FileOutputStream(filePath)) {
                props.store(out, "Return to Sirandora configuration");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public String getString(String key, String defaultValue) {
            return props.getProperty(key, defaultValue);
        }

        public int getInt(String key, int defaultValue) {
            return Integer.parseInt(props.getProperty(key, String.valueOf(defaultValue)));
        }

        public boolean getBoolean(String key, boolean defaultValue) {
            return Boolean.parseBoolean(props.getProperty(key, String.valueOf(defaultValue)));
        }

        public float getFloat(String key, float defaultValue) {
            return Float.parseFloat(props.getProperty(key, String.valueOf(defaultValue)));
        }

        public double getDouble(String key, double defaultValue) {
            return Double.parseDouble(props.getProperty(key, String.valueOf(defaultValue)));
        }

        public void setProperty(String key, String value) {
            props.setProperty(key, value);
        }

        public void setProperty(String key, int value) {
            props.setProperty(key, String.valueOf(value));
        }

        public void setProperty(String key, boolean value) {
            props.setProperty(key, String.valueOf(value));
        }

        public void setProperty(String key, float value) {
            props.setProperty(key, String.valueOf(value));
        }

        public void setProperty(String key, double value) {
            props.setProperty(key, String.valueOf(value));
        }

    }
}
