/**
 * Created by: Mia Laboranti
 * For: CSE460 at ASU
 * Date: April 6th, 2026
 */

package model;

import java.util.ArrayList;
import java.util.List;

import static model.EventFactory.createEvent;

public class Leader extends User{

    private static List<Club> currentClubs;

    public Leader() {
        super();
    }

    public Leader(String asuriteID, String password, String firstName, String lastName) {
        super(asuriteID, password, firstName, lastName, role.leader);
        currentClubs = new ArrayList<>();
    }

    public static void createNewEvent(String time, String date, String location) {
        Event newEvent = createEvent(time, date, location);
    }

    public static void addClub(Club club) {
        currentClubs.add(club);
    }

    public static void manageEvent(Event event, String modification) {

    }

    public static void approveNewMembers(Student student) {

    }

    public static void postUpdate(String update) {

    }
}
