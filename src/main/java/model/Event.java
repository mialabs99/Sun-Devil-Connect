/**
 * Created by: Mia Laboranti
 * For: CSE460 at ASU
 * Date: April 6th, 2026
 */

package model;

import controller.EventObserver;

import java.util.ArrayList;
import java.util.List;

public class Event {
    private String eventName;
    private String time;
    private String date;
    private List<Student> studentsAttending;
    private String location;
    private List<EventObserver> eventObservers;

    public Event() {
        studentsAttending = new ArrayList<>();
        eventObservers = new ArrayList<>();
    }

    public Event(String eventName, String time, String date, String location) {
        this.eventName = eventName;
        this.time = time;
        this.date = date;
        this.location = location;
        studentsAttending = new ArrayList<>();
        eventObservers = new ArrayList<>();
    }

    public void addStudentAttending(Student student) {
        studentsAttending.add(student);
    }

    public void removeStudentAttending(Student student) {
        studentsAttending.remove(student);
    }

    //Getters
    public List<Student> getStudentsAttending() { return new ArrayList<>(studentsAttending); }
    public String getTime() { return time; }
    public String getDate() { return date; }
    public String getLocation() { return location; }
    public String getEventName() { return eventName; }
}
