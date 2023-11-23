package main.java.Controller;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import main.java.Controller.File.Jackson;
import main.java.Controller.Security.BouncyCastle;

import java.io.File;

public class main {
    public static void main(String[] args) {
        Jackson.addWorker("test1", "pass1", "ST");
        BouncyCastle.loginTest("test1", "pass1");
    }
}
