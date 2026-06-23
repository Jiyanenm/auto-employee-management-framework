package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class EnvironmentConfig {

    private static Properties properties = new Properties();

    public static void loadEnvironment() {

        String env = System.getProperty("env", "qa"); // default = qa

        try {

            FileInputStream fis = new FileInputStream(
                    "src/test/resources/environments/" + env + ".properties"
            );

            properties.load(fis);

        } catch (Exception e) {
            throw new RuntimeException("Failed to load environment: " + env, e);
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}