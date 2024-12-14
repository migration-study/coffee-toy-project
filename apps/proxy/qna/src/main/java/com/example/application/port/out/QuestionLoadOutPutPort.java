package com.example.application.port.out;

import com.example.domain.entity.QuestionRefactoring;

public interface QuestionLoadOutPutPort {
    QuestionRefactoring loadQuestion(long questionId);
}
