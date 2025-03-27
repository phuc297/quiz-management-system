package GUI;

public class Choose {

    private int questionId;
    private boolean optionA;
    private boolean optionB;
    private boolean optionC;
    private boolean optionD;
    private String text;

    public Choose(String text,int questionId) {
        this.text = text;
        this.questionId = questionId;
    }

    public boolean isChosen() {
        if (!optionA && !optionB && !optionC && !optionD) {
            return false;
        }
        return true;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public boolean isOptionA() {
        return optionA;
    }

    public void setOptionA() {
        this.optionA = true;
        this.optionB = false;
        this.optionC = false;
        this.optionD = false;
    }

    public boolean isOptionB() {
        return optionB;
    }

    public void setOptionB() {
        this.optionA = false;
        this.optionB = true;
        this.optionC = false;
        this.optionD = false;
    }

    public boolean isOptionC() {
        return optionC;
    }

    public void setOptionC() {
        this.optionA = false;
        this.optionB = false;
        this.optionC = true;
        this.optionD = false;
    }

    public boolean isOptionD() {
        return optionD;
    }

    public void setOptionD() {
        this.optionA = false;
        this.optionB = false;
        this.optionC = false;
        this.optionD = true;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
    public String getOption(){
        if(optionA)
            return "A";
        if(optionB)
            return "B";
        if(optionC)
            return "C";
        if(optionD)
            return "D";
        return null;
    }

}
