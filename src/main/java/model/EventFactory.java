package model;

public class EventFactory {

    public static Event createEvent(String eventName, String time, String date, String location) {
        return new Event(eventName, time, date, location);
    }
}
