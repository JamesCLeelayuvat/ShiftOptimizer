package main.java.Model.Staff;

import main.java.Model.Schedules.WorkerSchedule;

public abstract class Worker
{
    String status;

    String username;

    //int workerID;

    //WorkerSchedule schedule;

    String password;

    @Override
    public String toString() {
        return "Worker{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", status='" + status + '\'' +
                '}';
    }


}
