package com.example.framework.adapter.in.dto.out;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class DeleteQuestionOut {
    private String result;
    private long questionId;

    public DeleteQuestionOut(String result, long questionId) {
        this.result = result;
        this.questionId = questionId;
    }

    public static DeleteQuestionOut createSuccess(long questionId) {
        return new DeleteQuestionOut("SUCCESS", questionId);
    }

    @Override
    public String toString() {
        return "DeleteQuestionOut{" +
                "result='" + result + '\'' +
                ", questionId=" + questionId +
                '}';
    }
}
