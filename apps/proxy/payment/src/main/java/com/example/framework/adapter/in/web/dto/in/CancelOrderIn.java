package com.example.framework.adapter.in.web.dto.in;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CancelOrderIn {
    private String orderId;

    public CancelOrderIn(String orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "CancelOrderIn{" +
                "orderId='" + orderId + '\'' +
                '}';
    }
}
