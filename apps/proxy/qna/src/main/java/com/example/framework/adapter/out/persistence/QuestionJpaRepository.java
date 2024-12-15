package com.example.framework.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface QuestionJpaRepository extends JpaRepository<QuestionJpaEntity, Long> {

    @Query("select max(q.id) from QuestionJpaEntity q")
    Optional<Long> selectQuestionMaxId();
}
