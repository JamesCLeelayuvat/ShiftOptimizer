package main.java.Model.Staff;
import com.fasterxml.jackson.annotation.JsonProperty;

import main.java.Model.Schedules.WorkerSchedule;

public class Worker
{
    @JsonProperty("username")
    private String userName;
    @JsonProperty("password")
    private String passWord;
    @JsonProperty("status")
    private String status;

    //int workerID;

    //WorkerSchedule schedule;


    @Override
    public String toString() {
        return "Worker{" +
                "username='" + userName + '\'' +
                ", password='" + passWord + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public Worker()
    {

    }


}
