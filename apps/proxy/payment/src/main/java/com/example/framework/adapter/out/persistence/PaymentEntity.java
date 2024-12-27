package com.example.framework.adapter.out.persistence;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "payments")
@NoArgsConstructor
public class PaymentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // 자동 증가 전략
    private Long id;

    @Column(name = "order_id", nullable = false)
    private String orderId;

    @Column(name = "member_id", nullable = false)
    private Long memberId;

    @Column(name = "coffee_menu", nullable = false)
    private String coffeeMenu;

    @Column(name = "coffee_price", nullable = false)
    private BigDecimal coffeePrice;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "payment_status", nullable = false)
    private String paymentStatus;

    @Column(name = "payment_gateway_id")
    private String paymentGatewayId;

    public PaymentEntity(String orderId,
                         Long memberId,
                         String coffeeMenu,
                         BigDecimal coffeePrice,
                         String paymentStatus,
                         String paymentGatewayId) {
        this.orderId = orderId;
        this.memberId = memberId;
        this.coffeeMenu = coffeeMenu;
        this.coffeePrice = coffeePrice;
        this.createdAt = LocalDateTime.now();
        this.paymentStatus = paymentStatus;
        this.paymentGatewayId = paymentGatewayId;
    }

    public static PaymentEntity createOrder(String orderId,
                                            Long memberId,
                                            String coffeeMenu,
                                            BigDecimal coffeePrice,
                                            String paymentStatus,
                                            String paymentGatewayId) {
        return new PaymentEntity(
                orderId, memberId, coffeeMenu, coffeePrice, paymentStatus, paymentGatewayId
        );
    }

    public void completeCancel(String paymentStatus) {
        if (!"CANCEL".equals(paymentStatus)) {
            throw new IllegalStateException();
        }
        this.paymentStatus = paymentStatus;
    }
}
