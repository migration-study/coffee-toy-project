package com.example.framework.adapter.out.persistence;

import com.example.application.port.out.question.QuestionDeleteOutPutPort;
import com.example.application.port.out.question.QuestionLoadOutPutPort;
import com.example.application.port.out.question.QuestionSaveOutPutPort;
import com.example.domain.entity.QuestionRefactoring;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

@Component
 @RequiredArgsConstructor
 public class QuestionPersistenceAdapter implements
        QuestionSaveOutPutPort,
        QuestionLoadOutPutPort,
        QuestionDeleteOutPutPort {
    private final QuestionMapper questionMapper;
    private final QuestionJpaRepository questionJpaRepository;

    @Override
    public Long selectQuestionMaxId() {
        long questionMaxId = questionJpaRepository.selectQuestionMaxId()
                        .orElse(1L);
        System.out.println("questionMaxId : " + questionMaxId);

        return questionMaxId;
    }

    @Override
    public QuestionRefactoring loadQuestion(long questionId) {
        QuestionJpaEntity questionJpaEntity = questionJpaRepository.findById(questionId)
                .orElseThrow(NoSuchElementException::new);
        return questionMapper.entityToDomain(questionJpaEntity);
    }

    @Override
    public void saveQuestion(QuestionRefactoring question) {
        QuestionJpaEntity questionJpaEntity = questionMapper.domainToEntity(question);
        questionJpaRepository.save(questionJpaEntity);
    }

    @Override
    public void deleteQuestion(QuestionRefactoring question) {
        QuestionJpaEntity questionJpaEntity = questionMapper.domainToEntity(question);
        questionJpaRepository.delete(questionJpaEntity);
    }
}
