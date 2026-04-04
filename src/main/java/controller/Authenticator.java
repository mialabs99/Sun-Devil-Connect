/**
 * Created by: Mia Laboranti
 * For: CSE460 at ASU
 * Date: March 31st, 2026
 */

package controller;

import javafx.stage.Stage;
import model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static view.LeaderViewUI.displayLeaderView;
import static view.SignInUI.invalidAsuriteID;
import static view.SignInUI.invalidPassword;
import static view.SignUpUI.invalidPasswordVerification;
import static view.StudentViewUI.displayStudentView;

public class Authenticator {

    private static List<User> users;

    public static void authenticateSignUp(Stage stage, String asuriteID, String password, String passwordVerification,
        String firstName, String lastName, String role) {
        if(!password.equals(passwordVerification)) {
            System.out.println("Password verification unsuccessful.");
            invalidPasswordVerification(stage);
            return;
        }
        try {
            saveUser(firstName, lastName, asuriteID, password, role);
            displayStudentView(stage, firstName);
        } catch (Exception e) {
            System.out.println("Could not save new user to the file: " + e.getMessage());
        }
    }

    public static void authenticateSignIn(Stage stage, String asuriteID, String password) {
        try {
            loadUsers();
            for(User user: users) {
                if(user.getasuriteID().equals(asuriteID)) {
                    System.out.println("Found valid ASURITE ID. Validating password...");
                    if(user.getPassword().equals(password)) {
                        System.out.println("Password matches. Logging user into the system.");
                        if(user.getUserRole() == User.role.student) {
                            displayStudentView(stage, user.getFirstName());
                        } else if(user.getUserRole() == User.role.leader) {
                            displayLeaderView(stage, user.getFirstName());
                        } else if(user.getUserRole() == User.role.admin) {

                        }
                    } else {
                        System.out.println("Password does not match the given ID.");
                        invalidPassword(stage);
                    }
                } else {
                    System.out.println("Could not find a user with that ASURITE ID.");
                    invalidAsuriteID(stage);
                }
            }
        } catch (Exception e) {
            System.out.println("Could not load users from the file: " + e.getMessage());
        }
    }

    public static void saveUser(String firstName, String lastName, String asuriteID, String password, String role) throws Exception {
        User.role userRole = null;
        if(role.equals("Student")) {
            userRole = User.role.student;
        } else if(role.equals("Leader")) {
            userRole = User.role.leader;
        } else if(role.equals("Admin")) {
            userRole = User.role.admin;
        }
        User newUser = new User(asuriteID, password, firstName, lastName, userRole);
        File file = new File("users.json");
        ObjectMapper mapper = new ObjectMapper();
        if(file.exists()) {
            users = mapper.readValue(file, new TypeReference<>() {
            });
        } else {
            users = new ArrayList<>();
        }
        users.add(newUser);
        mapper.writeValue(file, users);
    }

    public static void loadUsers() throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        users = mapper.readValue(new File("users.json"), new TypeReference<>() {
        });
    }

}
