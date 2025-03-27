package DTO;

import java.util.ArrayList;

public class Score {

    private ArrayList<Double> scores;
    private ArrayList<Integer> count;

    public Score() {
        this.scores = new ArrayList<Double>();
        this.count = new ArrayList<Integer>();
    }

    public ArrayList<Double> getScores() {
        return scores;
    }

    public void setScores(ArrayList<Double> scores) {
        this.scores = scores;
    }

    public ArrayList<Integer> getCount() {
        return count;
    }

    public void setCount(ArrayList<Integer> count) {
        this.count = count;
    }


}
