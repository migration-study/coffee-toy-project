package com.example.application.port.in;

import com.example.framework.adapter.in.dto.in.CreateQuestionIn;
import com.example.framework.adapter.in.dto.out.CreateQuestionOut;

public interface CreateInputPort {
    CreateQuestionOut createQuestion(CreateQuestionIn createQuestionIn);
    void createAnswer();
    void addCoffeeMenu();
}
