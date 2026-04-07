/**
 * Created by: Mia Laboranti
 * For: CSE460 at ASU
 * Date: April 7th, 2026
 */

package model;

import controller.ClubObserver;

import java.util.ArrayList;
import java.util.List;

public class Club {

    private static List<Student> clubMembers;
    private static List<Event> upcomingEvents;
    private String leaderName;
    private String clubName;
    private static List<ClubObserver> clubObservers;

    public Club(String leaderName, String clubName) {
        this.leaderName = leaderName;
        this.clubName = clubName;
        clubMembers = new ArrayList<>();
        upcomingEvents = new ArrayList<>();
        clubObservers = new ArrayList<>();
    }

    public static void addClubMember(Student student) {
        clubMembers.add(student);
    }

    public static void removeClubMember(Student student) {
        clubMembers.remove(student);
    }

    public static void addUpcomingEvent(Event event) {
        upcomingEvents.add(event);
    }

    public static void removeUpcomingEvent(Event event) {
        upcomingEvents.remove(event);
    }
}
