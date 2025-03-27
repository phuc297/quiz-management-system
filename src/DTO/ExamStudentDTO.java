package DTO;

public class ExamStudentDTO {

    private int examId;
    private int studentId;
    private int classId;

    public ExamStudentDTO(int examId, int studentId, int classId) {
        this.examId = examId;
        this.studentId = studentId;
        this.classId = classId;
    }

    public ExamStudentDTO(int examId, int classId) {
        this.examId = examId;
        this.classId = classId;
    }

    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

}
