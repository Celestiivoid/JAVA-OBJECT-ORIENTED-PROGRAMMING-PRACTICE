package FILEBASEDSCHOOLMANAGEMENT;

class Grade {
    private Enrollment enrollment;
    private double studentGrade;
    
    Grade(Enrollment enrollment,double studentGrade) {
        this.enrollment = enrollment;
        this.studentGrade = studentGrade;
    }


    void setStudentGrade(double studentGrade) {
        this.studentGrade = studentGrade;
    }
    double getStudentGrade() {
        return studentGrade;
    }
    Enrollment getEnrollment() {
        return enrollment;
    }
}
