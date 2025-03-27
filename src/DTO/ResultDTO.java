package DTO;

public class ResultDTO {

    private int resultId;
    private int studentId;
    private int examId;
    private int totalQuestion;
    private int totalCorrectAnswers;
    private String submitTime;
    private float score;
    private String examName;
    private String subjectName;
    private String correct;

    public ResultDTO() {

    }

    public ResultDTO(int resultId, int studentId, int examId, int totalQuestion, int totalCorrectAnswers, String submitTime, float score) {
        this.resultId = resultId;
        this.studentId = studentId;
        this.examId = examId;
        this.totalQuestion = totalQuestion;
        this.totalCorrectAnswers = totalCorrectAnswers;
        this.submitTime = submitTime;
        this.score = score;
    }

    public String getCorrect() {
        return getTotalCorrectAnswers() + "/" + getTotalQuestion();
    }

    public void setCorrect(String correct) {
        this.correct = correct;
    }

    public int getResultId() {
        return resultId;
    }

    public void setResultId(int resultId) {
        this.resultId = resultId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

    public int getTotalQuestion() {
        return totalQuestion;
    }

    public void setTotalQuestion(int totalQuestion) {
        this.totalQuestion = totalQuestion;
    }

    public int getTotalCorrectAnswers() {
        return totalCorrectAnswers;
    }

    public void setTotalCorrectAnswers(int totalCorrectAnswers) {
        this.totalCorrectAnswers = totalCorrectAnswers;
    }

    public String getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(String submitTime) {
        this.submitTime = submitTime;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

}
