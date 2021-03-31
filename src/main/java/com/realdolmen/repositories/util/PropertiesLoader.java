package com.realdolmen.repositories.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {
    public static Properties loadPropertiesFile() {
        Properties prop = new Properties();
        try (InputStream resourceAsStream = PropertiesLoader.class.getClassLoader().getResourceAsStream("db.properties")) {
            prop.load(resourceAsStream);
        } catch (IOException e) {
            System.err.println("Unable to load properties file : " );
        }
        return prop;

    }
}
