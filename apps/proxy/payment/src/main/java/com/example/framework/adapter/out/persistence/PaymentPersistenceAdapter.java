package com.example.framework.adapter.out.persistence;

import com.example.application.port.out.SaveOrderOutputPort;
import com.example.domain.entity.Payment;
import com.example.application.port.out.LoadOrderOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PaymentPersistenceAdapter implements
        SaveOrderOutputPort,
        LoadOrderOutputPort {
    private final PaymentPersistenceMapper mapper;

    @Override
    public Payment loadPayment() {
        return null;
    }

    @Override
    public void save(Payment payment) {

    }
}
