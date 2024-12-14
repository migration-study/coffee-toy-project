package com.example.application.port.in.question;

import com.example.framework.adapter.in.dto.out.DeleteQuestionOut;

public interface DeleteQuestionInputPort {
    DeleteQuestionOut deleteQuestion(Long questionId);
}
