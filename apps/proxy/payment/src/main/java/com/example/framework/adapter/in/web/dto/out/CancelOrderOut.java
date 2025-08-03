package com.example.framework.adapter.in.web.dto.out;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CancelOrderOut {
    private String result;
    private String status;

    public CancelOrderOut(String result, String status) {
        this.result = result;
        this.status = status;
    }

    public static CancelOrderOut createSuccess(String status) {
        return new CancelOrderOut("SUCCESS", status);
    }

    public static CancelOrderOut createFail(String status) {
        return new CancelOrderOut("FAIL", status);
    }

    @Override
    public String toString() {
        return "CancelOrderOut{" +
                "result='" + result + '\'' +
                '}';
    }
}
