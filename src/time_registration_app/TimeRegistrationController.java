package time_registration_app;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class TimeRegistrationController {
    private TimeRegistrationRow row;
    public Label lblTime;
    public Label lblTaskName;
    public TextField tfTaskName;
    public Button btnStart;
    public Button btnStop;


    public void startTimer(ActionEvent actionEvent) {
        row = new TimeRegistrationRow(tfTaskName.getText(), new Date().getTime());
        toggleStartAndEndButtons();
    }

    public void stopTimer(ActionEvent actionEvent) {
        row.calculateDuration(new Date().getTime());
        lblTime.setText(row.getTaskName() + ": " + formatToTime(row.getDuration()));
        toggleStartAndEndButtons();
    }

    private String formatToTime(long duration) {
        DateFormat df = new SimpleDateFormat("HH:mm:ss");
        df.setTimeZone(TimeZone.getTimeZone("GMT+0"));
        return df.format(duration);
    }

    private void toggleStartAndEndButtons() {
        if (btnStart.isDisable()) {
            btnStart.setDisable(false);
            btnStop.setDisable(true);
        } else {
            btnStart.setDisable(true);
            btnStop.setDisable(false);
        }
    }

}
