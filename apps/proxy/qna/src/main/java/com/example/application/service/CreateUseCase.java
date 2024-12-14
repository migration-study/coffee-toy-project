package com.example.application.service;

import com.example.application.port.in.CreateInputPort;
import com.example.application.port.out.SaveOutPutPort;
import com.example.domain.entity.QuestionRefactoring;
import com.example.framework.adapter.in.dto.in.CreateQuestionIn;
import com.example.framework.adapter.in.dto.out.CreateQuestionOut;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateUseCase implements CreateInputPort {
    private final SaveOutPutPort saveOutPutPort;

    @Override
    public CreateQuestionOut createQuestion(CreateQuestionIn createQuestionIn) {
        long questionId = saveOutPutPort.selectQuestionMaxId() + 1;
        QuestionRefactoring question = new QuestionRefactoring(
                questionId,
                createQuestionIn.getWriterId(),
                createQuestionIn.getTitle(),
                createQuestionIn.getContent()
        );
        saveOutPutPort.saveQuestion(question);
        return CreateQuestionOut.createSuccess(question);
    }

    @Override
    public void createAnswer() {

    }

    @Override
    public void addCoffeeMenu() {

    }
}
