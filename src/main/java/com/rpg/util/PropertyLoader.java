package com.rpg.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by Mubashir on 11/18/2018.
 */
public class PropertyLoader {
    private static PropertyLoader propertyLoader;
    private Map<String, Properties> propertiesMap = new HashMap<>();

    public static PropertyLoader getPropertyLoader() {
        if (propertyLoader == null) {
            propertyLoader = new PropertyLoader();
        }
        return propertyLoader;
    }

    private PropertyLoader() {
        EnumSet.allOf(PropertyFiles.class)
                .forEach(propertyFiles -> propertiesMap.put(propertyFiles.getPropertyFile(), null));
    }

    private Properties loadProperties(String propFileName) throws IOException {
        Properties properties = new Properties();
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName)) {
            properties.load(inputStream);
        }
        return properties;
    }

    public String getProperty(String propertyName) {
        if (propertiesMap.get(PropertyFiles.MENU.getPropertyFile()) == null) {
            loadProperties();
        }
        for (Map.Entry<String, Properties> propertiesEntry : propertiesMap.entrySet()) {
            if (propertiesEntry.getValue().containsKey(propertyName)) {
                return propertiesEntry.getValue().getProperty(propertyName);
            }
        }

        return null;
    }

    private void loadProperties() {
        EnumSet.allOf(PropertyFiles.class).forEach(propertyFiles -> {
            try {
                propertiesMap.put(propertyFiles.getPropertyFile(), loadProperties(propertyFiles.getPropertyFile()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
