package com.example.domain.entity;

import com.example.domain.constant.PaymentStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@NoArgsConstructor
public class Payment {
    @Getter private String orderId;
    @Getter private Long memberId;
    @Getter private String coffeeMenu;
    @Getter private BigDecimal coffeePrice;
    @Getter private PaymentStatus status;

    @Getter private String paymentGatewayId;

    public Payment(Long memberId, String coffeeMenu, BigDecimal coffeePrice) {
        this.orderId = UUID.randomUUID().toString();
        this.memberId = memberId;
        this.coffeeMenu = coffeeMenu;
        this.coffeePrice = coffeePrice;
        this.status = PaymentStatus.PENDING;
    }

    public Payment(String orderId,
                   Long memberId,
                   String coffeeMenu,
                   BigDecimal coffeePrice,
                   String status,
                   String paymentGatewayId) {
        this(memberId, coffeeMenu, coffeePrice);
        this.orderId = orderId;
        this.status = PaymentStatus.getPaymentStatus(status);
        this.paymentGatewayId = paymentGatewayId;
    }

    public static Payment createPayment(Long memberId, String coffeeMenu, BigDecimal coffeePrice) {
        return new Payment(memberId, coffeeMenu, coffeePrice);
    }

    public static Payment createFromEntity(String id,
                                           Long memberId,
                                           String coffeeMenu,
                                           BigDecimal coffeePrice,
                                           String status,
                                           String paymentGatewayId) {
        return new Payment(id, memberId, coffeeMenu, coffeePrice, status, paymentGatewayId);
    }

    public void updateComplete(String paymentGatewayId) {
        this.paymentGatewayId = paymentGatewayId;
        this.status = PaymentStatus.PAID;
    }

    public void updateCancel() {
        if (this.status != PaymentStatus.PAID) {
            throw new IllegalStateException("결제가 완료 상태가 아니기에 결제 취소를 할 수 없습니다.");
        }
        if (this.status == PaymentStatus.PENDING) {
            throw new IllegalStateException("결제가 보류 상태이기에 결제 취소를 할 수 없습니다.");
        }
        this.status = PaymentStatus.CANCELED;
    }

    public void updateFail() {
        this.status = PaymentStatus.PENDING;
    }
}
