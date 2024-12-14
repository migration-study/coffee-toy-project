package com.example.framework.adapter.out.persistence;

import com.example.application.port.out.SaveOutPutPort;
import com.example.domain.entity.QuestionRefactoring;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
 @RequiredArgsConstructor
 public class QuestionPersistenceAdapter implements SaveOutPutPort {
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
    public void saveQuestion(QuestionRefactoring question) {
        QuestionJpaEntity questionJpaEntity = questionMapper.domainToEntity(question);
        questionJpaRepository.save(questionJpaEntity);
    }
}
