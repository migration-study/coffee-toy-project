package com.example.application.service;

import com.example.application.port.out.LoadCoffeeOrderOutputPort;
import com.example.domain.entity.Payment;
import com.example.framework.adapter.in.web.dto.out.RetrieveOut;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QueryCoffeeOrderUseCase implements QueryCoffeeOrderInputPort {
    private final LoadCoffeeOrderOutputPort loadCoffeeOrderOutputPort;

    @Override
    public RetrieveOut queryOrder(String orderId) {
        Payment payment = loadCoffeeOrderOutputPort.loadPayment(orderId);
        return new RetrieveOut(payment.getOrderId(), payment.getStatus().toString());
    }
}
