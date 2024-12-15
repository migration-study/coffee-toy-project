package com.example.framework.adapter.in.dto.out;

import com.example.domain.entity.AnswerRefactoring;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateAnswerOut {
    private String result;
    private long answerId;
    private long questionId;

    public CreateAnswerOut(String result, long answerId, long questionId) {
        this.result = result;
        this.answerId = answerId;
        this.questionId = questionId;
    }

    public static CreateAnswerOut createSuccess(AnswerRefactoring answer) {
        return new CreateAnswerOut("SUCCESS", answer.getId(), answer.getQuestion().getId());
    }
}
