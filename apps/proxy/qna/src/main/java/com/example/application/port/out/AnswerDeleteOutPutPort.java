package com.example.application.port.out;

import com.example.domain.entity.AnswerRefactoring;

public interface AnswerDeleteOutPutPort {
    void deleteAnswer(AnswerRefactoring answer);
}
