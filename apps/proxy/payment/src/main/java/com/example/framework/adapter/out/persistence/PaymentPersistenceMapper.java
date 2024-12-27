package com.example.framework.adapter.out.persistence;

import com.example.domain.entity.Payment;
import org.springframework.stereotype.Component;

@Component
public class PaymentPersistenceMapper {

    public PaymentEntity domainToEntity(Payment payment) {
        return PaymentEntity.createOrder(
                payment.getId(),
                payment.getMemberId(),
                payment.getCoffeeMenu(),
                payment.getCoffeePrice(),
                payment.getStatus().toString(),
                payment.getPaymentGatewayId()
        );
    }

    public Payment entityToDomain(PaymentEntity paymentEntity) {
        return Payment.createFromEntity(
                paymentEntity.getOrderId(),
                paymentEntity.getMemberId(),
                paymentEntity.getCoffeeMenu(),
                paymentEntity.getCoffeePrice(),
                paymentEntity.getPaymentStatus(),
                paymentEntity.getPaymentGatewayId()
        );
    }
}
