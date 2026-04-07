package controller;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import view.*;

import java.util.Objects;

public class ViewManager extends Application {

    private static Scene scene;

    static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        viewInitialize(stage);
    }

    public static void viewInitialize(Stage stage) {
        scene = new Scene(new VBox(), 800, 600);
        scene.getStylesheets().add(
                Objects.requireNonNull(ViewManager.class.getResource("/style.css")).toExternalForm()
        );
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();
        displayWelcomePage();
    }

    public static void switchScreen(Parent root) {
        System.out.println("Switching screen...");
        scene.setRoot(root);
    }

    public static void displayWelcomePage() {
        System.out.println("Displaying welcome page...");
        switchScreen(WelcomePageUI.welcomePage());
    }

    public static void displaySignInPage() {
        System.out.println("Displaying sign in page...");
        switchScreen(SignInUI.signInPage());
    }

    public static void displaySignUpPage() {
        System.out.println("Displaying sign up page");
        switchScreen(SignUpUI.signUpPage());
    }

    public static void displayStudentView(String firstName) {
        System.out.println("Displaying student view...");
        switchScreen(StudentViewUI.studentView(firstName));
    }

    public static void displayLeaderView(String firstName) {
        System.out.println("Displaying leader view...");
        switchScreen(LeaderViewUI.leaderView(firstName));
    }

    public static void displayAdminView(String firstName) {
        System.out.println("Displaying admin view...");
        switchScreen(AdminViewUI.adminView(firstName));
    }

    public static void displayInvalidPasswordVerification() {
        System.out.println("Displaying invalid password verification...");
        switchScreen(SignUpUI.invalidPasswordVerification());
    }

    public static void displayInvalidPassword() {
        System.out.println("Displaying invalid password...");
        switchScreen(SignInUI.invalidPassword());
    }

    public static void displayInvalidAsuriteID() {
        System.out.println("Displaying invalid asurite ID...");
        switchScreen(SignInUI.invalidAsuriteID());
    }
}
