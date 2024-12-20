package com.example.domain.entity;

import com.example.domain.constant.PaymentStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor
public class Payment {
    @Getter private String id;
    @Getter private Long memberId;
    @Getter private String coffeeMenu;
    @Getter private BigDecimal coffeePrice;
    @Getter private PaymentStatus status;

    @Getter @Setter  private String paymentGatewayId;

    public Payment(Long memberId, String coffeeMenu, BigDecimal coffeePrice) {
        this.id = UUID.randomUUID().toString();
        this.memberId = memberId;
        this.coffeeMenu = coffeeMenu;
        this.coffeePrice = coffeePrice;
        this.status = PaymentStatus.PENDING;
    }

    public static Payment createPayment(Long memberId, String coffeeMenu, BigDecimal coffeePrice) {
        return new Payment(memberId, coffeeMenu, coffeePrice);
    }

    public void updateComplete() {
        this.status = PaymentStatus.PAID;
    }
}
