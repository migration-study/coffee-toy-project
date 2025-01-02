package com.example.domain.repository;

import com.example.domain.entity.Question;

import java.util.Optional;

public interface QuestionRepository {
    Optional<Question> findById(Long id);
}
