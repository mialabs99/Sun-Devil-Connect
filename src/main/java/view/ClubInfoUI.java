package view;

import controller.ViewManager;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Club;
import model.Event;
import model.Student;

import java.util.ArrayList;
import java.util.List;

public class ClubInfoUI {

    private static List<Event> clubEvents;

    public static VBox clubInfo(Student student, Club club) {
        clubEvents = new ArrayList<>();
        VBox clubInfo = new VBox();
        clubEvents = club.getUpcomingEvents();
        if(clubEvents != null && !clubEvents.isEmpty()) {
            for (Event event : clubEvents) {
                Label eventName = new Label("Event Name: " + event.getEventName() + " |");
                Label eventTime = new Label("Event Time: " + event.getTime() + " |");
                Label eventDate = new Label("Event Date: " + event.getDate() + " |");
                Label eventLocation = new Label("Event Location: " + event.getLocation());
                HBox eventBox = new HBox();
                eventBox.setSpacing(10);
                eventBox.setAlignment(Pos.CENTER);
                eventBox.getChildren().addAll(eventName, eventTime, eventDate, eventLocation);
                clubInfo.getChildren().add(eventBox);
            }
        } else {
            Label noEvents = new Label("No events have been created for this club yet!");
            clubInfo.getChildren().add(noEvents);
        }
        HBox buttonBox = new HBox();
        Button clubSignUp = new Button("Sign Up for Club");
        clubSignUp.setOnAction(e -> ViewManager.displaySignUpForClubPage(student, club));
        Button backButton = new Button("Back");
        backButton.setOnAction(e -> ViewManager.displayBrowseClubPage(student));
        buttonBox.getChildren().addAll(clubSignUp, backButton);
        buttonBox.setSpacing(10);
        clubInfo.getChildren().add(buttonBox);
        clubInfo.setSpacing(10);
        clubInfo.setAlignment(Pos.CENTER);
        clubInfo.setFillWidth(false);
        return clubInfo;
    }
}
