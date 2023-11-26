package main.java.Model.Schedules;

import main.java.Model.Time.Hour;
import main.java.Model.Time.Day;
import main.java.Model.Time.Week;
import java.time.LocalTime;

public class Shift {
    private LocalTime startTime;
    private LocalTime endTime;
    private String workerId; // or any identifier for the worker

    public Shift(LocalTime startTime, LocalTime endTime, String workerId) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.workerId = workerId;
    }

    // Getters and setters
    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public String getWorkerId() {
        return workerId;
    }

    public void setWorkerId(String workerId) {
        this.workerId = workerId;
    }

    // Additional methods as needed, like checking if a shift overlaps with another, etc.
}
