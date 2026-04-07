package model;

public class ClubFactory {

    public static Club createClub(String leaderName, String clubName) {
        return new Club(leaderName, clubName);
    }
}
