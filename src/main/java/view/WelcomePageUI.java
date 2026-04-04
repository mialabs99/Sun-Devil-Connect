/**
 * Created by: Mia Laboranti
 * For: CSE460 at ASU
 * Date: March 31st, 2026
 */

package view;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Objects;

import static view.SignInUI.displaySignInPage;
import static view.SignUpUI.displaySignUpPage;

public class WelcomePageUI extends Application {
    private static final int SIGN_IN = 0;
    private static final int SIGN_UP = 1;

    static void main(String[] args) {
        launch(args);
    }

    //Displays the initial welcome page for the user
    public static void displayWelcomePage(Stage stage) {
        Label welcomeLabel = new Label("Welcome to Sun Devil Connect!");
        Label chooseLabel = new Label("Please choose one of the following options:");
        Button signIn = new Button("Sign In");
        signIn.setOnAction(e -> navigateToSection(stage, SIGN_IN));
        Button signUp = new Button("Sign Up");
        signUp.setOnAction(e -> navigateToSection(stage, SIGN_UP));
        VBox welcomeBox = new VBox();
        welcomeBox.getChildren().addAll(welcomeLabel, chooseLabel, signIn, signUp);
        welcomeBox.setSpacing(10);
        welcomeBox.setAlignment(Pos.CENTER);
        Scene welcomeScene = new Scene(welcomeBox, 400, 400);
        welcomeScene.getStylesheets().add(
                Objects.requireNonNull(WelcomePageUI.class.getResource("/style.css")).toExternalForm()
        );
        stage.setTitle("Welcome");
        stage.setScene(welcomeScene);
        stage.show();
    }

    //Sends user selection to the controller for further implementation
    public static void navigateToSection(Stage stage, int choice) {
        if(choice == SIGN_IN) {
            displaySignInPage(stage);
        } else if(choice == SIGN_UP) {
            displaySignUpPage(stage);
        }
    }

    @Override
    public void start(Stage stage) {
        displayWelcomePage(stage);
    }

}
