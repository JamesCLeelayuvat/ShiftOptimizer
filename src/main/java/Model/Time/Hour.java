package main.java.Model.Time;

import java.time.LocalTime;

public class Hour {
    // Each Hour contains two half-hour segments
    private boolean[] halfHours = new boolean[2];
    private LocalTime[] halfHourStartTimes = new LocalTime[2];

    public Hour(int hourOfDay) {
        for (int i = 0; i < 2; i++) {
            halfHours[i] = false;
            halfHourStartTimes[i] = LocalTime.of(hourOfDay, i * 30);
        }
    }

    // Set the status of a half-hour segment
    public void setHalfHour(int index, boolean status) {
        if (index >= 0 && index < halfHours.length) {
            halfHours[index] = status;
        } else {
            throw new IllegalArgumentException("Invalid half-hour index: " + index);
        }
    }

    // Get the status of a half-hour segment
    public boolean getHalfHour(int index) {
        if (index >= 0 && index < halfHours.length) {
            return halfHours[index];
        } else {
            throw new IllegalArgumentException("Invalid half-hour index: " + index);
        }
    }

    // Additional methods as needed
}

//Hour class contains array of two half hours that are a true or false boolean
    //boolean[] halfHour = new boolean[2];
