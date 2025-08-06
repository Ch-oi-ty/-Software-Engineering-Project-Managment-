package com.example.fitnessapi.service;

import com.example.fitnessapi.model.Option;
import com.example.fitnessapi.model.Question;
import com.example.fitnessapi.model.AnswerRequest;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class FitnessService {

    private final List<Question> questions = new ArrayList<>();

    public FitnessService() {
        questions.add(new Question(1, "How often do you exercise per week?", List.of(
                new Option(1, "0 times", 0),
                new Option(2, "1-2 times", 1),
                new Option(3, "3-4 times", 2),
                new Option(4, "5 or more times", 3)
        )));

        questions.add(new Question(2, "How would you describe your diet?", List.of(
                new Option(5, "Mostly unhealthy foods", 0),
                new Option(6, "Balanced diet", 2),
                new Option(7, "Healthy and varied", 3)
        )));

        questions.add(new Question(3, "How many hours of sleep do you get on average?", List.of(
                new Option(8, "Less than 5 hours", 0),
                new Option(9, "5-6 hours", 1),
                new Option(10, "7-8 hours", 3),
                new Option(11, "More than 8 hours", 2)
        )));

        questions.add(new Question(4, "How often do you drink water daily?", List.of(
                new Option(12, "1-2 glasses", 0),
                new Option(13, "3-4 glasses", 1),
                new Option(14, "5-6 glasses", 2),
                new Option(15, "More than 6 glasses", 3)
        )));

        questions.add(new Question(5, "Do you smoke or consume alcohol?", List.of(
                new Option(16, "Yes, regularly", 0),
                new Option(17, "Occasionally", 1),
                new Option(18, "Rarely", 2),
                new Option(19, "Never", 3)
        )));

        questions.add(new Question(6, "How would you rate your stress levels?", List.of(
                new Option(20, "Very high", 0),
                new Option(21, "High", 1),
                new Option(22, "Moderate", 2),
                new Option(23, "Low", 3)
        )));

        questions.add(new Question(7, "How often do you eat fast food?", List.of(
                new Option(24, "Every day", 0),
                new Option(25, "3-5 times a week", 1),
                new Option(26, "Once a week", 2),
                new Option(27, "Rarely or never", 3)
        )));

        questions.add(new Question(8, "Do you take time for relaxation or hobbies?", List.of(
                new Option(28, "Never", 0),
                new Option(29, "Sometimes", 1),
                new Option(30, "Often", 2),
                new Option(31, "Daily", 3)
        )));

        questions.add(new Question(9, "How often do you walk or take stairs?", List.of(
                new Option(32, "Never", 0),
                new Option(33, "Sometimes", 1),
                new Option(34, "Often", 2),
                new Option(35, "Daily", 3)
        )));

        questions.add(new Question(10, "How much time do you spend on screens daily?", List.of(
                new Option(36, "More than 8 hours", 0),
                new Option(37, "6-8 hours", 1),
                new Option(38, "3-5 hours", 2),
                new Option(39, "Less than 3 hours", 3)
        )));

        questions.add(new Question(11, "How often do you eat fruits and vegetables?", List.of(
                new Option(40, "Rarely", 0),
                new Option(41, "Sometimes", 1),
                new Option(42, "Daily", 3)
        )));

        questions.add(new Question(12, "Do you perform regular health check-ups?", List.of(
                new Option(43, "Never", 0),
                new Option(44, "Every few years", 1),
                new Option(45, "Yearly", 2),
                new Option(46, "Every 6 months", 3)
        )));

        questions.add(new Question(13, "How well do you manage your time?", List.of(
                new Option(47, "Poorly", 0),
                new Option(48, "Okay", 1),
                new Option(49, "Well", 2),
                new Option(50, "Very well", 3)
        )));

        questions.add(new Question(14, "How often do you eat breakfast?", List.of(
                new Option(51, "Never", 0),
                new Option(52, "Sometimes", 1),
                new Option(53, "Often", 2),
                new Option(54, "Every day", 3)
        )));

        questions.add(new Question(15, "Do you have a consistent sleep schedule?", List.of(
                new Option(55, "Very inconsistent", 0),
                new Option(56, "Somewhat consistent", 1),
                new Option(57, "Mostly consistent", 2),
                new Option(58, "Always consistent", 3)
        )));

        questions.add(new Question(16, "How much sunlight do you get daily?", List.of(
                new Option(59, "None", 0),
                new Option(60, "Less than 15 minutes", 1),
                new Option(61, "15-30 minutes", 2),
                new Option(62, "More than 30 minutes", 3)
        )));

        questions.add(new Question(17, "Do you take any physical wellness classes?", List.of(
                new Option(63, "Never", 0),
                new Option(64, "Tried once", 1),
                new Option(65, "Occasionally", 2),
                new Option(66, "Regularly", 3)
        )));

        questions.add(new Question(18, "Do you monitor your weight or BMI?", List.of(
                new Option(67, "Never", 0),
                new Option(68, "Rarely", 1),
                new Option(69, "Sometimes", 2),
                new Option(70, "Regularly", 3)
        )));

        questions.add(new Question(19, "How often do you feel energetic during the day?", List.of(
                new Option(71, "Rarely", 0),
                new Option(72, "Sometimes", 1),
                new Option(73, "Often", 2),
                new Option(74, "Always", 3)
        )));

        questions.add(new Question(20, "Do you feel satisfied with your fitness level?", List.of(
                new Option(75, "Not at all", 0),
                new Option(76, "Slightly", 1),
                new Option(77, "Mostly", 2),
                new Option(78, "Completely", 3)
        )));
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public List<String> generateSuggestions(AnswerRequest answerRequest) {
        int totalScore = 0;
        Map<Integer, Question> questionMap = new HashMap<>();
        for (Question q : questions) {
            questionMap.put(q.getId(), q);
        }

        for (AnswerRequest.UserAnswer ua : answerRequest.getAnswers()) {
            Question q = questionMap.get(ua.getQuestionId());
            if (q != null) {
                for (Option o : q.getOptions()) {
                    if (o.getId() == ua.getSelectedOptionId()) {
                        totalScore += o.getScore();
                        break;
                    }
                }
            }
        }

        List<String> suggestions = new ArrayList<>();
        if (totalScore <= 25) {
            suggestions.add("Your current lifestyle needs improvement. Start small with daily walks and healthy meals.");
            suggestions.add("Cut back on unhealthy habits and try to build a consistent sleep and exercise routine.");
        } else if (totalScore <= 45) {
            suggestions.add("You're on the right track! Keep making gradual improvements.");
            suggestions.add("Focus on consistency in water intake, sleep, and stress management.");
        } else {
            suggestions.add("Excellent health habits! Consider setting higher fitness goals.");
            suggestions.add("Maintain your routine and support others on their journey.");
        }

        return suggestions;
    }
}
