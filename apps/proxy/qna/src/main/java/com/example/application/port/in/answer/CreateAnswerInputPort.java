package com.example.application.port.in.answer;

import com.example.framework.adapter.in.dto.in.CreateAnswerIn;
import com.example.framework.adapter.in.dto.out.CreateAnswerOut;

public interface CreateAnswerInputPort {
    CreateAnswerOut createAnswer(Long questionId, CreateAnswerIn createAnswerIn);
}
