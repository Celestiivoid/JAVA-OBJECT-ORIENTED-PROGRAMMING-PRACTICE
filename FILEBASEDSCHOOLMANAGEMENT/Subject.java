package FILEBASEDSCHOOLMANAGEMENT;

class Subject {
    private Teacher teacher;
    private String teacherName;
    private String subjectName;
    private String subjectCode;

    Subject(Teacher teacher, String subjectName, String subjectCode) {
        this.teacher = teacher;
        this.subjectName = subjectName;
        this.subjectCode = subjectCode;
    }

    Subject(String teacherName, String subjectName, String subjectCode) {
        this.teacherName = teacherName;
        this.subjectName = subjectName;
        this.subjectCode = subjectCode;
    }

    String getSubjectName() {
        return subjectName;
    }
    String getSubjectCode() {
        return subjectCode;
    }
    String getTeacherName() {
        return teacher.getTeacherName();
    }
}
