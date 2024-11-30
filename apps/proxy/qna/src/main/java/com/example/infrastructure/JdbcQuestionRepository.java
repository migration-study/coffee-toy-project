package com.example.infrastructure;

import com.example.domain.Question;
import com.example.domain.QuestionRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("questionRepository")
public class JdbcQuestionRepository implements QuestionRepository {
    @Override
    public Optional<Question> findById(Long id) {
        return Optional.empty();
    }
}
