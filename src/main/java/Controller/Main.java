package main.java.Controller;


import main.java.Controller.File.JacksonEditor;
import main.java.Controller.File.JacksonGetter;
import main.java.Model.Schedules.Shift;
import main.java.Model.Schedules.ShiftConflictException;
import main.java.Model.Staff.Worker;
import main.java.Model.Time.Day;
import main.java.View.*;




import java.time.LocalTime;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args)
    {

        CLI cli = new CLI();
        cli.run();

        //BIG TEST TO SEE IF WORKERS HOLD THEIR SCHEDULES

        // Create a worker
        //Tests if we hardcode a worker
        //JacksonEditor.addWorker("test1", "pass1", "ST");


        Worker worker = JacksonGetter.getWorkerByUsername("test1");

        //ArrayList<Worker> workers = (ArrayList<Worker>) JacksonGetter.getAllWorkers();

        if (worker == null) {
            System.out.println("Worker not found");
            return;
        }

        // Create days (assuming you have a Day class)
        Day monday = new Day("Monday");
        Day tuesday = new Day("Tuesday");

        // Create shifts
        Shift shift1 = new Shift(LocalTime.of(9, 0), LocalTime.of(17, 0), worker, monday);
        Shift shift2 = new Shift(LocalTime.of(10, 0), LocalTime.of(18, 0), worker, tuesday);

        // Assign shifts to the worker
        try {
            worker.addShift(shift1);
            worker.addShift(shift2);
        } catch (ShiftConflictException e) {
            System.out.println(e.getMessage());
        }

        // Print the worker's schedule
        System.out.println("Schedule for " + worker.getUserName() + ":");
        System.out.println(worker.printSchedule());
    }



}

