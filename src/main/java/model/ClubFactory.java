package model;

public class ClubFactory {

    public static Club createClub(String leaderName, String clubName, String clubType) {
        return new Club(leaderName, clubName, clubType);
    }
}
