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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import static controller.Authenticator.authenticateSignUp;

//UI for users to sign up for an account
public class SignUpUI {
    private static TextField asuriteIDField;
    private static TextField passwordField;
    private static TextField passwordVerificationField;
    private static TextField firstNameField;
    private static TextField lastNameField;

    //UI display
    public static Parent signUpPage() {
        Label signUpLabel = new Label("Please fill out the following form to sign up:");
        HBox firstNameHBox = createHBoxLine("First name: ");
        HBox lastNameHBox = createHBoxLine("Last name: ");
        HBox asuriteIDHBox = createHBoxLine("ASURITE ID: ");
        HBox passwordHBox = createHBoxLine("Password: ");
        HBox passwordVerificationHBox = createHBoxLine("Verify Password: ");
        HBox roleHBox = new HBox();
        Label roleLabel = new Label("Choose your role: ");
        ComboBox<String> dropdown = new ComboBox<>();
        dropdown.getItems().add("Student");
        dropdown.getItems().add("Leader");
        dropdown.getItems().add("Admin");
        roleHBox.getChildren().addAll(roleLabel, dropdown);
        Button enter = new Button("Enter");
        enter.setOnAction(e -> authenticateSignUp(asuriteIDField.getText(), passwordField.getText(),
                passwordVerificationField.getText(), firstNameField.getText(), lastNameField.getText(), dropdown.getValue()));
        Button back = new Button("Back");
        HBox buttonBox = new HBox();
        buttonBox.getChildren().addAll(back, enter);
        back.setOnAction(e -> ViewManager.displayWelcomePage());
        buttonBox.setSpacing(10);
        VBox signUpBox = new VBox();
        signUpBox.setAlignment(Pos.CENTER);
        signUpBox.getChildren().addAll(signUpLabel, firstNameHBox, lastNameHBox, asuriteIDHBox, passwordHBox,
                passwordVerificationHBox, roleHBox, buttonBox);
        signUpBox.setSpacing(10);
        signUpBox.setFillWidth(false);
        return signUpBox;
    }

    //Method for creating HBoxes distinct to the SignUpUI
    //Should change later to minimize functions
    public static HBox createHBoxLine(String labelText) {
        HBox hbox = new HBox();
        Label label = new Label(labelText);
        hbox.getChildren().add(label);
        switch (labelText) {
            case "ASURITE ID: " -> {
                asuriteIDField = new TextField();
                hbox.getChildren().add(asuriteIDField);
            }
            case "Password: " -> {
                passwordField = new TextField();
                hbox.getChildren().add(passwordField);
            }
            case "Verify Password: " -> {
                passwordVerificationField = new TextField();
                hbox.getChildren().add(passwordVerificationField);
            }
            case "First name: " -> {
                firstNameField = new TextField();
                hbox.getChildren().add(firstNameField);
            }
            case "Last name: " -> {
                lastNameField = new TextField();
                hbox.getChildren().add(lastNameField);
            }
            default -> {
                TextField textField = new TextField();
                hbox.getChildren().add(textField);
            }
        }
        return hbox;
    }

    public static Parent invalidPasswordVerification() {
        Label invalidPasswordVerification = new Label("The passwords you entered do not match. Please try again.");
        VBox invalidVerificationBox = new VBox();
        Button okay = new Button("Okay");
        okay.setOnAction(e -> ViewManager.displaySignUpPage());
        invalidVerificationBox.getChildren().addAll(invalidPasswordVerification, okay);
        invalidVerificationBox.setSpacing(10);
        invalidVerificationBox.setAlignment(Pos.CENTER);
        return invalidVerificationBox;
    }

}
