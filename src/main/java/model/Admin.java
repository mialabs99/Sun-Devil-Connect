/**
 * Created by: Mia Laboranti
 * For: CSE460 at ASU
 * Date: April 6th, 2026
 */

package model;

public class Admin extends User{

    public Admin() {
        super();
    }

    public Admin(String asuriteID, String password, String firstName, String lastName) {
        super(asuriteID, password, firstName, lastName);
    }
}
