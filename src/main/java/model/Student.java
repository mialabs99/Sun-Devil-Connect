/**
 * Created by: Mia Laboranti
 * For: CSE460 at ASU
 * Date: April 6th, 2026
 */

package model;

import java.util.ArrayList;
import java.util.List;

public class Student extends User{

    private List<Club> clubsJoined = new ArrayList<>();

    public Student() {
        super();
    }

    public Student(String asuriteID, String password, String firstName, String lastName) {
        super(asuriteID, password, firstName, lastName);
        clubsJoined = new ArrayList<>();
    }

    public void joinClub(Club club) {
        if(!clubsJoined.contains(club)) {
            clubsJoined.add(club);
        }
    }

    public static void browseClubs() {

    }

    public static void registerForEvent(Event event) {

    }

    public List<Club> getClubsJoined() {
        return new ArrayList<Club>(clubsJoined);
    }
}
