/**
 * Created by: Mia Laboranti
 * For: CSE460 at ASU
 * Date: March 31st, 2026
 */

package view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import static controller.Authenticator.authenticateSignIn;
import static view.WelcomePageUI.displayWelcomePage;

//UI for users to sign in to a pre-registered account
public class SignInUI {
    private static TextField asuriteIDField;
    private static TextField passwordField;

    //UI display
    public static void displaySignInPage() {
        Stage signInStage = new Stage();
        Label signInLabel = new Label("Please enter your credentials below:");
        HBox asuriteIDHBox = createHBoxLine("ASURITE ID: ");
        HBox passwordHBox = createHBoxLine("Password: ");
        Button enter = new Button("Enter");
        enter.setOnAction(e -> authenticateSignIn(asuriteIDField.getText(), passwordField.getText()));
        Button back = new Button("Back");
        back.setOnAction(e -> displayWelcomePage(signInStage));
        HBox buttonBox = new HBox();
        buttonBox.getChildren().addAll(back, enter);
        buttonBox.setSpacing(10);
        buttonBox.setAlignment(Pos.CENTER);
        VBox signInBox = new VBox();
        signInBox.getChildren().addAll(signInLabel, asuriteIDHBox, passwordHBox, buttonBox);
        signInBox.setSpacing(10);
        signInBox.setAlignment(Pos.CENTER);
        Scene signInScene = new Scene(signInBox, 400, 400);
        signInStage.setTitle("Sign In");
        signInStage.setScene(signInScene);
        signInStage.show();
    }

    //Method for creating HBoxes distinct to the SignInUI
    //Should change later to minimize functions
    public static HBox createHBoxLine(String labelText) {
        HBox hbox = new HBox();
        Label label = new Label(labelText);
        hbox.getChildren().add(label);
        if(labelText.equals("ASURITE ID: ")) {
            asuriteIDField = new TextField();
            hbox.getChildren().add(asuriteIDField);
        } else if(labelText.equals("Password: ")) {
            passwordField = new TextField();
            hbox.getChildren().add(passwordField);
        } else {
            TextField textField = new TextField();
            hbox.getChildren().add(textField);
        }
        return hbox;
    }

}
