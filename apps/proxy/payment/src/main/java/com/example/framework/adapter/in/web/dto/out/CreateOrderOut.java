package com.example.framework.adapter.in.web.dto.out;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateOrderOut {
    private String result;

    public CreateOrderOut(String result) {
        this.result = result;
    }

    public static CreateOrderOut createSuccess() {
        return new CreateOrderOut("SUCCESS");
    }

    @Override
    public String toString() {
        return "CreateOrderOut{" +
                "result='" + result + '\'' +
                '}';
    }
}
