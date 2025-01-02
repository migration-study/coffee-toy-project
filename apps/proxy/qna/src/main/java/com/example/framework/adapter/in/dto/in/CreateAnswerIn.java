package com.example.framework.adapter.in.dto.in;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateAnswerIn {
    private Long writerId;
    private String content;

    @Override
    public String toString() {
        return "CreateAnswerIn{" +
                "writerId=" + writerId +
                ", content='" + content + '\'' +
                '}';
    }
}
