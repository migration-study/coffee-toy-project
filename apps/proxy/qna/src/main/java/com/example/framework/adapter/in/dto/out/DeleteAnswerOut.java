package com.example.framework.adapter.in.dto.out;

import com.example.domain.entity.AnswerRefactoring;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class DeleteAnswerOut {
    private String result;
    private Long answerId;

    public DeleteAnswerOut(String result, Long answerId) {
        this.result = result;
        this.answerId = answerId;
    }

    public static DeleteAnswerOut createSuccess(AnswerRefactoring answer) {
        return new DeleteAnswerOut("SUCCESS", answer.getId());
    }

    @Override
    public String toString() {
        return "DeleteAnswerOut{" +
                "result='" + result + '\'' +
                ", answerId=" + answerId +
                '}';
    }
}
