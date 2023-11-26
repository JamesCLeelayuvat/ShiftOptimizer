package main.java.Controller;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Scanner;

import main.java.Controller.File.Jackson;
import main.java.Controller.Security.BouncyCastle;
import main.java.Model.Staff.Worker;
import main.java.View.*;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {

        CLI cli = new CLI();
        cli.run();

    }
}
