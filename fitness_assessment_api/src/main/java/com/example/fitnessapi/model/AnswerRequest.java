package com.example.fitnessapi.model;

import java.util.List;

public class AnswerRequest {
    private List<UserAnswer> answers;

    public static class UserAnswer {
        private int questionId;
        private int selectedOptionId;

        public int getQuestionId() {return questionId;}
        public void setQuestionId(int questionId) {this.questionId = questionId;}
        public int getSelectedOptionId() {return selectedOptionId;}
        public void setSelectedOptionId(int selectedOptionId) {this.selectedOptionId = selectedOptionId;}
    }

    public List<UserAnswer> getAnswers() {return answers;}
    public void setAnswers(List<UserAnswer> answers) {this.answers = answers;}
}
