package com.example.dissertation.GettersSetters;

public class ListViewModel {

    private String score;
    private String date;
    private String counter;
    public ListViewModel(String counter ,String score, String date) {
        this.counter = counter;
        this.score = score;
        this.date = date;
    }
    public ListViewModel() {
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCounter() { return counter; }

    public void setCounter(String counter) { this.counter = counter; }
}

