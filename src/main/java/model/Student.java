/**
 * Created by: Mia Laboranti
 * For: CSE460 at ASU
 * Date: April 6th, 2026
 */

package model;

import java.util.ArrayList;
import java.util.List;

public class Student extends User{

    private static List<Club> clubsJoined;

    public Student() {
        super();
    }

    public Student(String asuriteID, String password, String firstName, String lastName) {
        super(asuriteID, password, firstName, lastName, role.student);
        clubsJoined = new ArrayList<>();
    }

    public static void joinClub() {

    }

    public static void browseClubs() {

    }

    public static void registerForEvent(Event event) {

    }
}
