package com.example.framework.adapter.in.dto.in;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateQuestionIn {
    private long writerId;
    private String title;
    private String content;

    @Override
    public String toString() {
        return "CreateQuestionIn{" +
                "writerId=" + writerId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
