package FILEBASEDSCHOOLMANAGEMENT;

public class Enrollment {
    private int enrollmentIDN;
    private Student student;
    private String studentName;
    private int studentAge;
    private Subject subject;

    Enrollment(int enrollmentID, Student student, Subject subject) {
        this.enrollmentIDN = enrollmentID;
        this.student = student;
        this.subject = subject;
    }

    Enrollment(int enrollmentIDN, 
        Student studentID, 
        String studentName, 
        int studentAge,
        String subjectName,
        String subjectCode,
        String teacherName) {
            this.enrollmentIDN = enrollmentIDN;
            this.studentName = studentName;

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
