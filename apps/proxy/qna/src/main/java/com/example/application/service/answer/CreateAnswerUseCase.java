package com.example.application.service.answer;

import com.example.application.port.in.answer.CreateAnswerInputPort;
import com.example.application.port.out.answer.AnswerLoadOutPutPort;
import com.example.application.port.out.answer.AnswerSaveOutPutPort;
import com.example.application.port.out.question.QuestionLoadOutPutPort;
import com.example.domain.entity.AnswerRefactoring;
import com.example.domain.entity.QuestionRefactoring;
import com.example.framework.adapter.in.dto.in.CreateAnswerIn;
import com.example.framework.adapter.in.dto.out.CreateAnswerOut;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateAnswerUseCase implements CreateAnswerInputPort {
    private final AnswerLoadOutPutPort answerLoadOutPutPort;
    private final AnswerSaveOutPutPort answerSaveOutPutPort;
    private final QuestionLoadOutPutPort questionLoadOutPutPort;

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
}
