package controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Club;
import model.Event;
import model.Student;
import model.StudentApplication;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static model.ClubFactory.createClub;

public class SaveLoadData {

    private static List<Event> events;
    private static List<Club> clubs;
    private static List<StudentApplication> studentApplications;

    public static void saveEvent(Event event) throws Exception {
        File file = new File("events.json");
        ObjectMapper mapper = new ObjectMapper();
        if(file.exists()) {
            events = mapper.readValue(file, new TypeReference<>() {});
        } else {
            events = new ArrayList<>();
        }
        events.add(event);
        mapper.writeValue(file, events);
    }

    public static void loadEvents() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        events = mapper.readValue(new File("events.json"), new TypeReference<>(){});
    }

    public static void saveClub(String clubName, String clubType, String leaderName) throws Exception {
        Club club = createClub(leaderName, clubName, clubType);
        File file = new File("clubs.json");
        ObjectMapper mapper = new ObjectMapper();
        if(file.exists()) {
            clubs = mapper.readValue(file, new TypeReference<>(){});
        } else {
            clubs = new ArrayList<>();
        }
        clubs.add(club);
        mapper.writeValue(file, clubs);
    }

    public static void saveStudentApplications(Club club, Student student) throws Exception {
        StudentApplication studentApplication = new StudentApplication(student, club);
        File file = new File("studentApplications.json");
        ObjectMapper mapper = new ObjectMapper();
        if(file.exists()) {
            studentApplications = mapper.readValue(file, new TypeReference<>(){});
        } else {
            studentApplications = new ArrayList<>();
        }
        studentApplications.add(studentApplication);
        mapper.writeValue(file, studentApplications);
    }

    public static void loadStudentApplications() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            studentApplications = mapper.readValue(new File("studentApplications.json"), new TypeReference<>(){});
        } catch (Exception e) {
            System.out.println("Could not load student applications from the file: " + e.getMessage());
        }
    }

    public static void loadClubs() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            clubs = mapper.readValue(new File("clubs.json"), new TypeReference<List<Club>>() {
            });
        } catch (Exception e) {
            System.out.println("Could not load clubs from the file: " + e.getMessage());
        }
    }

    public static List<Event> getEvents() {
        if(events != null) {
            return new ArrayList<>(events);
        } else {
            System.out.println("No events available.");
            return null;
        }
    }
    public static List<Club> getClubs() {
        if(clubs == null) {
            loadClubs();
        }

        if(clubs != null) {
            return new ArrayList<>(clubs);
        } else {
            System.out.println("No clubs available.");
            return null;
        }
    }
}
