import java.time.LocalTime;

public class Hour {
    private LocalTime time;
    private boolean isAvailable;

    public Hour(LocalTime time) {
        this.time = time;
        this.isAvailable = true; // Default to available
    }

    // Getters and setters
    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
    //Hour class contains array of two half hours that are a true or false boolean
    //boolean[] halfHour = new boolean[2];
