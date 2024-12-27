package com.example.framework.adapter.in.web.dto.out;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CancelOrderOut {
    private String result;

    public CancelOrderOut(String result) {
        this.result = result;
    }

    public static CancelOrderOut createSuccess() {
        return new CancelOrderOut("SUCCESS");
    }

    @Override
    public String toString() {
        return "CancelOrderOut{" +
                "result='" + result + '\'' +
                '}';
    }
}
