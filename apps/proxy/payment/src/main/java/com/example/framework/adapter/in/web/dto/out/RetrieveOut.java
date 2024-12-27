package com.example.framework.adapter.in.web.dto.out;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RetrieveOut {
    private String orderId;
    private String status;

    public RetrieveOut(String orderId, String status) {
        this.orderId = orderId;
        this.status = status;
    }

    @Override
    public String toString() {
        return "RetrieveOut{" +
                "orderId='" + orderId + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
