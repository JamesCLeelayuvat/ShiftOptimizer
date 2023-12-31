package main.java.Model.Time;

import java.util.ArrayList;
import java.util.List;

public class Week {
    public List<Day> days;

    public Week() {
        days = new ArrayList<>();
        String[] dayNames = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        // Set the number of days in the week here
        int totalDays = 7; // Change this to 14 for a two-week schedule

        for (int i = 0; i < totalDays; i++) {
            days.add(new Day(dayNames[i % 7]));
        }
    }

    public Day getDay(int dayIndex) {
        if (dayIndex >= 0 && dayIndex < days.size()) {
            return days.get(dayIndex);
        } else {
            throw new IllegalArgumentException("Invalid day index: " + dayIndex);
        }
    }
}
