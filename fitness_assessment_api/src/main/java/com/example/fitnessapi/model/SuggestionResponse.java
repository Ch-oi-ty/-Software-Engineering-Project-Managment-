package com.example.fitnessapi.model;

import java.util.List;

public class SuggestionResponse {
    private List<String> suggestions;

    public SuggestionResponse(List<String> suggestions) {
        this.suggestions = suggestions;
    }
    public List<String> getSuggestions() {return suggestions;}
}
