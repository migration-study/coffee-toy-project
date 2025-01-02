package com.example.application.service.question;

import com.example.application.port.in.question.CreateQuestionInputPort;
import com.example.application.port.out.question.QuestionSaveOutPutPort;
import com.example.domain.entity.QuestionRefactoring;
import com.example.framework.adapter.in.dto.in.CreateQuestionIn;
import com.example.framework.adapter.in.dto.out.CreateQuestionOut;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateQuestionUseCase implements CreateQuestionInputPort {
    private final QuestionSaveOutPutPort questionSaveOutPutPort;

    @Override
    public CreateQuestionOut createQuestion(CreateQuestionIn createQuestionIn) {
        long questionId = questionSaveOutPutPort.selectQuestionMaxId() + 1;
        QuestionRefactoring question = new QuestionRefactoring(
                questionId,
                createQuestionIn.getWriterId(),
                createQuestionIn.getTitle(),
                createQuestionIn.getContent()
        );
        questionSaveOutPutPort.saveQuestion(question);
        return CreateQuestionOut.createSuccess(question);
    }
}
