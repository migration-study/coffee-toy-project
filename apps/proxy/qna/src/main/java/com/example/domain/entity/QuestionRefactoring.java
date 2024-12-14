package com.example.domain.entity;

import lombok.Getter;

import java.time.LocalDateTime;

public class QuestionRefactoring {
    @Getter private Long id;
    @Getter private Long writerId;
    @Getter private String title;
    @Getter private String content;
    @Getter private boolean deleted;
    @Getter private LocalDateTime createdDate;
    @Getter private LocalDateTime updatedDate;

    public QuestionRefactoring(Long id,
                               Long writerId,
                               String title,
                               String content) {
        this.id = id;
        this.writerId = writerId;
        this.title = title;
        this.content = content;
        this.deleted = false;
        this.createdDate = LocalDateTime.now();
    }

    public QuestionRefactoring(Long id,
                               Long writerId,
                               String title,
                               String content,
                               boolean deleted,
                               LocalDateTime createdDate) {
        this(id, writerId, title, content);
        this.deleted = deleted;
        this.createdDate = createdDate;
    }

    public void checkCanAddAnswer() {
        if (deleted) {
            throw new IllegalStateException("이미 게시글이 삭제되어 답글이 불가능합니다.");
        }
    }
}
