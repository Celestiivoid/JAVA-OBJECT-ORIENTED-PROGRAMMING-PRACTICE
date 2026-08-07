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
        while(true) {
            System.out.println("=====ADD-TEACHER=====");
            System.out.println("Enter teacher name: ");
            String teacherName = scanner.nextLine();

            if(teacherName.isEmpty()) {
                System.out.println("Name field cannot be empty.");
                continue;
            }

            for(int i = 0; i < teacher.size(); i++) {
                Teacher auth = teacher.get(i);
                if(teacherName.equals(auth.getTeacherName())) {
                    System.out.println("Teachers' name already exist.");
                    return;
                }
            }

            System.out.println("Enter teachers' age: ");
            int teacherAge;

            try {
                teacherAge = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only!");
                continue;
            }

            if(teacherAge <= 0) {
                System.out.println("Cannot validate 0 or negative numbers for age field.");
                continue;
            }

            int teacherID = random.nextInt(1000,9999);
            Teacher newTeacher = new Teacher(teacherID, teacherName, teacherAge);
            teacher.add(newTeacher);
            System.out.println("Successfully added new teacher.");
            System.out.println("Teachers' ID: " + teacherID);
            return;
        }
    }
    void viewTeachers() {
        if(teacher.isEmpty()) {
            System.out.println("No teacher available.");
            return;
        }

        for(int i = 0; i < teacher.size(); i++) {
            Teacher view = teacher.get(i);
            System.out.println((i + 1) + ".) " 
            + "Teachers' ID: " + view.getTeacherID()
            + " | Teachers' name: " + view.getTeacherName()
            + " | Teachers' age: " + view.getTeacherAge());
        }
    }
    void searchTeacher() {
        while(true) {
            boolean isFound = false;
            System.out.println("=====SEARCH-TEACHER=====");
            System.out.println("Enter teacher ID: ");
            int teacherID;

            try {
                teacherID = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only!");
                continue;
            }

            if(teacherID < 1000 || teacherID > 9999) {
                System.out.println("4 digits only!");
                continue;
            }

            for(int i = 0; i < teacher.size(); i++) {
                Teacher search = teacher.get(i);
                if(teacherID == search.getTeacherID()) {
                    isFound = true;
                    System.out.println("Teacher found!");
                    System.out.println("Teachers' ID: " + search.getTeacherID() + " | Teachers' name: " + search.getTeacherName());
                    return;
                }
            }

            if(!isFound) {
                System.out.println("Teacher not found!");
                return;
            }
        }
    }
    void updateTeacher() {
        while(true) {
            System.out.println("=====UPDATE-TEACHER=====");
            if(teacher.isEmpty()) {
                System.out.println("No teacher available to update.");
                return;
            }

            viewTeachers();
            System.out.println("Pick a teacher to update: ");
            int option;

            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only!");
                continue;
            }

            if(option < 1 || option > teacher.size()) {
                System.out.println("Out of range!");
                continue;
            }
            else {
                Teacher selectedTeacher = teacher.get(option - 1);
                System.out.println("Enter new teachers' name: ");
                String newName = scanner.nextLine();

                if(newName.isEmpty()) {
                    System.out.println("Name field cannot be empty.");
                    continue;
                }

                System.out.println("Enter new teachers' age: ");
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

                int newTeacherID = random.nextInt(1000,9999);
                Teacher updatedTeacher = new Teacher(newTeacherID, newName, newAge);
                teacher.add(updatedTeacher);
                teacher.remove(selectedTeacher);
                System.out.println("Successfully updated teacher!");
                System.out.println("New teachers' ID: " + newTeacherID);
                return;
            }
        }
    }
    void removeTeacher() {
        while(true) {
            System.out.println("=====REMOVE-TEACHER=====");
            if(teacher.isEmpty()) {
                System.out.println("No teachers available to remove.");
                return;
            }

            viewTeachers();
            System.out.println("Pick a teacher to remove: ");
            int option;

            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only!");
                continue;
            }

            if(option < 1 || option > teacher.size()) {
                System.out.println("Out of range!");
                continue;
            }

            Teacher selectedTeacher = teacher.get(option - 1);
            teacher.remove(selectedTeacher);
            System.out.println("Successfully removed teacher!");
            return;
        }
    }
    /*===TEACHER===*/

    /*===SUBJECT===*/
    void addSubject() {
        while(true) {
            System.out.println("=====ADD-SUBJECT=====");
            System.out.println("Enter subject name: ");
            String subjectName = scanner.nextLine();

            if(subjectName.isEmpty()) {
                System.out.println("Subject field cannot be empty.");
                continue;
            }

            System.out.println("Enter subject code: ");
            String subjectCode = scanner.nextLine();

            if(!subjectCode.matches("\\d{3}")) {
                System.out.println("3 digits only.");
                continue;
            }

            if(teacher.isEmpty()) {
                viewTeachers();
                return;
            }

            viewTeachers();
            System.out.println("Pick a teacher for this subject: ");
            int option;

            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only!");
                continue;
            }

            if(option < 1 || option > teacher.size()) {
                System.out.println("Out of range!");
                continue;
            }

            Teacher selectedTeacher = teacher.get(option - 1);

            Subject newSubject = new Subject(selectedTeacher, subjectName, subjectCode);
            subject.add(newSubject);
            System.out.println("Successfully created subject!");
            return;
        }
    }
    void viewSubjects() {
        if(subject.isEmpty()) {
            System.out.println("No subjects are available.");
            return;
        }

        for(int i = 0; i < subject.size(); i++) {
            Subject view = subject.get(i);
            System.out.println((i + 1) + ".) " + "Subject code: " 
            + view.getSubjectCode() + " | Subject name: " + view.getSubjectName() 
            + " | Assigned Teacher: " + view.getTeacherName());
        }
    }
    void searchSubject() {
        while(true) {
            boolean isFound = false;
            System.out.println("=====SEARCH-SUBJECT=====");
            System.out.println("Enter subjects' code: ");
            String subjectCode = scanner.nextLine();

            if(subjectCode.isEmpty()) {
                System.out.println("Subject code cannot be empty.");
                continue;
            }
            if(!subjectCode.matches("\\d{3}")) {
                System.out.println("3 digits only.");
                continue;
            }

            for(int i = 0; i < subject.size(); i++) {
                Subject search = subject.get(i);
                if(subjectCode.equals(search.getSubjectCode())) {
                    System.out.println("Subject found!");
                    isFound = true;
                    System.out.println((i + 1) + ".) " + "Subject code: " 
                    + search.getSubjectCode() + " | Subject name: " + search.getSubjectName() 
                    + " | Assigned Teacher: " + search.getTeacherName());
                    return;
                }
            }

            if(!isFound) {
                System.out.println("Subject not found!");
                return;
            }
        }
    }
    void updateSubject() {
        while(true) {
            System.out.println("=====UPDATE-SUBJECT=====");
            if(subject.isEmpty()) {
                viewSubjects();
                return;
            }

            viewSubjects();
            System.out.println("Select a subject to update: ");
            int subjectOption;

            try {
                subjectOption = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only!");
                continue;
            }

            if(subjectOption < 1 || subjectOption > subject.size()) {
                System.out.println("Out of range!");
                continue;
            }
            else {
                Subject selectedSubject = subject.get(subjectOption - 1);
                System.out.println("Enter new subject name: ");
                String newName = scanner.nextLine();

                if(newName.isEmpty()) {
                    System.out.println("Name field cannot be empty.");
                    continue;
                }

                System.out.println("Enter new subject code: ");
                String newCode = scanner.nextLine();

                if(newCode.isEmpty()) {
                    System.out.println("Code field cannot be empty.");
                    continue;
                }
                if(!newCode.matches("\\d{3}")) {
                    System.out.println("3 digits only!");
                    continue;
                }

                viewTeachers();
                System.out.println("Select a teacher to assign: ");
                int teacherOption;

                try {
                    teacherOption = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Numbers only!");
                    continue;
                }

                if(teacherOption < 1 || teacherOption > teacher.size()) {
                    System.out.println("Out of range!");
                    continue;
                }

                Teacher selectedTeacher = teacher.get(teacherOption - 1);

                Subject updatedSubject = new Subject(selectedTeacher, newName, newCode);
                subject.remove(selectedSubject);
                subject.add(updatedSubject);
                System.out.println("Successfully updated subject!");
                return;
            }
        }
    }
    void removeSubject() {
        while(true) {
            System.out.println("=====REMOVE-SUBJECTS=====");
            if(subject.isEmpty()) {
                viewSubjects();
                return;
            }
            
            viewSubjects();
            System.out.println("Select a subject to remove: ");
            int option;

            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only!");
                continue;
            }

            if(option < 1 || option > subject.size()) {
                System.out.println("Out of range!");
            }

            Subject selectedSubject = subject.get(option - 1);
            subject.remove(selectedSubject);
            System.out.println("Successfully removed subject!");
            return;
        }
    }
    /*===SUBJECT===*/

    /*===ENROLLMENT===*/
    void enrollStudent() {
        while(true) {
            System.out.println("=====ENROLL-STUDENT=====");
            if(student.isEmpty()) {
                viewStudents();
                return;
            }
            viewStudents();
            System.out.println("Pick a student to enroll: ");
            int studentOption;

            try {
                studentOption = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only!");
                continue;
            }

            Student selectedStudent = student.get(studentOption - 1);
            int enrollmentIDN = random.nextInt(1000,9999);

            while(true) {
                viewSubjects();
                System.out.println("Pick a subject to enroll: ");
                int subjectOption;

                try {
                    subjectOption = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Numbers only!");
                    continue;
                }

                if(subjectOption < 1 || subjectOption > subject.size()) {
                    System.out.println("Out of range!");
                    continue;
                }

                Subject selectedSubject = subject.get(subjectOption - 1);

                Enrollment newEnrollment = new Enrollment(enrollmentIDN, selectedStudent, selectedSubject);
                enrollment.add(newEnrollment);

                System.out.println("Add another subject?");
                System.out.println("[1] Yes");
                System.out.println("[2] No");
                System.out.println("Pick option: ");
                int addOption;

                try {
                    addOption = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Numbers only!");
                    continue;
                }

                if(addOption < 1 || addOption > 2) {
                    System.out.println("Out of range!");
                    continue;
                }
                switch(addOption) {
                    case 1 : {
                        continue;
                    }
                    case 2 : {
                        System.out.println("Successfully enrolled student!");
                        System.out.println("Enrollment identification number: " + enrollmentIDN);
                        return;
                    }
                }
            }
        }
    }
    void dropSubject() {
        ArrayList<Enrollment> matchedSubject = new ArrayList<>();
        while(true) {
            boolean isFound = false;
            System.out.println("=====DROP-SUBJECT=====");
            System.out.println("Enter enrollment identifcation number: ");
            int enrollmentIDN;

            try {
                enrollmentIDN = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only!");
                continue;
            }

            if(enrollmentIDN < 1000 || enrollmentIDN > 9999) {
                System.out.println("4 Digits only!");
                continue;
            }
            for(int i = 0; i < enrollment.size(); i++) {
                Enrollment drop = enrollment.get(i);
                if(enrollmentIDN == drop.getEnrollmentIDN()) {
                    matchedSubject.add(drop);
                    isFound = true;
                    System.out.println("Enrollment found!");
                    System.out.println(matchedSubject.size() + ".) " + "Subject name: " + drop.getSubject().getSubjectName());
                }
            }
            
            if(!isFound) {
                System.out.println("Enrollment not found!");
                continue;
                }

            while(true) {
                System.out.println("Pick a subject to drop: ");
                int subjectOption;

                try {
                subjectOption = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                System.out.println("Numbers only!");
                continue;
                }

                if(subjectOption < 1 || subjectOption > matchedSubject.size()) {
                    System.out.println("Out of range!");
                    continue;
                }

                Enrollment droppedSubject = matchedSubject.get(subjectOption - 1);
                enrollment.remove(droppedSubject); 

                System.out.println("Drop another subject? ");
                System.out.println("[1] Yes");
                System.out.println("[2] No");
                System.out.println("Pick option: ");
                int option;

                try {
                    option = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Numbers only!");
                    continue;
                }

                if(option < 1 || option > 2) {
                    System.out.println("Out of range!");
                    continue;
                }

                switch(option) {
                    case 1: {
                        int increment = 1;
                        for(int i = 0; i < enrollment.size(); i++) {
                        Enrollment drop = enrollment.get(i);
                        System.out.println(increment + ".) " + "Subject name: " + drop.getSubject().getSubjectName());
                        increment++;
                        }
                        continue;
                    }
                    case 2: {
                        System.out.println("Successfully dropped subject(s).");
                        return;
                    }
                }
            }
        }
    }
    void viewEnrollments() {
        while(true) {
            boolean isFound = false;
            System.out.println("=====VIEW-ENROLLMENT=====");
            System.out.println("Enter enrollment identification number: ");
            int enrollmentIDN;

            try {
                enrollmentIDN = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only!");
                continue;
            }

            if(enrollmentIDN < 1000 || enrollmentIDN > 9999) {
                System.out.println("4 Digits only.");
                continue;
            }

            for(int i = 0; i < enrollment.size(); i++) {
                Enrollment view = enrollment.get(i);
                if(enrollmentIDN == view.getEnrollmentIDN()) {
                    isFound = true;
                    System.out.println("Enrollment found!");
                    System.out.println("==========ENROLLMENT-INFORMATION==========" 
                                        + "\nEnrollment Identification number: " + view.getEnrollmentIDN()
                                        + "\nStudent ID: " + view.getStudent().getStudentID()
                                        + "\nStudent name: " + view.getStudent().getStudentName()
                                        + "\nStudents' age: " + view.getStudent().getStudentAge()
                                        + "\n---------------ENROLLED-SUBJECT---------------");
                    for(int j = 0; j < enrollment.size(); j++) {
                        Enrollment subjectView = enrollment.get(j);
                        if(enrollmentIDN == subjectView.getEnrollmentIDN()) {
                             System.out.println((j + 1) + ".) " + "Subject code: " + subjectView.getSubject().getSubjectCode() 
                            + " | Subject name: " + subjectView.getSubject().getSubjectName() + " | Adviser: " + subjectView.getSubject().getTeacherName());
                        }
                    }
                    return;
                }
            }

            if(!isFound) {
                System.out.println("Enrollment record not found!");
                return;
            }
        }
    }
    /*===ENROLLMENT===*/

    /*===GRADE===*/
    void encodeGrade() {
        ArrayList<Enrollment> matchedSubject = new ArrayList<>();
        while(true) {
            boolean isFound = false;
            System.out.println("=====GRADE-INPUT=====");
            System.out.println("Enter enrollment identification number: ");
            int enrollmentIDN;

            try {
                enrollmentIDN = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only!");
                continue;
            }

            if(enrollmentIDN < 1000 || enrollmentIDN > 9999) {
                System.out.println("4 digits only!");
                continue;
            }

            for(int i = 0; i < enrollment.size(); i++) {
                Enrollment input = enrollment.get(i);
                if(enrollmentIDN == input.getEnrollmentIDN()) {
                    matchedSubject.add(input);
                    isFound = true;
                    System.out.println("Enrollment found!");
                    System.out.println(matchedSubject.size() + ".) " + "Subject name: " + input.getSubject().getSubjectName());
                }
            }
            if(!isFound) {
                System.out.println("Enrollment not found!");
                continue;
            }
            while(true) {
                System.out.println("Pick a subject to grade: ");
                int subjectOption;

                try {
                    subjectOption = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Numbers only!");
                    continue;
                }

                if(subjectOption < 1 || subjectOption > matchedSubject.size()) {
                    System.out.println("Out of range!");
                    continue;
                }

                System.out.println("Enter grade: ");
                double subjectGrade;

                try {
                    subjectGrade = Double.parseDouble(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Numbers only!");
                    continue;
                }

                if(subjectGrade <= 0.0 || subjectGrade > 100.0) {
                    System.out.println("Canot set 0 and negative numbers or more than 100.");
                    continue;
                }
                
                Enrollment selectedSubject = matchedSubject.get(subjectOption - 1);
                Grade newGrade = new Grade(selectedSubject, subjectGrade);
                grade.add(newGrade);
                System.out.println("Grade another subject? ");
                System.out.println("[1] Yes");
                System.out.println("[2] No");
                System.out.println("Enter option: ");
                int selection;

                try {
                    selection = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Numbers only!");
                    continue;
                }

                if(selection < 1 || selection > 2) {
                    System.out.println("Out of range!");
                    continue;
                }
                switch(selection) {
                    case 1: {
                        for(int i = 0; i < matchedSubject.size(); i++) {
                            Enrollment grade = matchedSubject.get(i);
                            System.out.println((i + 1)+ ".) " + "Subject name: " + grade.getSubject().getSubjectName());
                        }
                        continue;
                    }
                    case 2: {
                        System.out.println("Successfully graded subject(s).");
                        return;
                    }
                }
            }
        }
    }
    void updateGrade() {

    }
    void viewGrades() {
        while(true) {
            boolean isFound = false;
            System.out.println("=====VIEW-GRADES=====");
            System.out.println("Enter student ID: ");
            int studentID;

            try {
                studentID = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only!");
                continue;
            }

            if(studentID < 1000 || studentID > 9999) {
                System.out.println("4 digits only!");
                return;
            }

            for(int i = 0; i < student.size(); i++) {
                Student graded = student.get(i);
                if(grade.isEmpty()) {
                    System.out.println("No graded subjects.");
                    return;
                }
                if(studentID == graded.getStudentID()) {
                    isFound = true;
                    System.out.println("Student found!");
                    System.out.println("Student ID: " + graded.getStudentID()
                    + "\nStudent name: " + graded.getStudentName());
                }
                for(int j = 0; j < grade.size(); j++) {
                    Grade grades = grade.get(j);
                    if(studentID == grades.getEnrollment().getStudent().getStudentID()) {
                        System.out.println("=====GRADED-SUBJECTS=====");
                        System.out.println((j + 1) 
                        + ".) " + "Subject name: " + grades.getEnrollment().getSubject().getSubjectName() 
                        + " | Grade: " + grades.getStudentGrade());
                    }
                }
            }
            if(!isFound) {
                System.out.println("Student not found!");
                continue;
            }
        }
    }
    void viewReportCard() {

    }
    /*===GRADE===*/

    /*===REPORT===*/
    void viewReport() {
        
    }
    /*===REPORT===*/
}
