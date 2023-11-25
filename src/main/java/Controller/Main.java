package main.java.Controller;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Scanner;

import main.java.Controller.File.Jackson;
import main.java.Controller.Security.BouncyCastle;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Welcome to Shift Optimizer CLI");
            System.out.println("1. Add Worker");
            System.out.println("2. View Workers");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    // Add logic to add a worker
                    Jackson.addWorker("test1", "pass1", "ST");
                    BouncyCastle.loginTest("test1", "pass1");
                    break;
                case 2:
                    // Add logic to view workers
                    break;
                case 3:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
