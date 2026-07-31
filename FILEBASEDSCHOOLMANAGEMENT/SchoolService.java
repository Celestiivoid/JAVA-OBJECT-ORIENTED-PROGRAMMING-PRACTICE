package FILEBASEDSCHOOLMANAGEMENT;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
class SchoolService {
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();
    static ArrayList<Student> student = new ArrayList<>();
    static ArrayList<Teacher> teacher = new ArrayList<>();
    static ArrayList<Subject> subject = new ArrayList<>();
    static ArrayList<Enrollment> enrollment = new ArrayList<>();
    static ArrayList<Grade> grade = new ArrayList<>();
    
    /*===STUDENT===*/
    void addStudent() {
        while(true) {
            System.out.println("=====ADD-STUDENT=====");
            System.out.println("Enter student name: ");
            String name = scanner.nextLine();

            if(name.isEmpty()) {
                System.out.println("Name field cannot be empty.");
                continue;
            }

            for(int i = 0; i < student.size(); i++) {
                Student auth = student.get(i);
                if(name.equals(auth.getStudentName())) {
                    System.out.println("Student already exist.");
                    return;
                }
            }
            
            System.out.println("Enter age: ");
            int age;

            try {
                age = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only!");
                continue;
            }

            if(age <= 0) {
                System.out.println("Cannot validate 0 or negative numbers for age field.");
                continue;
            }

            int studentID = random.nextInt(1000,9999);
            Student newStudent = new Student(studentID, name, age);
            student.add(newStudent);
            System.out.println("Successfully added student.");
            System.out.println("Students' ID: " + studentID);
            return;
        }
    }
    void viewStudents() {
        if(student.isEmpty()) {
            System.out.println("No students are available.");
            return;
        }

        for(int i = 0; i < student.size(); i++) {
            Student view = student.get(i);
            System.out.println((i + 1) + ".) " +
                "Students' ID: " + view.getStudentID() 
                + " | Student name: " + view.getStudentName() 
                + " | Students' age: " + view.getStudentAge());
        }
    }
    void searchStudent() {
        while(true) {
            System.out.println("=====SEARCH-STUDENT=====");
            System.out.println("Enter student ID: ");
            int studentID;

            try {
                studentID = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only!");
                continue;
            }

            if(studentID < 1000 || studentID > 9999) {
                System.out.println("4 digits only.");
                continue;
            }

            for(int i = 0; i < student.size(); i++) {
                Student search = student.get(i);
                if(studentID == search.getStudentID()) {
                    System.out.println("Student found!");
                    System.out.println(
                    "Students' ID: " + search.getStudentID() 
                    + " | Student name: " + search.getStudentName() 
                    + " | Students' age: " + search.getStudentAge());
                }
            }
        }
    }
    void updateStudent() {
        while(true) {
            System.out.println("=====UPDATE-STUDENT=====");

            if(student.isEmpty()) {
                System.out.println("No students available to update.");
                return;
            }

            viewStudents();
            System.out.println("Pick a student to update: ");
            int option;

            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only!");
                continue;
            }

            if(option < 1 || option > student.size()) {
                System.out.println("Out of range!");
                continue;
            }
            else {
                Student selectedStudent = student.get(option - 1);
                System.out.println("Enter new student name: ");
                String newName = scanner.nextLine();

                if(newName.isEmpty()) {
                    System.out.println("Name field cannot be empty.");
                    continue;
                }

                System.out.println("Enter new students' age: ");
                int newAge;

                try {
                    newAge = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Numbers only!");
                    continue;
                }

                if(newAge <= 0) {
                    System.out.println("Cannot validate 0 or negative numbers for age field.");
                    continue;
                }

                int newStudentID = random.nextInt(1000,9999);
                Student updatedStudent = new Student(newStudentID, newName, newAge);
                student.add(updatedStudent);
                student.remove(selectedStudent);
                System.out.println("Successfully updated student.");
                System.out.println("Updated student ID: " + newStudentID);
                return;
            }
        }
    }
    void removeStudent() {
        while(true) {
            System.out.println("=====REMOVE-STUDENT=====");

            if(student.isEmpty()) {
                System.out.println("No available students to remove.");
                return;
            }

            viewStudents();
            System.out.println("Pick a student to remove: ");
            int option;

            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only!");
                continue;
            }

            if(option < 1 || option > student.size()) {
                System.out.println("Out of range!");
                continue;
            }

            Student selectedStudent = student.get(option - 1);
            student.remove(selectedStudent);
            System.out.println("Successfully removed " + selectedStudent.getStudentName());
            return;
        }
    }
    /*===STUDENT===*/


    /*===TEACHER===*/
    void addTeacher() {

    }
    void viewTeachers() {

    }
    void searchTeacher() {

    }
    void updateTeacher() {

    }
    void removeTeacher() {

    }
    /*===TEACHER===*/

    /*===SUBJECT===*/
    void addSubject() {

    }
    void viewSubjects() {

    }
    void searchSubject() {

    }
    void updateSubject() {

    }
    void removeSubject() {

    }
    /*===SUBJECT===*/

    /*===ENROLLMENT===*/
    void enrollStudent() {
        
    }
    void dropSubject() {

    }
    void viewEnrollments() {

    }
    /*===ENROLLMENT===*/

    /*===GRADE===*/
    void encodeGrade() {

    }
    void updateGrade() {

    }
    void viewGrades() {

    }
    void viewReportCard() {

    }
    /*===GRADE===*/

    /*===REPORT===*/
    void viewReport() {
        
    }
    /*===REPORT===*/
}
