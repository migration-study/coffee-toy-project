package com.example.application.service.answer;

import com.example.application.port.in.answer.DeleteAnswerInputPort;
import com.example.application.port.out.answer.AnswerDeleteOutPutPort;
import com.example.application.port.out.answer.AnswerLoadOutPutPort;
import com.example.domain.entity.AnswerRefactoring;
import com.example.framework.adapter.in.dto.out.DeleteAnswerOut;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteAnswerUseCase implements DeleteAnswerInputPort {
    private final AnswerLoadOutPutPort answerLoadOutPutPort;
    private final AnswerDeleteOutPutPort answerDeleteOutPutPort;

    @Override
    public DeleteAnswerOut deleteAnswer(Long answerId) {
        AnswerRefactoring answer = answerLoadOutPutPort.loadAnswerById(answerId);
        if (!answer.isDeleted()) {
            answerDeleteOutPutPort.deleteAnswer(answer);
        }

        return DeleteAnswerOut.createSuccess(answer);
    }
}
