package view;

import controller.ViewManager;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Club;
import model.Leader;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static controller.SaveLoadData.getClubs;

public class LeaderViewUI {
    private static String leaderName;
    private static List<Club> leaderClubs;

    public static Parent leaderView(Leader leader) {
        leaderName = leader.getFirstName() + " " + leader.getLastName();
        Label leaderViewLabel = new Label("Welcome " + leaderName + "!");
        VBox dateTimeBox = dateTimeBox();
        Button exit = new Button("Exit");
        exit.setOnAction(e -> ViewManager.displayWelcomePage());
        VBox clubBox = clubBox();
        VBox leaderViewBox = new VBox();
        Button addAClub = new Button("Add a Club");
        addAClub.setOnAction(e -> ViewManager.displayCreateClubPage(leader));
        clubBox.getChildren().add(addAClub);
        leaderViewBox.getChildren().addAll(leaderViewLabel, dateTimeBox, clubBox, exit);
        leaderViewBox.setSpacing(10);
        leaderViewBox.setAlignment(Pos.CENTER);
        return leaderViewBox;
    }

    //Gets the current date and time for the leader
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

    //Gets all information about the leader's clubs
    public static VBox clubBox() {
        VBox clubBox = new VBox();
        Label clubLabel = new Label("Here are your current clubs:");
        clubBox.getChildren().add(clubLabel);
        List<Club> allClubs = getClubs();
        if(allClubs != null) {
            leaderClubs = new ArrayList<>();
            for (Club club : allClubs) {
                if (club.getLeaderName().equalsIgnoreCase(leaderName)) {
                    leaderClubs.add(club);
                    HBox newBox = createIndividualClubBox(club);
                    clubBox.getChildren().add(newBox);
                }
            }
        } else {
            Label noClubs = new Label("There are no clubs available in the system!");
            clubBox.getChildren().add(noClubs);
        }
        return clubBox;
    }

    public static HBox createIndividualClubBox(Club club) {
        HBox individualBox = new HBox();
        Label clubName = new Label("Club Name: " + club.getClubName() + "|");
        Label clubType = new Label("Club Type: " + club.getClubType());
        individualBox.getChildren().addAll(clubName, clubType);
        return individualBox;
    }

}
