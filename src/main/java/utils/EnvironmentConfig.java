package utils;

import java.io.InputStream;
import java.util.Properties;

public class EnvironmentConfig {

    private static final Properties properties = new Properties();

    public static void loadEnvironment() {

        String env = System.getProperty("env", "qa");

        try {

            String fileName = "environments/" + env + ".properties";

            InputStream inputStream =
                    EnvironmentConfig.class
                            .getClassLoader()
                            .getResourceAsStream(fileName);

            if (inputStream == null) {
                throw new RuntimeException(
                        "Environment file not found: " + fileName
                );
            }

            properties.clear();
            properties.load(inputStream);

        } catch (Exception e) {
            throw new RuntimeException(
                    "Failed to load environment: " + env,
                    e
            );
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}