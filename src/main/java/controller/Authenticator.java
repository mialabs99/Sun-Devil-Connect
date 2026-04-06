/**
 * Created by: Mia Laboranti
 * For: CSE460 at ASU
 * Date: March 31st, 2026
 */

package controller;

import model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Authenticator {

    private static List<User> users;

    public static void authenticateSignUp(String asuriteID, String password, String passwordVerification,
        String firstName, String lastName, String role) {
        if(!password.equals(passwordVerification)) {
            System.out.println("Password verification unsuccessful.");
            ViewManager.displayInvalidPasswordVerification();
            return;
        }
        try {
            saveUser(firstName, lastName, asuriteID, password, role);
            ViewManager.displayStudentView(firstName);
        } catch (Exception e) {
            System.out.println("Could not save new user to the file: " + e.getMessage());
        }
    }

    public static void authenticateSignIn(String asuriteID, String password) {
        try {
            loadUsers();
            for(User user: users) {
                if(user.getasuriteID().equals(asuriteID)) {
                    System.out.println("Found valid ASURITE ID. Validating password...");
                    if(user.getPassword().equals(password)) {
                        System.out.println("Password matches. Logging user into the system.");
                        if(user.getUserRole() == User.role.student) {
                            System.out.println("Switching screen to student view");
                            ViewManager.displayStudentView(user.getFirstName());
                        } else if(user.getUserRole() == User.role.leader) {
                            System.out.println("Switching screen to leader view");
                            ViewManager.displayLeaderView(user.getFirstName());
                        } else if(user.getUserRole() == User.role.admin) {
                            System.out.println("Switching screen to admin view");
                            ViewManager.displayAdminView(user.getFirstName());
                        }
                        return;
                    } else {
                        System.out.println("Password does not match the given ID.");
                        ViewManager.displayInvalidPassword();
                        return;
                    }
                }
            }
            System.out.println("Could not find a user with that ASURITE ID.");
            ViewManager.displayInvalidAsuriteID();
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
