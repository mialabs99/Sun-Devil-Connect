package view;

import controller.ViewManager;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Club;
import model.Student;

import java.util.ArrayList;
import java.util.List;

import static controller.SaveLoadData.getClubs;

public class BrowseClubsUI {
    private static List<Club> allClubs;
    private static List<Club> clubsNotJoined;

    public static VBox browseClubs(Student student) {
        clubsNotJoined = new ArrayList<>();
        VBox browseClubsBox = new VBox();
        allClubs = getClubs();
        if(allClubs != null) {
            for (Club club : allClubs) {
                if (!student.getClubsJoined().contains(club)) {
                    clubsNotJoined.add(club);
                    Label clubName = new Label("Club Name: " + club.getClubName() + " |");
                    Label clubType = new Label("Club Type: " + club.getClubType() + " |");
                    Label clubLeader = new Label("Created By: " + club.getLeaderName());
                    Button viewInfo = new Button("View Club Info");
                    viewInfo.setOnAction(e -> ViewManager.displayClubInfoPage(student, club));
                    HBox clubBox = new HBox();
                    clubBox.setSpacing(10);
                    clubBox.setAlignment(Pos.CENTER);
                    clubBox.getChildren().addAll(clubName, clubType, clubLeader, viewInfo);
                    browseClubsBox.getChildren().add(clubBox);
                }
            }
        }
        Button backButton = new Button("Back");
        backButton.setOnAction(e -> ViewManager.displayStudentView(student));
        browseClubsBox.getChildren().add(backButton);
        browseClubsBox.setSpacing(10);
        browseClubsBox.setAlignment(Pos.CENTER);
        browseClubsBox.setFillWidth(false);
        return browseClubsBox;
    }
}
