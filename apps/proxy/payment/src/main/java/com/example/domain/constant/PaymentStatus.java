package com.example.domain.constant;

public enum PaymentStatus {
    PAID,        // 결제 승인
    PENDING,     // 결제 진행
    CANCELED;    // 결제 취소

    public static PaymentStatus getPaymentStatus(String status) {
        if ("PAID".equals(status)) {
            return PAID;
        }
        if ("PENDING".equals(status)) {
            return PENDING;
        }
        return CANCELED;
    }
}
