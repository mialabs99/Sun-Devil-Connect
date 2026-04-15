package view;

import controller.ViewManager;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import model.Club;
import model.Student;

import static controller.SaveLoadData.saveStudentApplications;

public class SignUpForClubUI {

    public static VBox signUpForClub(Student student, Club club) {
        VBox signUpBox = new VBox();
        Label signUpSuccess = new Label("Your application has been submitted! Please wait for leader approval.");
        Label signUpFailure = new Label("There was an issue processing your request. Please try again later.");
        Button backButton = new Button("Back");
        backButton.setOnAction(e -> ViewManager.displayClubInfoPage(student, club));
        try {
            saveStudentApplications(club, student);
            signUpBox.getChildren().add(signUpSuccess);
        } catch (Exception e) {
            System.out.println("Could not accept student application: " + e.getMessage());
            signUpBox.getChildren().add(signUpFailure);
        }
        signUpBox.getChildren().add(backButton);
        signUpBox.setSpacing(10);
        signUpBox.setAlignment(Pos.CENTER);
        signUpBox.setFillWidth(false);
        return signUpBox;
    }
}
