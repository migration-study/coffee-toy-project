package com.example.framework.adapter.out.persistence;

import com.example.domain.entity.Question;
import com.example.domain.repository.QuestionRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("questionRepository")
public class JdbcQuestionRepository implements QuestionRepository {
    @Override
    public Optional<Question> findById(Long id) {
        return Optional.empty();
    }
}
