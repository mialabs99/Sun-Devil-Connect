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

import java.util.Objects;

import static controller.Authenticator.authenticateSignIn;
import static view.SignUpUI.displaySignUpPage;
import static view.WelcomePageUI.displayWelcomePage;

//UI for users to sign in to a pre-registered account
public class SignInUI {
    private static TextField asuriteIDField;
    private static TextField passwordField;

    //UI display
    public static void displaySignInPage(Stage stage) {
        Label signInLabel = new Label("Please enter your credentials below:");
        HBox asuriteIDHBox = createHBoxLine("ASURITE ID: ");
        HBox passwordHBox = createHBoxLine("Password: ");
        Button enter = new Button("Enter");
        enter.setOnAction(e -> authenticateSignIn(stage, asuriteIDField.getText(), passwordField.getText()));
        Button back = new Button("Back");
        back.setOnAction(e -> displayWelcomePage(stage));
        HBox buttonBox = new HBox();
        buttonBox.getChildren().addAll(back, enter);
        buttonBox.setSpacing(10);
        buttonBox.setAlignment(Pos.CENTER);
        VBox signInBox = new VBox();
        signInBox.getChildren().addAll(signInLabel, asuriteIDHBox, passwordHBox, buttonBox);
        signInBox.setSpacing(10);
        signInBox.setAlignment(Pos.CENTER);
        Scene signInScene = new Scene(signInBox, 500, 500);
        signInScene.getStylesheets().add(
                Objects.requireNonNull(SignInUI.class.getResource("/style.css")).toExternalForm()
        );
        stage.setTitle("Sign In");
        stage.setScene(signInScene);
        stage.show();
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

    public static void invalidAsuriteID(Stage stage) {
        Label invalidAsuriteID = new Label("The system could not find a user with that ASURITE ID.");
        Label options = new Label("Either try a different ID or sign up for a free account.");
        VBox invalidAsuriteIDBox = new VBox();
        Button differentID = new Button("Different ID");
        differentID.setOnAction(e -> displaySignInPage(stage));
        Button signUp = new Button("Sign Up");
        signUp.setOnAction(e -> displaySignUpPage(stage));
        HBox buttonBox = new HBox();
        buttonBox.getChildren().addAll(differentID, signUp);
        buttonBox.setSpacing(10);
        buttonBox.setAlignment(Pos.CENTER);
        invalidAsuriteIDBox.getChildren().addAll(invalidAsuriteID, options, buttonBox);
        invalidAsuriteIDBox.setSpacing(10);
        invalidAsuriteIDBox.setAlignment(Pos.CENTER);
        Scene invalidAsuriteScene = new Scene(invalidAsuriteIDBox, 300, 400);
        invalidAsuriteScene.getStylesheets().add(
                Objects.requireNonNull(SignInUI.class.getResource("/style.css")).toExternalForm()
        );
        stage.setTitle("Invalid Password Verification");
        stage.setScene(invalidAsuriteScene);
        stage.show();
    }

    public static void invalidPassword(Stage stage) {
        Label invalidPassword = new Label("The password you entered does not match the one in our files.");
        VBox invalidPasswordBox = new VBox();
        Button tryAgain = new Button("Try Again");
        tryAgain.setOnAction(e -> displaySignInPage(stage));
        invalidPasswordBox.getChildren().addAll(invalidPassword, tryAgain);
        invalidPasswordBox.setSpacing(10);
        invalidPasswordBox.setAlignment(Pos.CENTER);
        Scene invalidPasswordScene = new Scene(invalidPasswordBox, 300, 400);
        invalidPasswordScene.getStylesheets().add(
                Objects.requireNonNull(SignInUI.class.getResource("/style.css")).toExternalForm()
        );
        stage.setTitle("Invalid Password");
        stage.setScene(invalidPasswordScene);
        stage.show();
    }

}
