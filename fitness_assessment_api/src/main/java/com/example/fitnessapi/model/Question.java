package com.example.fitnessapi.model;

import java.util.List;

public class Question {
    private int id;
    private String questionText;
    private List<Option> options;

    public Question(int id, String questionText, List<Option> options) {
        this.id = id;
        this.questionText = questionText;
        this.options = options;
    }
    public int getId() {return id;}
    public String getQuestionText() {return questionText;}
    public List<Option> getOptions() {return options;}
}
