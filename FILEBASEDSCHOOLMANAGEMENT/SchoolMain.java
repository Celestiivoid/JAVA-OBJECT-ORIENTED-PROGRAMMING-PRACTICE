package FILEBASEDSCHOOLMANAGEMENT;
import java.io.IOException;
import java.util.Scanner;

public class SchoolMain {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        SchoolService service = new SchoolService();
        SchoolFileManager manager = new SchoolFileManager();
        while(true) {
            System.out.println("=====SCHOOL-MANAGEMENT-SYSTEM=====");
            System.out.println("[1] Student Management");
            System.out.println("[2] Teacher Management");
            System.out.println("[3] Subject Management");
            System.out.println("[4] Enrollment");
            System.out.println("[5] Grade Management");
            System.out.println("[6] View Reports");
            System.out.println("----------------------------------");
            System.out.println("[7] Save Data");
            System.out.println("[8] Load Data");
            System.out.println("[0] Exit");

            System.out.println("\nEnter option: ");
            int option;

            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only!");
                continue;
            }

            if(option < 0 || option > 8) {
                System.out.println("Out of range!");
                continue;
            }

            switch(option) {
                case 1 -> {
                    studentManagement:
                    while(true) {
                        System.out.println("=====STUDENT-MANAGEMENT=====");
                        System.out.println("[1] Add Student");
                        System.out.println("[2] View Students");
                        System.out.println("[3] Search Student");
                        System.out.println("[4] Update Student");
                        System.out.println("[5] Remove Student");
                        System.out.println("----------------------------");
                        System.out.println("[0] Return");

                        System.out.println("\nEnter option:");
                        int optionSM;

                        try {
                            optionSM = Integer.parseInt(scanner.nextLine());
                        } catch (NumberFormatException e) {
                            System.out.println("Numbers only!");
                            continue;
                        }

                        if(optionSM < 0 || optionSM > 5) {
                            System.out.println("Out of range!");
                            continue;
                        }

                        switch(optionSM) {
                            case 0 -> {
                                break studentManagement;
                            }
                            case 1 -> service.addStudent();
                            case 2 -> service.viewStudents();
                            case 3 -> service.searchStudent();
                            case 4 -> service.updateStudent();
                            case 5 -> service.removeStudent();
                        }
                    }
                }
                case 2 -> {
                    teacherManagement:
                    while(true) {
                        System.out.println("=====TEACHER-MANAGEMENT=====");
                        System.out.println("[1] Add Teacher");
                        System.out.println("[2] View Teachers");
                        System.out.println("[3] Search Teacher");
                        System.out.println("[4] Update Teacher");
                        System.out.println("[5] Remove Teacher");
                        System.out.println("----------------------------");
                        System.out.println("[0] Return");

                        System.out.println("\nEnter option:");
                        int optionSM;

                        try {
                            optionSM = Integer.parseInt(scanner.nextLine());
                        } catch (NumberFormatException e) {
                            System.out.println("Numbers only!");
                            continue;
                        }

                        if(optionSM < 0 || optionSM > 5) {
                            System.out.println("Out of range!");
                            continue;
                        }

                        switch(optionSM) {
                            case 0 -> {
                                break teacherManagement;
                            }
                            case 1 -> service.addTeacher();
                            case 2 -> service.viewTeachers();
                            case 3 -> service.searchTeacher();
                            case 4 -> service.updateTeacher();
                            case 5 -> service.removeTeacher();
                        }
                    }
                }
                case 3 -> {
                    subjectManagement:
                    while(true) {
                        System.out.println("=====SUBJECT-MANAGEMENT=====");
                        System.out.println("[1] Add Subject");
                        System.out.println("[2] View Subjects");
                        System.out.println("[3] Search Subject");
                        System.out.println("[4] Update Subject");
                        System.out.println("[5] Remove Subject");
                        System.out.println("----------------------------");
                        System.out.println("[0] Return");

                        System.out.println("\nEnter option:");
                        int optionSM;

                        try {
                            optionSM = Integer.parseInt(scanner.nextLine());
                        } catch (NumberFormatException e) {
                            System.out.println("Numbers only!");
                            continue;
                        }

                        if(optionSM < 0 || optionSM > 5) {
                            System.out.println("Out of range!");
                            continue;
                        }

                        switch(optionSM) {
                            case 0 -> {
                                break subjectManagement;
                            }
                            case 1 -> service.addSubject();
                            case 2 -> service.viewSubjects();
                            case 3 -> service.searchSubject();
                            case 4 -> service.updateSubject();
                            case 5 -> service.removeSubject();
                        }
                    }
                }
                case 4 -> {
                    enrollment:
                    while(true) {
                        System.out.println("=====ENROLLMENT=====");
                        System.out.println("[1] Enroll Student");
                        System.out.println("[2] Drop Subject");
                        System.out.println("[3] View Enrollment");
                        System.out.println("--------------------");
                        System.out.println("[0] Return");

                        System.out.println("\nEnter option:");
                        int optionSM;

                        try {
                            optionSM = Integer.parseInt(scanner.nextLine());
                        } catch (NumberFormatException e) {
                            System.out.println("Numbers only!");
                            continue;
                        }

                        if(optionSM < 0 || optionSM > 3) {
                            System.out.println("Out of range!");
                            continue;
                        }

                        switch(optionSM) {
                            case 0 -> {
                                break enrollment;
                            }
                            case 1 -> service.enrollStudent();
                            case 2 -> service.dropSubject();
                            case 3 -> service.viewEnrollments();
                        }
                    }
                }
                case 5 -> {
                    gradeManagement:
                    while(true) {
                        System.out.println("=====GRADE-MANAGEMENT=====");
                        System.out.println("[1] Encode Grade");
                        System.out.println("[2] Update Grade");
                        System.out.println("[3] View Grades");
                        System.out.println("[4] View Report Card");
                        System.out.println("--------------------");
                        System.out.println("[0] Return");

                        System.out.println("\nEnter option:");
                        int optionSM;

                        try {
                            optionSM = Integer.parseInt(scanner.nextLine());
                        } catch (NumberFormatException e) {
                            System.out.println("Numbers only!");
                            continue;
                        }

                        if(optionSM < 1 || optionSM > 4) {
                            System.out.println("Out of range!");
                            continue;
                        }

                        switch(optionSM) {
                            case 0 -> {
                                break gradeManagement;
                            }
                            case 1 -> service.encodeGrade();
                            case 2 -> service.updateGrade();
                            case 3 -> service.viewGrades();
                            case 4 -> service.viewReportCard();
                        }
                    }
                }
                case 6 -> service.viewReport();
                case 7 -> {
                    manager.saveStudent(SchoolService.student);
                    System.out.println("Data saved successfully!");
                }
                case 8 -> {
                    manager.loadStudent(SchoolService.student);
                    System.out.println("Data loaded successfully!");
                }
            }
        }
    }    
}
