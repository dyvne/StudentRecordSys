package service;

import model.Student;
import java.util.ArrayList;
import java.util.List;

public class StudentManager {

    private List<Student> students = new ArrayList<>();

    // ADD student (prevents duplicate ID)
    public boolean addStudent(Student student) {

        for (Student s : students) {
            if (s.getStudentId().equals(student.getStudentId())) {
                return false; // duplicate ID
            }
        }

        students.add(student);
        return true;
    }

    //DELETE student by ID
    public boolean deleteStudent(String studentId) {
        return students.removeIf(s ->
                s.getStudentId().equals(studentId)
        );
    }

    //  UPDATE student (better version)
    public boolean updateStudent(Student updatedStudent) {

        for (Student s : students) {

            if (s.getStudentId().equals(updatedStudent.getStudentId())) {

                s.setFirstName(updatedStudent.getFirstName());
                s.setLastName(updatedStudent.getLastName());
                s.setGender(updatedStudent.getGender());
                s.setProgramme(updatedStudent.getProgramme());
                s.setLevel(updatedStudent.getLevel());
                s.setEmail(updatedStudent.getEmail());

                return true;
            }
        }

        return false;
    }

    //  SEARCH student
    public Student searchStudent(String studentId) {
        for (Student s : students) {
            if (s.getStudentId().equals(studentId)) {
                return s;
            }
        }
        return null;
    }

    //  GET ALL students
    public List<Student> getAllStudents() {
        return students;
    }

    //  TOTAL students
    public int getTotalStudents() {
        return students.size();
    }
}