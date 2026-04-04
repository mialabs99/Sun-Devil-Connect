/**
 * Created by: Mia Laboranti
 * For: CSE460 at ASU
 * Date: April 3rd, 2026
 */

package view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Objects;

import static view.WelcomePageUI.displayWelcomePage;

//UI for student users
public class StudentViewUI {

    public static void displayStudentView(Stage stage, String firstName) {
        Label studentViewLabel = new Label("Welcome " + firstName + "!");
        Label placeHolderLabel = new Label("*Events and clubs will go here*");
        Button exit = new Button("Exit");
        exit.setOnAction(e -> displayWelcomePage(stage));
        VBox studentViewBox = new VBox();
        studentViewBox.getChildren().addAll(studentViewLabel, placeHolderLabel, exit);
        studentViewBox.setSpacing(10);
        studentViewBox.setAlignment(Pos.CENTER);
        Scene studentViewScene = new Scene(studentViewBox, 400, 400);
        studentViewScene.getStylesheets().add(
                Objects.requireNonNull(StudentViewUI.class.getResource("/style.css")).toExternalForm()
        );
        stage.setTitle("Welcome");
        stage.setScene(studentViewScene);
        stage.show();
    }
}
