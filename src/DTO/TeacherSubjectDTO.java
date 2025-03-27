package DTO;

public class TeacherSubjectDTO {

    private int teacherId;
    private int subjectId;

    public TeacherSubjectDTO() {

    }

    public TeacherSubjectDTO(int teacherId, int subjectId) {
        this.teacherId = teacherId;
        this.subjectId = subjectId;
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

}
