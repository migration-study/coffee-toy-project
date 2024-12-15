package com.example.domain.repository;

import com.example.domain.entity.Answer;

import java.util.List;

public interface AnswerRepository {
    List<Answer> findByQuestion(Long questionId);
}
