package com.example.framework.adapter.out.persistence;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "payments")
@NoArgsConstructor
public class PaymentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // 자동 증가 전략
    private Long id;

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
}
