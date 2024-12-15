package com.example.framework.adapter.in.dto.out;

import com.example.domain.entity.QuestionRefactoring;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateQuestionOut {
    private String result;
    private long questionId;

    public CreateQuestionOut(String result, long questionId) {
        this.result = result;
        this.questionId = questionId;
    }

    public static CreateQuestionOut createSuccess(QuestionRefactoring question) {
        return new CreateQuestionOut("SUCCESS", question.getId());
    }

    @Override
    public String toString() {
        return "CreateQuestionOut{" +
                "result='" + result + '\'' +
                ", questionId=" + questionId +
                '}';
    }
}
