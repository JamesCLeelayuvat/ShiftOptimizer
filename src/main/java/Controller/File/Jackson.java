package main.java.Controller.File;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.File;
import java.lang.reflect.Array;

public class Jackson {

    private static File getJsonFile(){
        File jsonFile = new File("src/main/resources/data.json");
        return jsonFile;
    }
    private static JsonNode getRootNode() {

        //Getting and returning the root node
        try {
            File jsonFile = getJsonFile();
            ObjectMapper objectMapper = getObjectMapper();
            JsonNode rootNode = objectMapper.readTree(jsonFile);
            return rootNode;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    private static ObjectMapper getObjectMapper() {

//        Creating and returning the objectmapper
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper;
    }

    private static ObjectWriter getObjectWriter(){
        ObjectWriter objectWriter = getObjectMapper().writerWithDefaultPrettyPrinter();
        return objectWriter;
    }
    public static void addWorker(String username, String password, String status) {
        JsonNode rootNode = getRootNode();
        ObjectMapper objectMapper = getObjectMapper();
        ObjectWriter objectWriter = getObjectWriter();
        JsonNode newWorker = objectMapper.createObjectNode().put("username", username).put("password", password).put("status", status);
        ((com.fasterxml.jackson.databind.node.ArrayNode) rootNode.get("workers")).add(newWorker);

        try {
            objectWriter.writeValue(getJsonFile(), rootNode);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void removeWorker(String username) {
        JsonNode rootNode = getRootNode();
        ObjectMapper objectMapper = getObjectMapper();

        for (int i = 0; i < rootNode.get("workers").size(); i++) {
            if (username.equals(rootNode.get("workers").get(i).get("username").asText())) {
                System.out.println("Hello");
                System.out.println(i);
                ((com.fasterxml.jackson.databind.node.ArrayNode) rootNode.get("workers")).remove(i);
            }

        }
    }
}
