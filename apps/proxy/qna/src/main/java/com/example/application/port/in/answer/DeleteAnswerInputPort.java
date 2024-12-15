package com.example.application.port.in.answer;

import com.example.framework.adapter.in.dto.out.DeleteAnswerOut;

public interface DeleteAnswerInputPort {
    DeleteAnswerOut deleteAnswer(Long answerId);
}
