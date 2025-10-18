package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties = new Properties();

    public static void loadProperties(String env) {
        String filePath = "src/test/resources/" + env + ".properties";
        try (FileInputStream fis = new FileInputStream(filePath)) {
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load properties file: " + filePath, e);
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    public static void loadConfig(String env) {
    }

    public static String get(String s) {
    }
}

