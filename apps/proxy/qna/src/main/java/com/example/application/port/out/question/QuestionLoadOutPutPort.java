package com.example.application.port.out.question;

import com.example.domain.entity.QuestionRefactoring;

public interface QuestionLoadOutPutPort {
    QuestionRefactoring loadQuestion(long questionId);
}
