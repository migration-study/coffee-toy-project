package com.example.application.service;

import com.example.application.port.in.CreateInputPort;
import com.example.application.port.out.AnswerLoadOutPutPort;
import com.example.application.port.out.AnswerSaveOutPutPort;
import com.example.application.port.out.QuestionLoadOutPutPort;
import com.example.application.port.out.QuestionSaveOutPutPort;
import com.example.domain.entity.AnswerRefactoring;
import com.example.domain.entity.QuestionRefactoring;
import com.example.framework.adapter.in.dto.in.CreateAnswerIn;
import com.example.framework.adapter.in.dto.in.CreateQuestionIn;
import com.example.framework.adapter.in.dto.out.CreateAnswerOut;
import com.example.framework.adapter.in.dto.out.CreateQuestionOut;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateUseCase implements CreateInputPort {
    private final QuestionLoadOutPutPort questionLoadOutPutPort;
    private final QuestionSaveOutPutPort questionSaveOutPutPort;
    private final AnswerLoadOutPutPort answerLoadOutPutPort;
    private final AnswerSaveOutPutPort answerSaveOutPutPort;

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

    @Override
    public CreateAnswerOut createAnswer(Long questionId, CreateAnswerIn createAnswerIn) {
        QuestionRefactoring question = questionLoadOutPutPort.loadQuestion(questionId);
        question.checkCanAddAnswer();

        AnswerRefactoring loadedAnswer = answerLoadOutPutPort.loadLastAnswerByQuestionId(questionId);
        AnswerRefactoring newAnswer = new AnswerRefactoring(
                loadedAnswer.getId() + 1,
                createAnswerIn.getWriterId(),
                createAnswerIn.getContent(),
                question
        );
        answerSaveOutPutPort.saveAnswer(newAnswer);
        return CreateAnswerOut.createSuccess(newAnswer);
    }

    @Override
    public void addCoffeeMenu() {

    }
}
