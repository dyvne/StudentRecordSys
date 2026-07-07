package model;

public class Student {

    private String studentId;
    private String firstName;
    private String lastName;
    private String gender;
    private String programme;
    private int level;
    private String email;

    public Student(String studentId, String firstName, String lastName,
                   String gender, String programme, int level, String email) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.programme = programme;
        this.level = level;
        this.email = email;
    }

    // getters
    public String getStudentId() { return studentId; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getGender() { return gender; }
    public String getProgramme() { return programme; }
    public int getLevel() { return level; }
    public String getEmail() { return email; }

    // setters
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setProgramme(String programme) {
        this.programme = programme;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}