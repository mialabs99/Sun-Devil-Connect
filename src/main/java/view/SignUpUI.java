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

import static controller.Authenticator.authenticate;
import static view.WelcomePageUI.displayWelcomePage;

//UI for users to sign up for an account
public class SignUpUI {
    private static TextField asuriteIDField;
    private static TextField passwordField;
    private static TextField passwordVerificationField;

    public static void displaySignUpPage() {
        Stage signUpStage = new Stage();
        Label signUpLabel = new Label("Please fill out the following form to sign up:");
        HBox firstNameHBox = createHBoxLine("First name: ");
        HBox lastNameHBox = createHBoxLine("Last name: ");
        HBox asuriteIDHBox = createHBoxLine("ASURITE ID: ");
        HBox passwordHBox = createHBoxLine("Password: ");
        HBox passwordVerificationHBox = createHBoxLine("Verify Password: ");
        Button enter = new Button("Enter");
        enter.setOnAction(e -> authenticate(asuriteIDField.getText(), passwordField.getText(),
                passwordVerificationField.getText()));
        Button back = new Button("Back");
        back.setOnAction(e -> displayWelcomePage(signUpStage));
        VBox signUpBox = new VBox();
        signUpBox.getChildren().addAll(signUpLabel, firstNameHBox, lastNameHBox, asuriteIDHBox, passwordHBox,
                passwordVerificationHBox);
        signUpBox.setSpacing(10);
        signUpBox.setAlignment(Pos.CENTER);
        Scene signUpScene = new Scene(signUpBox, 400, 400);
        signUpStage.setTitle("Sign Up");
        signUpStage.setScene(signUpScene);
        signUpStage.show();
    }

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
        } else if(labelText.equals("Verify Password: ")) {
            passwordVerificationField = new TextField();
            hbox.getChildren().add(passwordVerificationField);
        } else {
            TextField textField = new TextField();
            hbox.getChildren().add(textField);
        }
        return hbox;
    }
}
