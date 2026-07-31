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
    void saveTeacher() {

    }
    void loadTeacher() {

    }
    void saveSubjects() {

    }
    void loadSubjects() {

    }
    void saveEnrollment() {

    }
    void loadEnrollment() {

    }
    void saveGrades() {

    }
    void loadGrades() {

    }
}
