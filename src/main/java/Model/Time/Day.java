package main.java.Model.Time;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Day {
    private String name;
    private Hour[] hours = new Hour[24];

    public Day(String name) {
        this.name = name;
        initializeHours();
    }

    private void initializeHours() {
        for (int i = 0; i < hours.length; i++) {
            hours[i] = new Hour(i);
        }
    }

    public Hour getHour(int hourIndex) {
        if (hourIndex >= 0 && hourIndex < hours.length) {
            return hours[hourIndex];
        } else {
            throw new IllegalArgumentException("Invalid hour index: " + hourIndex);
        }
    }

    public String getName() {
        return name;
    }

    // Additional methods as needed
}