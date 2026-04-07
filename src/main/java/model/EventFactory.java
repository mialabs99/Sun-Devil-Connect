package model;

public class EventFactory {

    public static Event createEvent(String time, String date, String location) {
        return new Event(time, date, location);
    }
}
