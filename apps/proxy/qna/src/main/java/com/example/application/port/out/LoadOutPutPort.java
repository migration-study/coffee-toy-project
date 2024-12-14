package com.example.application.port.out;

import com.example.domain.entity.QuestionRefactoring;

public interface LoadOutPutPort {
    QuestionRefactoring loadQuestion(long questionId);
}
