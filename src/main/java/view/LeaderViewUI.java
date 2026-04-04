package view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Objects;

import static view.WelcomePageUI.displayWelcomePage;

public class LeaderViewUI {

    public static void displayLeaderView(Stage stage, String firstName) {
        Label leaderViewLabel = new Label("Welcome " + firstName + "!");
        Label placeHolderLabel = new Label("*Leader functionality will go here*");
        Button exit = new Button("Exit");
        exit.setOnAction(e -> displayWelcomePage(stage));
        VBox leaderViewBox = new VBox();
        leaderViewBox.getChildren().addAll(leaderViewLabel, placeHolderLabel, exit);
        leaderViewBox.setSpacing(10);
        leaderViewBox.setAlignment(Pos.CENTER);
        Scene leaderViewScene = new Scene(leaderViewBox, 500, 500);
        leaderViewScene.getStylesheets().add(
                Objects.requireNonNull(LeaderViewUI.class.getResource("/style.css")).toExternalForm()
        );
        stage.setTitle("Welcome");
        stage.setScene(leaderViewScene);
        stage.show();
    }
}
