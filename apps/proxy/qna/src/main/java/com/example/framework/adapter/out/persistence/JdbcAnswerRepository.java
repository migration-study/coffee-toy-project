package com.example.framework.adapter.out.persistence;

import com.example.domain.entity.Answer;
import com.example.domain.repository.AnswerRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("answerRepository")
public class JdbcAnswerRepository implements AnswerRepository {
    @Override
    public List<Answer> findByQuestion(Long questionId) {
        return null;
    }
}
