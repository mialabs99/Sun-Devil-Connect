package view;

import controller.ViewManager;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class AdminViewUI {

    public static Parent adminView(String firstName) {
        Label adminViewLabel = new Label("Welcome " + firstName + "!");
        Label placeHolderLabel = new Label("*Admin functionality will go here*");
        Button exit = new Button("Exit");
        exit.setOnAction(e -> ViewManager.displayWelcomePage());
        VBox adminViewBox = new VBox();
        adminViewBox.getChildren().addAll(adminViewLabel, placeHolderLabel, exit);
        adminViewBox.setSpacing(10);
        adminViewBox.setAlignment(Pos.CENTER);
        return adminViewBox;
    }
}
