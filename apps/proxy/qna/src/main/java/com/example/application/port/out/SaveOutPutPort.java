package com.example.application.port.out;

import com.example.domain.entity.Question;
import com.example.domain.entity.QuestionRefactoring;


public interface SaveOutPutPort {
    Long selectQuestionMaxId();
    void saveQuestion(QuestionRefactoring question);
}
