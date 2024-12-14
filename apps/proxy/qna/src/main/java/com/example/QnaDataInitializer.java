package com.example;

import com.example.framework.adapter.out.persistence.QuestionJpaEntity;
import com.example.framework.adapter.out.persistence.QuestionJpaRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class QnaDataInitializer {
    private final QuestionJpaRepository questionJpaRepository;

    @PostConstruct
    public void initializeDataSet() {
        initializeQuestionDataSet();
    }

    private void initializeQuestionDataSet() {
        QuestionJpaEntity question1 = new QuestionJpaEntity(
                1L,
                "게시글 내용1",
                false,
                "게시글 제목1",
                1L
        );

        QuestionJpaEntity question2 = new QuestionJpaEntity(
                2L,
                "게시글 내용2",
                false,
                "게시글 제목2",
                1L
        );

        questionJpaRepository.save(question1);
        questionJpaRepository.save(question2);
    }
}
