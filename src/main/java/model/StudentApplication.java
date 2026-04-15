package model;

public class StudentApplication {

    private Student student;
    private Club club;

    public StudentApplication() {

    }

    public StudentApplication(Student student, Club club) {
        this.student = student;
        this.club = club;
    }

    public Student getStudent() { return student; }
    public Club getClub() { return club; }
}
