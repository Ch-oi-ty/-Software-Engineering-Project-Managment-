package com.example.fitnessapi.model;

public class Option {
    private int id;
    private String optionText;
    private int score;

    public Option(int id, String optionText, int score) {
        this.id = id;
        this.optionText = optionText;
        this.score = score;
    }
    public int getId() {return id;}
    public String getOptionText() {return optionText;}
    public int getScore() {return score;}
}
