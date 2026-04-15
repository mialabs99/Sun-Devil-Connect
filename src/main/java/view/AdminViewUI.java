package view;

import controller.ViewManager;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import model.Admin;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class AdminViewUI {

    public static Parent adminView(Admin admin) {
        Label adminViewLabel = new Label("Welcome " + admin.getFirstName() + " " + admin.getLastName() + "!");
        VBox dateTimeBox = dateTimeBox();
        Button exit = new Button("Exit");
        exit.setOnAction(e -> ViewManager.displayWelcomePage());
        VBox adminViewBox = new VBox();
        adminViewBox.getChildren().addAll(adminViewLabel, dateTimeBox, exit);
        adminViewBox.setSpacing(10);
        adminViewBox.setAlignment(Pos.CENTER);
        return adminViewBox;
    }

    //Gets the current date and time for the admin
    public static VBox dateTimeBox() {
        LocalDate date = LocalDate.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String formattedDate = date.format(dateFormatter);
        LocalTime time = LocalTime.now();
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm a");
        String formattedTime = time.format(timeFormatter);
        VBox dateTimeBox = new VBox();
        Label dateLabel = new Label("Today's date is: " + formattedDate);
        Label timeLabel = new Label("It is currently: " + formattedTime);
        dateTimeBox.getChildren().addAll(dateLabel, timeLabel);
        return dateTimeBox;
    }
}
