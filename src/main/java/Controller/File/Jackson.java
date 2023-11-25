package main.java.Controller.File;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.node.ObjectNode;
import main.java.Controller.Security.BouncyCastle;



import java.util.ArrayList;
import java.util.List;
import main.java.Model.Staff.Worker;



import java.io.File;
import java.lang.reflect.Array;

import static main.java.Controller.Security.BouncyCastle.hashPassword;

public class Jackson {

    private static File getJsonFile() {
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

    private static ObjectWriter getObjectWriter() {
        ObjectWriter objectWriter = getObjectMapper().writerWithDefaultPrettyPrinter();
        return objectWriter;
    }

    public static void addWorker(String username, String password, String status) {
        //Have to check for duplicate usernames

        // I updated what you wrote here
        JsonNode rootNode = getRootNode();
        ObjectMapper objectMapper = getObjectMapper();
        ObjectWriter objectWriter = getObjectWriter();

        // Check if username already exists
        boolean usernameExists = false;
        JsonNode workersNode = rootNode.path("workers");
        for (JsonNode workerNode : workersNode) {
            if (workerNode.path("username").asText().equals(username)) {
                usernameExists = true;
                break;
            }
        }

        // Add new worker only if username is unique
        if (!usernameExists) {
            JsonNode newWorker = objectMapper.createObjectNode()
                    .put("username", username)
                    .put("password", hashPassword(password))
                    .put("status", status);
            ((com.fasterxml.jackson.databind.node.ArrayNode) workersNode).add(newWorker);

            try {
                objectWriter.writeValue(getJsonFile(), rootNode);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Username already exists. Please choose a different username.");
        }



        /*JsonNode rootNode = getRootNode();
        ObjectMapper objectMapper = getObjectMapper();
        ObjectWriter objectWriter = getObjectWriter();
        JsonNode newWorker = objectMapper.createObjectNode().put("username", username).put("password", hashPassword(password)).put("status", status);
        ((com.fasterxml.jackson.databind.node.ArrayNode) rootNode.get("workers")).add(newWorker);

        try {
            objectWriter.writeValue(getJsonFile(), rootNode);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }

    public static void removeWorker(String username) {
        JsonNode rootNode = getRootNode();
        ObjectMapper objectMapper = getObjectMapper();
        ObjectWriter objectWriter = getObjectWriter();

        for (int i = 0; i < rootNode.get("workers").size(); i++) {
            if (username.equals(rootNode.get("workers").get(i).get("username").asText())) {
                System.out.println("Hello");
                System.out.println(i);
                ((com.fasterxml.jackson.databind.node.ArrayNode) rootNode.get("workers")).remove(i);
                try {
                    objectWriter.writeValue(getJsonFile(), rootNode);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public static int getIndexFromUsername(String username) {
        JsonNode rootNode = getRootNode();

        for (int i = 0; i < rootNode.get("workers").size(); i++) {
            if (username.equals(rootNode.get("workers").get(i).get("username").asText())) {
                return i;
            }
        }
        return -1;
    }

    public static String getPasswordFromIndex(int i){
        JsonNode rootNode = getRootNode();

        return rootNode.get("workers").get(i).get("password").asText();

    }
//    public static boolean checkDuplicateUsername(){
//
//    }


    //Reece's stuff
    public static List<Worker> getAllWorkers() {
        try {
            JsonNode rootNode = getRootNode();
            ObjectMapper objectMapper = getObjectMapper();
            // Assuming the workers are stored in an array under the "workers" field
            if (rootNode != null && rootNode.has("workers")) {
                return objectMapper.convertValue(
                        rootNode.get("workers"),
                        new TypeReference<List<Worker>>() {}
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public static void clearJsonFile() {
        ObjectMapper objectMapper = getObjectMapper();
        ObjectWriter objectWriter = getObjectWriter();

        // Create a new JSON object with an empty "workers" array
        ObjectNode rootNode = objectMapper.createObjectNode();
        rootNode.putArray("workers");

        // Write the new empty structure back to the file
        try {
            objectWriter.writeValue(getJsonFile(), rootNode);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
