package view;

import controller.ViewManager;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class LeaderViewUI {

    public static Parent leaderView(String firstName) {
        Label leaderViewLabel = new Label("Welcome " + firstName + "!");
        Label placeHolderLabel = new Label("*Leader functionality will go here*");
        Button exit = new Button("Exit");
        exit.setOnAction(e -> ViewManager.displayWelcomePage());
        VBox leaderViewBox = new VBox();
        leaderViewBox.getChildren().addAll(leaderViewLabel, placeHolderLabel, exit);
        leaderViewBox.setSpacing(10);
        leaderViewBox.setAlignment(Pos.CENTER);
        return leaderViewBox;
    }
}
