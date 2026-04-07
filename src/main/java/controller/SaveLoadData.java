package controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Club;
import model.Event;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SaveLoadData {

    private static List<Event> events;
    private static List<Club> clubs;

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

    public static void saveClub(Club club) throws Exception {
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

    public static void loadClubs() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        clubs = mapper.readValue(new File("clubs.json"), new TypeReference<>(){});
    }
}
