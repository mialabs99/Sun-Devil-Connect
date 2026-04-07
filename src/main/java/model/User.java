/**
 * Created by: Mia Laboranti
 * For: CSE460 at ASU
 * Date: April 3rd, 2026
 */

package model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "userRole"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Student.class, name = "student"),
        @JsonSubTypes.Type(value = Leader.class, name = "leader"),
        @JsonSubTypes.Type(value = Admin.class, name = "admin")
})

public abstract class User {
    private String asuriteID;
    private String password;
    private String firstName;
    private String lastName;
    private role userRole;

    public enum role {
        student, leader, admin
    }

    public User() {

    }

    public User(String asuriteID, String password, String firstName, String lastName, role userRole) {
        this.asuriteID = asuriteID;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userRole = userRole;
    }

    //Getters for the User class
    public String getasuriteID() { return asuriteID; }
    public String getPassword() { return password; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public role getUserRole() { return userRole; }
}
