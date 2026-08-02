package FILEBASEDSCHOOLMANAGEMENT;

class Subject {
    private Teacher teacher;
    private String subjectName;
    private String subjectCode;

    Subject(Teacher teacher, String subjectName, String subjectCode) {
        this.teacher = teacher;
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
