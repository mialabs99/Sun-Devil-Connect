package view;

import controller.ViewManager;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import model.Club;
import model.Student;

public class SignUpForClubUI {

    public static VBox signUpForClub(Student student, Club club) {
        VBox signUpBox = new VBox();
        Label signUpSuccess = new Label("Your application has been submitted! Please wait for leader approval.");
        Button backButton = new Button("Back");
        backButton.setOnAction(e -> ViewManager.displayClubInfoPage(student, club));
        signUpBox.getChildren().addAll(signUpSuccess, backButton);
        signUpBox.setSpacing(10);
        signUpBox.setAlignment(Pos.CENTER);
        signUpBox.setFillWidth(false);
        return signUpBox;
    }
}
