package com.example.framework.adapter.out.persistence;

import com.example.application.port.out.AnswerDeleteOutPutPort;
import com.example.application.port.out.AnswerLoadOutPutPort;
import com.example.application.port.out.AnswerSaveOutPutPort;
import com.example.domain.entity.AnswerRefactoring;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

@Component
@RequiredArgsConstructor
public class AnswerPersistenceAdapter implements
        AnswerLoadOutPutPort,
        AnswerSaveOutPutPort,
        AnswerDeleteOutPutPort {
    private final AnswerMapper answerMapper;
    private final AnswerJpaRepository answerJpaRepository;

    @Override
    public AnswerRefactoring loadLastAnswerByQuestionId(Long questionId) {
        AnswerJpaEntity loadedAnswerJpaEntity = answerJpaRepository.loadAnswerCountByQuestionId(questionId)
                .orElseThrow(NoSuchElementException::new);
        return answerMapper.entityToDomain(loadedAnswerJpaEntity);
    }

    @Override
    public AnswerRefactoring loadAnswerById(Long answerId) {
        AnswerJpaEntity answerJpaEntity = answerJpaRepository.findById(answerId)
                .orElseThrow(NoSuchElementException::new);
        return answerMapper.entityToDomain(answerJpaEntity);
    }

    @Override
    public void saveAnswer(AnswerRefactoring answer) {
        AnswerJpaEntity answerJpaEntity = answerMapper.domainToEntity(answer);
        answerJpaRepository.save(answerJpaEntity);
    }

    @Override
    public void deleteAnswer(AnswerRefactoring answer) {
        AnswerJpaEntity answerJpaEntity = answerMapper.domainToEntityAtDelete(answer);
        answerJpaRepository.delete(answerJpaEntity);
    }
}
