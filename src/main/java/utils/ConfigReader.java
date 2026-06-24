package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties = new Properties();

    static {
        try {
            FileInputStream fis =
                    new FileInputStream("src/test/resources/config.properties");
            properties.load(fis);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load config file", e);
        }
    }

    public static String getBaseUrl() {

        String env = System.getProperty("env", "qa");

        String key = env + ".base.url";

        String url = properties.getProperty(key);

        if (url == null || url.isEmpty()) {
            throw new RuntimeException("Missing config key: " + key);
        }

        return url;
    }
}