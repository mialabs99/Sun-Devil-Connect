package controller;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Admin;
import model.Club;
import model.Leader;
import model.Student;
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

    public static void displayStudentView(Student student) {
        System.out.println("Displaying student view...");
        switchScreen(StudentViewUI.studentView(student));
    }

    public static void displayLeaderView(Leader leader) {
        System.out.println("Displaying leader view...");
        switchScreen(LeaderViewUI.leaderView(leader));
    }

    public static void displayAdminView(Admin admin) {
        System.out.println("Displaying admin view...");
        switchScreen(AdminViewUI.adminView(admin));
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

    public static void displayCreateClubPage(Leader leader) {
        System.out.println("Displaying page to create a club...");
        switchScreen(ClubCreationUI.clubCreation(leader));
    }

    public static void displayBrowseClubPage(Student student) {
        System.out.println("Displaying page to browse clubs...");
        switchScreen(BrowseClubsUI.browseClubs(student));
    }

    public static void displaySignUpForClubPage(Student student, Club club) {
        System.out.println("Displaying page to sign up for a club...");
        switchScreen(SignUpForClubUI.signUpForClub(student, club));
    }

    public static void displayClubInfoPage(Club club) {
        System.out.println("Displaying club info page...");
        switchScreen();
    }
}
