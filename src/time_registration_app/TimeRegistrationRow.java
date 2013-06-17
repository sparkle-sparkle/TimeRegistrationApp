package time_registration_app;

/**
 * Created by rox on 17-06-13.
 */
public class TimeRegistrationRow {
    private String taskName;
    private long startTime;
    private long endTime;
    private long duration;

    public TimeRegistrationRow(String taskName, long startTime) {
        this.taskName = taskName;
        this.startTime = startTime;
    }

    public void calculateDuration(long endTime) {
        setEndTime(endTime);
        this.duration = endTime - startTime;
    }

    public String getTaskName() {
        return taskName;
    }

    public Long getDuration() {
        return duration;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

}
