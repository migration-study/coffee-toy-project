package com.example.framework.adapter.out.persistence;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "answer")
@NoArgsConstructor
public class AnswerJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "question_id")
    private Long questionId;

    @Column(name = "writer_id")
    private Long writerId;

    @Lob
    @Column(name = "contents")
    private String contents;

    @Column(name = "deleted", nullable = false)
    private Boolean deleted;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;


    public AnswerJpaEntity(Long id,
                           Long questionId,
                           Long writerId,
                           String contents) {
        this.id = id;
        this.questionId = questionId;
        this.writerId = writerId;
        this.contents = contents;
        this.deleted = false;
        this.createdAt = LocalDateTime.now();
    }
}
