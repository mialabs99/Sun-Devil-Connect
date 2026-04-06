/**
 * Created by: Mia Laboranti
 * For: CSE460 at ASU
 * Date: April 3rd, 2026
 */

package view;

import controller.ViewManager;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.util.Objects;

//UI for student users
public class StudentViewUI {

    public static Parent studentView(String firstName) {
        Label studentViewLabel = new Label("Welcome " + firstName + "!");
        Label placeHolderLabel = new Label("*Events and clubs will go here*");
        Button exit = new Button("Exit");
        exit.setOnAction(e -> ViewManager.displayWelcomePage());
        VBox studentViewBox = new VBox();
        studentViewBox.getChildren().addAll(studentViewLabel, placeHolderLabel, exit);
        studentViewBox.setSpacing(10);
        studentViewBox.setAlignment(Pos.CENTER);
        return studentViewBox;
    }
}
