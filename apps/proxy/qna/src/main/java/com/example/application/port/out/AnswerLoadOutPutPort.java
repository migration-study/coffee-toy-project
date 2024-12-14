package com.example.application.port.out;

import com.example.domain.entity.AnswerRefactoring;

public interface AnswerLoadOutPutPort {
    AnswerRefactoring loadLastAnswerByQuestionId(Long questionId);
    AnswerRefactoring loadAnswerById(Long answerId);
}
