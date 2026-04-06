/**
 * Created by: Mia Laboranti
 * For: CSE460 at ASU
 * Date: March 31st, 2026
 */

package view;

import controller.ViewManager;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class WelcomePageUI{
    private static final int SIGN_IN = 0;
    private static final int SIGN_UP = 1;

    //Displays the initial welcome page for the user
    public static Parent welcomePage() {
        Label welcomeLabel = new Label("Welcome to Sun Devil Connect!");
        Label chooseLabel = new Label("Please choose one of the following options:");
        Button signIn = new Button("Sign In");
        signIn.setOnAction(e -> {
            System.out.println("Sign in button pressed");
            navigateToSection(SIGN_IN);
        });
        Button signUp = new Button("Sign Up");
        signUp.setOnAction(e -> {
            System.out.println("Sign up button pressed");
            navigateToSection(SIGN_UP);
        });
        VBox welcomeBox = new VBox();
        welcomeBox.getChildren().addAll(welcomeLabel, chooseLabel, signIn, signUp);
        welcomeBox.setSpacing(10);
        welcomeBox.setAlignment(Pos.CENTER);
        return welcomeBox;
    }

    //Sends user selection to the controller for further implementation
    public static void navigateToSection(int choice) {
        if(choice == SIGN_IN) {
            ViewManager.displaySignInPage();
        } else if(choice == SIGN_UP) {
            ViewManager.displaySignUpPage();
        }
    }

}
