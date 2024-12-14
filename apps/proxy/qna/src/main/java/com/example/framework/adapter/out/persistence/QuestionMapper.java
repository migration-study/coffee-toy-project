package com.example.framework.adapter.out.persistence;

import com.example.domain.entity.QuestionRefactoring;
import org.springframework.stereotype.Component;

@Component
public class QuestionMapper {
    public QuestionJpaEntity domainToEntity(QuestionRefactoring question) {
        return new QuestionJpaEntity(
                question.getId(),
                question.getContent(),
                question.isDeleted(),
                question.getTitle(),
                question.getWriterId(),
                question.getCreatedDate()
        );
    }
}
