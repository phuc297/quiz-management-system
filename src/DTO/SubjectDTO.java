package DTO;

public class SubjectDTO {

    private int subjectId;
    private String subjectName;

    public SubjectDTO() {

    }

    public SubjectDTO(int subjectId, String subjectName) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    @Override
    public String toString() {
        return getSubjectName() + " (" + getSubjectId() + ")";
    }

}
