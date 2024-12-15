package com.example.framework.adapter.out.network.response;

import lombok.Data;

@Data
public class RequestPaymentResponse {
    private Integer paymentId;
    private String message;

    @Override
    public String toString() {
        return "RequestPaymentResponse{" +
                "paymentId=" + paymentId +
                ", message='" + message + '\'' +
                '}';
    }
}
