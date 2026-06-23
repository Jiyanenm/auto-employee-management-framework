package utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class JsonReader {

    private JsonNode rootNode;

    public JsonReader(String filePath) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            rootNode = mapper.readTree(new File(filePath));
        } catch (Exception e) {
            throw new RuntimeException("Failed to load JSON file: " + filePath, e);
        }
    }

    public String getValue(String path) {

        String[] keys = path.split("\\.");
        JsonNode currentNode = rootNode;

        for (String key : keys) {
            currentNode = currentNode.get(key);

            if (currentNode == null) {
                throw new RuntimeException("Invalid JSON path: " + path);
            }
        }

        return currentNode.asText();
    }
}