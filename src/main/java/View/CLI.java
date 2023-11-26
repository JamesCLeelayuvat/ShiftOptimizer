package main.java.View;
import main.java.Controller.File.Jackson;
import main.java.Model.Staff.Worker;

import java.util.List;
import java.util.Scanner;

public class CLI {
    public void run()
    {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Welcome to Shift Optimizer CLI");
            System.out.println("1. Add Worker");
            System.out.println("2. View Workers");
            System.out.println("3. Exit");
            System.out.println("4. Clear JSON File");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    // Add logic to add a worker

                    System.out.print("Enter username: ");
                    String username = scanner.next();
                    System.out.print("Enter password: ");
                    String password = scanner.next();
                    System.out.print("Enter status (ST/AD): ");
                    String status = scanner.next();
                    Jackson.addWorker(username, password, status);

                    //Jackson.addWorker("test1", "pass1", "ST");
                    //BouncyCastle.loginTest("test1", "pass1");
                    break;
                case 2:
                    List<Worker> workers = Jackson.getAllWorkers();
                    for (Worker worker : workers) {
                        System.out.println(worker);
                    }
                    break;
                case 3:
                    running = false;
                    break;
                case 4:
                    Jackson.clearJsonFile();
                    System.out.println("JSON file cleared.");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
