package FILEBASEDSCHOOLMANAGEMENT;
import java.util.ArrayList;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;

public class SchoolFileManager {
    void saveStudent(ArrayList<Student> student) throws IOException{
        BufferedWriter save = new BufferedWriter(new FileWriter("Student.csv"));
        for(Student students : student) {
            save.write(students.getStudentID() 
            + "," + students.getStudentName() 
            + "," + students.getStudentAge());
            save.newLine();
        }
        save.close();
    }   
    void loadStudent(ArrayList<Student> student) throws IOException{
        BufferedReader load = new BufferedReader(new FileReader("Student.csv"));
        String line;

        while((line = load.readLine()) != null) {
            String [] studentData = line.split(",");
            int studentID = Integer.parseInt(studentData[0]);
            String studentName = studentData[1];
            int studentAge = Integer.parseInt(studentData[2]);

            student.add(new Student(studentID, studentName, studentAge));
        }
        load.close();
    } 
    void saveTeacher(ArrayList<Teacher> teacher) throws IOException {
        BufferedWriter save = new BufferedWriter(new FileWriter("Teacher.csv"));
        for(Teacher teachers : teacher) {
            save.write(teachers.getTeacherID()
            + "," + teachers.getTeacherName()
            + "," + teachers.getTeacherAge());
            save.newLine();
        }
        save.close();
    }
    void loadTeacher(ArrayList<Teacher> teacher) throws IOException {
        BufferedReader load = new BufferedReader(new FileReader("Teacher.csv"));
        String line;

        while((line = load.readLine()) != null) {
            String [] teacherData = line.split(",");
            int teacherID = Integer.parseInt(teacherData[0]);
            String teacherName = teacherData[1];
            int teacherAge = Integer.parseInt(teacherData[2]);

            teacher.add(new Teacher(teacherID, teacherName, teacherAge));
        }
        load.close();
    }
    void saveSubjects(ArrayList<Subject> subject) throws IOException{
        BufferedWriter save = new BufferedWriter(new FileWriter("Subject.csv"));
        for(Subject subjects : subject) {
            save.write(subjects.getTeacherName()
            + "," + subjects.getSubjectCode()
            + "," + subjects.getSubjectName());
            save.newLine();
        }
        save.close();
    }
    void loadSubjects(ArrayList<Subject> subject) throws IOException {
        BufferedReader load = new BufferedReader(new FileReader("Subject.csv"));
        String line;

        while((line = load.readLine()) != null) {
            String [] subjectData = line.split(",");
            String teacherName = subjectData[0];
            String subjectCode = subjectData[1];
            String subjectName = subjectData[2];

            subject.add(new Subject(teacherName, subjectCode, subjectName));
        }
        load.close();
    }
    void saveEnrollment(ArrayList<Enrollment> enrollment) throws IOException {
        BufferedWriter save = new BufferedWriter(new FileWriter("Enrollment.csv"));
        for(Enrollment enrollments : enrollment) {
            save.write(enrollments.getEnrollmentIDN()
            + "," + enrollments.getStudent().getStudentID()
            + "," + enrollments.getStudent().getStudentName()
            + "," + enrollments.getStudent().getStudentAge()
            + "," + enrollments.getSubject().getSubjectCode()
            + "," + enrollments.getSubject().getSubjectName()
            + "," + enrollments.getSubject().getTeacherName());
            save.newLine();
        }
        save.close();
    }

    void loadEnrollment(ArrayList<Enrollment> enrollment,
        ArrayList<Student> student,
        ArrayList<Subject> subject) throws IOException {
        BufferedReader load = new BufferedReader(new FileReader("Enrollment.csv"));
        String line;

        while((line = load.readLine()) != null) {
            String [] enrollmentData = line.split(",");
            int enrollmentID = Integer.parseInt(enrollmentData[0]);
            int studentID = Integer.parseInt(enrollmentData[1]);
            String studentName = enrollmentData[2];
            int studentAge = Integer.parseInt(enrollmentData[3]);
            String subjectName = enrollmentData[4];
            String subjectID = enrollmentData[5];
            String teacherName = enrollmentData[6];

            Student selectedStudent = null;
            Subject selectedSubject = null;

            for(Student students : student) {
                if(students.getStudentID() == studentID) {
                    selectedStudent = students;
                    break;
                }
            }

            for(Subject subjects : subject) {
                if(subjects.getSubjectCode().equals(subjectID)) {
                    selectedSubject = subjects;
                    break;
                }
            }

            if(selectedStudent != null && selectedSubject != null) {
            }
        }
        load.close();
    }
    void saveGrades() {

    }
    void loadGrades() {

    }
}