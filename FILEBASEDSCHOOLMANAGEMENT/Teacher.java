package FILEBASEDSCHOOLMANAGEMENT;
class Teacher {
    private int teacherID;
    private String teacherName;
    private int teacherAge;

    Teacher(int teacherID, String teacherName, int teacherAge) {
        this.teacherID = teacherID;
        this.teacherName = teacherName;
        this.teacherAge = teacherAge;
    }

    int getTeacherID() {
        return teacherID;
    }
    String getTeacherName() {
        return teacherName;
    }
    int getTeacherAge() {
        return teacherAge;
    }
}
