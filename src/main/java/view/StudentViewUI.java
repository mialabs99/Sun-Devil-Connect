/**
 * Created by: Mia Laboranti
 * For: CSE460 at ASU
 * Date: April 3rd, 2026
 */

package view;

import controller.ViewManager;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import model.Event;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static controller.SaveLoadData.getEvents;
import static controller.SaveLoadData.loadEvents;

//UI for student users
public class StudentViewUI {

    public static Parent studentView(String firstName) {
        Label studentViewLabel = new Label("Welcome " + firstName + "!");
        VBox dateTimeBox = dateTimeBox();
        Button exit = new Button("Exit");
        exit.setOnAction(e -> ViewManager.displayWelcomePage());
        VBox studentViewBox = new VBox();
        studentViewBox.getChildren().addAll(studentViewLabel, dateTimeBox, exit);
        studentViewBox.setSpacing(10);
        studentViewBox.setAlignment(Pos.CENTER);
        return studentViewBox;
    }

    //Gets the current date and time for the student
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

    //Gets all events for the user to browse
    public static VBox eventBox() {
        VBox eventBox = new VBox();
        List<Event> events = null;
        try {
            loadEvents();
            events = getEvents();
        } catch (Exception e) {
            System.out.println("Could not load events: " + e.getMessage());
        }
        return eventBox;
    }
}
