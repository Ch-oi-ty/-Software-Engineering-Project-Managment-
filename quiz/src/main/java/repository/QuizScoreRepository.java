package com.example.quiz.repository;

import com.example.quiz.model.QuizScore;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizScoreRepository extends JpaRepository<QuizScore,Integer>{
        }