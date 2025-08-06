package com.example.fitnessapi.controller;

import com.example.fitnessapi.model.AnswerRequest;
import com.example.fitnessapi.model.Question;
import com.example.fitnessapi.model.SuggestionResponse;
import com.example.fitnessapi.service.FitnessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FitnessController {

    @Autowired
    private FitnessService fitnessService;

    @GetMapping("/questions")
    public List<Question> getQuestions() {
        return fitnessService.getQuestions();
    }

    @PostMapping("/submit")
    public SuggestionResponse submitAnswers(@RequestBody AnswerRequest answers) {
        List<String> suggestions = fitnessService.generateSuggestions(answers);
        return new SuggestionResponse(suggestions);
    }
}
