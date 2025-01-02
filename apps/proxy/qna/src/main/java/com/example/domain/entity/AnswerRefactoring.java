package com.example.domain.entity;

import lombok.Getter;

public class AnswerRefactoring {
    @Getter private Long id;
    @Getter private Long writerId;
    @Getter private String content;
    @Getter private boolean deleted;
    @Getter private QuestionRefactoring question;

    public AnswerRefactoring(Long id, Long writerId, String content) {
        this.id = id;
        this.writerId = writerId;
        this.content = content;
        this.deleted = false;
    }

    public AnswerRefactoring(Long id,
                             Long writerId,
                             String content,
                             QuestionRefactoring question) {
        this.id = id;
        this.writerId = writerId;
        this.content = content;
        this.question = question;
        this.deleted = false;
    }
}
