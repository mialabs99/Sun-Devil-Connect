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
        scene.setRoot(root);
    }

    public static void displayWelcomePage() {
        switchScreen(WelcomePageUI.welcomePage());
    }

    public static void displaySignInPage() {
        switchScreen(SignInUI.signInPage());
    }

    public static void displaySignUpPage() {
        switchScreen(SignUpUI.signUpPage());
    }

    public static void displayStudentView(String firstName) {
        switchScreen(StudentViewUI.studentView(firstName));
    }

    public static void displayLeaderView(String firstName) {
        switchScreen(LeaderViewUI.leaderView(firstName));
    }

    public static void displayAdminView(String firstName) {
        switchScreen(AdminViewUI.adminView(firstName));
    }

    public static void displayInvalidPasswordVerification() {
        switchScreen(SignUpUI.invalidPasswordVerification());
    }

    public static void displayInvalidPassword() {
        switchScreen(SignInUI.invalidPassword());
    }

    public static void displayInvalidAsuriteID() {
        switchScreen(SignInUI.invalidAsuriteID());
    }
}
