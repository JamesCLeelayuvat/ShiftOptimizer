package main.java.Model.Schedules;

import main.java.Model.Time.Hour;
import main.java.Model.Time.Day;
import main.java.Model.Time.Week;

import java.util.ArrayList;
import java.util.List;

public class Schedule {
    private List<Shift> shifts;

    public Schedule() {
        this.shifts = new ArrayList<>();
    }

    public void addShift(Shift shift) {
        // You might want to check for conflicts before adding
        shifts.add(shift);
    }

    public boolean removeShift(Shift shift) {
        return shifts.remove(shift);
    }

    public List<Shift> getShifts() {
        return new ArrayList<>(shifts); // Return a copy to prevent external modification
    }

    // Method to check for shift conflicts
    public boolean hasConflict(Shift newShift) {
        for (Shift existingShift : shifts) {
            if (shiftsOverlap(existingShift, newShift)) {
                return true;
            }
        }
        return false;
    }

    private boolean shiftsOverlap(Shift shift1, Shift shift2) {
        return !shift1.getEndTime().isBefore(shift2.getStartTime()) &&
                !shift2.getEndTime().isBefore(shift1.getStartTime());
    }

    // Additional methods as needed
}