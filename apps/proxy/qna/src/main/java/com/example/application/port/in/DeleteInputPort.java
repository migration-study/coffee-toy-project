package com.example.application.port.in;

import com.example.framework.adapter.in.dto.out.DeleteAnswerOut;
import com.example.framework.adapter.in.dto.out.DeleteQuestionOut;

public interface DeleteInputPort {
    DeleteQuestionOut deleteQuestion(Long questionId);
    DeleteAnswerOut deleteAnswer(Long answerId);
}
