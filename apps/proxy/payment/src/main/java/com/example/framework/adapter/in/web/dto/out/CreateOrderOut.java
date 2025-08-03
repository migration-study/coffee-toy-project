package com.example.framework.adapter.in.web.dto.out;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateOrderOut {
    private String result;
    private String status;

    public CreateOrderOut(String result, String status) {
        this.result = result;
        this.status = status;
    }

    public static CreateOrderOut createSuccess(String status) {
        return new CreateOrderOut("SUCCESS", status);
    }

    public static CreateOrderOut createFail(String status) {
        return new CreateOrderOut("FAIL", status);
    }

    @Override
    public String toString() {
        return "CreateOrderOut{" +
                "result='" + result + '\'' +
                '}';
    }
}
