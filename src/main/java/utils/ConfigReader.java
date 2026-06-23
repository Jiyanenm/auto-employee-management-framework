package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    String env = System.getProperty("env", properties.getProperty("env"));

    private static Properties properties = new Properties();

    static {
        try {
            FileInputStream file =
                    new FileInputStream("src/test/resources/config.properties");

            properties.load(file);

        } catch (Exception e) {
            throw new RuntimeException("Config file not found");
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }

    public static String getBaseUrl() {
        String env = get("env");
        return properties.getProperty(env + ".url");
    }
}