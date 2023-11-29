package main.java.Model.Time;

public class Day {
    public String name;
    public Hour[] hours = new Hour[24];

    public Day(String name) {
        this.name = name;
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
}
