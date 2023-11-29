package main.java.Model.Schedules;

import main.java.Model.Time.Hour;
import main.java.Model.Time.Day;
import main.java.Model.Time.Week;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalTime;

public class Shift {
    private LocalTime startTime;
    private LocalTime endTime;
    @JsonProperty("username")
    private String userName; // or any identifier for the worker

    public Shift(LocalTime startTime, LocalTime endTime, String userName) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.userName = userName;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    // Additional methods as needed, like checking if a shift overlaps with another, etc.
}
