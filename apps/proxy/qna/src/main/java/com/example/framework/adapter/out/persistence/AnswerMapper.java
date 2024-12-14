package com.example.framework.adapter.out.persistence;

import com.example.domain.entity.AnswerRefactoring;
import org.springframework.stereotype.Component;

@Component
public class AnswerMapper {

    public AnswerRefactoring entityToDomain(AnswerJpaEntity answerJpaEntity) {
        return new AnswerRefactoring(
                answerJpaEntity.getId(),
                answerJpaEntity.getWriterId(),
                answerJpaEntity.getContents()
        );
    }

    public AnswerJpaEntity domainToEntity(AnswerRefactoring answer) {
        return new AnswerJpaEntity(
                answer.getId(),
                answer.getQuestion().getId(),
                answer.getWriterId(),
                answer.getContent()
        );
    }
}
