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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Club;
import model.Event;
import model.Student;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static controller.SaveLoadData.*;

//UI for student users
public class StudentViewUI {

    private List<Club> studentClubs;

    public static Parent studentView(Student student) {
        Label studentViewLabel = new Label("Welcome " + student.getFirstName() + "!");
        VBox dateTimeBox = dateTimeBox();
        Button exit = new Button("Exit");
        exit.setOnAction(e -> ViewManager.displayWelcomePage());
        VBox currentClubBox = currentClubBox(student);
        Button browseClubs = new Button("Browse Clubs");
        //Need to add browse clubs functionality
        browseClubs.setOnAction(e -> ViewManager.displayBrowseClubPage(student));
        currentClubBox.getChildren().add(browseClubs);
        VBox studentViewBox = new VBox();
        studentViewBox.getChildren().addAll(studentViewLabel, dateTimeBox, currentClubBox, exit);
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

    public static VBox currentClubBox(Student student) {
        VBox clubBox = new VBox();
        Label clubLabel = new Label("Here are your current clubs:");
        clubBox.getChildren().add(clubLabel);
        List<Club> currentClubs = student.getClubsJoined();
        for(Club club: currentClubs) {
            HBox clubInfo = new HBox();
            Label clubName = new Label("Club Name: " + club.getClubName() + " |");
            Label clubType = new Label("Club Type: " + club.getClubType() + " |");
            Label clubLeader = new Label("Lead By: " + club.getLeaderName() + " |");
            clubInfo.setSpacing(10);
            clubInfo.setAlignment(Pos.CENTER);
            clubInfo.getChildren().addAll(clubName, clubType, clubLeader);
            clubBox.getChildren().add(clubInfo);
        }
        clubBox.setSpacing(10);
        clubBox.setAlignment(Pos.CENTER);
        clubBox.setFillWidth(false);
        return clubBox;
    }
}
