package DTO;

public class AnswerDTO {

    private int answerId;
    private int resultId;
    private int examId;
    private int studentId;
    private int questionId;
    private String answer;
    private int isCorrect;

    public AnswerDTO() {

    }

    public AnswerDTO(int answerId, int resultId, int questionId, String answer, int isCorrect) {
        this.answerId = answerId;
        this.resultId = resultId;
        this.questionId = questionId;
        this.answer = answer;
        this.isCorrect = isCorrect;
    }

    public AnswerDTO(int examId, int studentId, int questionId, String answer) {
        this.examId = examId;
        this.studentId = studentId;
        this.questionId = questionId;
        this.answer = answer;
    }

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public int getResultId() {
        return resultId;
    }

    public void setResultId(int resultId) {
        this.resultId = resultId;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getIsCorrect() {
        return isCorrect;
    }

    public void setIsCorrect(int isCorrect) {
        this.isCorrect = isCorrect;
    }

    public int getExamId() {
        return examId;
    }

    public int getStudentId() {
        return studentId;
    }

}
