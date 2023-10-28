package com.ors;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private Properties properties;

    public ConfigReader() {
        properties = new Properties();
        loadProperties();
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    private void loadProperties() {
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            if (inputStream != null) {
                properties.load(inputStream);
            } else {
                System.err.println("Unable to find config.properties file");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}