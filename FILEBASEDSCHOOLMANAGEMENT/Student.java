package FILEBASEDSCHOOLMANAGEMENT;

public class Student {
    private int studentID;
    private String studentName;
    private int studentAge;

    Student(int studentID, String studentName, int studentAge) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.studentAge = studentAge;
    }

    int getStudentID() {
        return studentID;
    }
    String getStudentName() {
        return studentName;
    }
    int getStudentAge() {
        return studentAge;
    }
}
