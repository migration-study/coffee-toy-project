package com.example.domain.entity;

import com.example.domain.constant.PaymentStatus;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor
public class Payment {
    private String id;
    private Long memberId;
    private String coffeeMenu;
    private BigDecimal coffeePrice;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private PaymentStatus status;

    @Setter private String paymentGatewayId;

    public Payment(Long memberId, String coffeeMenu, BigDecimal coffeePrice) {
        this.id = UUID.randomUUID().toString();
        this.memberId = memberId;
        this.coffeeMenu = coffeeMenu;
        this.coffeePrice = coffeePrice;
        this.createdAt = LocalDateTime.now();
        this.status = PaymentStatus.PENDING;
    }

    public static Payment createPayment(Long memberId, String coffeeMenu, BigDecimal coffeePrice) {
        return new Payment(memberId, coffeeMenu, coffeePrice);
    }
}
