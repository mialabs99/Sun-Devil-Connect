package view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Objects;

import static view.WelcomePageUI.displayWelcomePage;

public class AdminViewUI {

    public static void displayAdminView(Stage stage, String firstName) {
        Label adminViewLabel = new Label("Welcome " + firstName + "!");
        Label placeHolderLabel = new Label("*Events and clubs will go here*");
        Button exit = new Button("Exit");
        exit.setOnAction(e -> displayWelcomePage(stage));
        VBox adminViewBox = new VBox();
        adminViewBox.getChildren().addAll(adminViewLabel, placeHolderLabel, exit);
        adminViewBox.setSpacing(10);
        adminViewBox.setAlignment(Pos.CENTER);
        Scene adminViewScene = new Scene(adminViewBox, 400, 400);
        adminViewScene.getStylesheets().add(
                Objects.requireNonNull(AdminViewUI.class.getResource("/style.css")).toExternalForm()
        );
        stage.setTitle("Welcome");
        stage.setScene(adminViewScene);
        stage.show();
    }
}
