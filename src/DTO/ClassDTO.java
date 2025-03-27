package DTO;

public class ClassDTO {

    private int classId;
    private String className;
    private int teacherId;
    private int subjectId;
    private String teacherName;
    private String subjectName;
    private int totalStudents;

    public ClassDTO() {

    }

    public ClassDTO(String className, int totalStudents) {
        this.className = className;
        this.totalStudents = totalStudents;
    }

    public ClassDTO(String className, int teacherId, int subjectId) {
        this.className = className;
        this.teacherId = teacherId;
        this.subjectId = subjectId;
    }

    public ClassDTO(int classId, String className, String teacher_name, String subject_name) {
        this.classId = classId;
        this.className = className;
        this.teacherName = teacher_name;
        this.subjectName = subject_name;
    }

    public ClassDTO(int classId, String className, int teacherId, int subjectId) {
        this.classId = classId;
        this.className = className;
        this.teacherId = teacherId;
        this.subjectId = subjectId;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public int getTotalStudents() {
        return totalStudents;
    }

    public void setTotalStudents(int totalStudents) {
        this.totalStudents = totalStudents;
    }

    @Override
    public String toString() {
        return getClassName() + " (" + getClassId() + ")";
    }

}
