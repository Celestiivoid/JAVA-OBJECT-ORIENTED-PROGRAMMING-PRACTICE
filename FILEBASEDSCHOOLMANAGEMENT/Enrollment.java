package FILEBASEDSCHOOLMANAGEMENT;

public class Enrollment {
    private int enrollmentIDN;
    private Student student;
    private Subject subject;

    Enrollment(int enrollmentID, Student student, Subject subject) {
        this.enrollmentIDN = enrollmentID;
        this.student = student;
        this.subject = subject;
    }


    int getEnrollmentIDN() {
        return enrollmentIDN;
    }
    Student getStudent() {
        return student;
    }
    Subject getSubject() {
        return subject;
    }
}
