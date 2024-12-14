package com.example.framework.adapter.out.persistence;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "question")
@NoArgsConstructor
public class QuestionJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Lob
    @Column(name = "contents")
    private String contents;

    @Column(name = "deleted", nullable = false)
    private Boolean deleted;

    @Column(name = "title", length = 100, nullable = false)
    private String title;

    @Column(name = "writer_id")
    private Long writerId;

    public QuestionJpaEntity(
            Long id,
            String contents,
            boolean deleted,
            String title,
            Long writerId) {
        this.id = id;
        this.contents = contents;
        this.deleted = deleted;
        this.title = title;
        this.writerId = writerId;
        this.createdAt = LocalDateTime.now();
    }
}
