package DTO;

public class ExamQuestionDTO {

    private int examId;
    private int questionId;

    public ExamQuestionDTO() {

    }

    public ExamQuestionDTO(int examId, int questionId) {
        this.examId = examId;
        this.questionId = questionId;
    }

    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

}
