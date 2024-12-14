package com.example.application.port.out;

import com.example.domain.entity.QuestionRefactoring;

public interface QuestionDeleteOutPutPort {
    void deleteQuestion(QuestionRefactoring question);
}
