package com.example.framework.adapter.out.persistence;

import com.example.application.port.out.SaveOrderOutputPort;
import com.example.domain.entity.Payment;
import com.example.application.port.out.LoadCoffeeOrderOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PaymentPersistenceAdapter implements
        SaveOrderOutputPort,
        LoadCoffeeOrderOutputPort {
    private final PaymentPersistenceMapper mapper;
    private final PaymentJpaRepository paymentJpaRepository;

    @Override
    public Payment loadPayment() {
        return null;
    }

    @Override
    public void save(Payment payment) {
        PaymentEntity paymentEntity = mapper.domainToEntity(payment);
        paymentJpaRepository.save(paymentEntity);
    }
}
