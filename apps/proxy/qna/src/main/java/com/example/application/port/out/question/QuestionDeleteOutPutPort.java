package com.example.application.port.out.question;

import com.example.domain.entity.QuestionRefactoring;

public interface QuestionDeleteOutPutPort {
    void deleteQuestion(QuestionRefactoring question);
}
