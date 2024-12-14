package com.example.application.port.out;

import com.example.domain.entity.AnswerRefactoring;

public interface AnswerSaveOutPutPort {
    void saveAnswer(AnswerRefactoring answer);
}
