package com.example.framework.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface AnswerJpaRepository extends JpaRepository<AnswerJpaEntity, Long> {

    @Query("select a from AnswerJpaEntity a where a.questionId = :questionId " +
            "order by a.id desc limit 1")
    Optional<AnswerJpaEntity> loadAnswerCountByQuestionId(@Param("questionId") Long questionId);
}
