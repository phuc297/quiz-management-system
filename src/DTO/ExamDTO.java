package DTO;

public class ExamDTO {

    private int examId;
    private String examName;
    private int subjectId;
    private String subjectName;
    private String status;
    private int duration;
    private String startTime;
    private String endTime;
    private int totalQuestion;

    public ExamDTO() {

    }

    public ExamDTO(String examName, int subjectId, String status, String startTime, String endTime, int totalQuestion) {
        this.examName = examName;
        this.subjectId = subjectId;
        this.status = status;
        this.startTime = startTime;
        this.endTime = endTime;
        this.totalQuestion = totalQuestion;
    }

    public ExamDTO(int examId, String examName, int subjectId, String status, int duration, String startTime, String endTime, int totalQuestion) {
        this.examId = examId;
        this.examName = examName;
        this.subjectId = subjectId;
        this.status = status;
        this.duration = duration;
        this.startTime = startTime;
        this.endTime = endTime;
        this.totalQuestion = totalQuestion;
    }

    public ExamDTO(int examId, String examName, String subjectName, String status, int duration, String startTime, String endTime, int totalQuestion) {
        this.examId = examId;
        this.examName = examName;
        this.subjectName = subjectName;
        this.status = status;
        this.duration = duration;
        this.startTime = startTime;
        this.endTime = endTime;
        this.totalQuestion = totalQuestion;
    }

    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public int getTotalQuestion() {
        return totalQuestion;
    }

    public void setTotalQuestion(int totalQuestion) {
        this.totalQuestion = totalQuestion;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getDurationString() {
        return duration + " phút";
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "ExamDTO{" + "examId=" + examId + ", examName=" + examName + ", subjectId=" + subjectId + ", subjectName=" + subjectName + ", status=" + status + ", duration=" + duration + ", startTime=" + startTime + ", endTime=" + endTime + ", totalQuestion=" + totalQuestion + '}';
    }

}
