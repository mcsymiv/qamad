package com.qamad.config;

import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PropertiesConfig {

    public static final Logger log = LogManager.getLogger(PropertiesConfig.class.getName());
    private static Properties PROPERTIES;

    public static String getProperty(String key) {
        init();
        return PROPERTIES.getProperty(key);
    }

    private static void init() {
        if (PROPERTIES == null) {
            PROPERTIES = new Properties();
            URL configProperties = ClassLoader.getSystemResource("config.properties");
            try {
                PROPERTIES.load(configProperties.openStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
