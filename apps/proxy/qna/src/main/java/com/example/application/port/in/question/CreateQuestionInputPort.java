package com.example.application.port.in.question;

import com.example.framework.adapter.in.dto.in.CreateQuestionIn;
import com.example.framework.adapter.in.dto.out.CreateQuestionOut;

public interface CreateQuestionInputPort {
    CreateQuestionOut createQuestion(CreateQuestionIn createQuestionIn);
}
