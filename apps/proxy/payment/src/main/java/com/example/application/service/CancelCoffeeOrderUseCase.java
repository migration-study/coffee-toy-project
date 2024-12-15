package com.example.application.service;

import com.example.application.port.in.CancelCoffeeOrderInputPort;
import com.example.application.port.out.LoadOrderOutputPort;
import com.example.framework.adapter.in.web.dto.in.CancelOrderIn;
import com.example.framework.adapter.in.web.dto.out.CancelOrderOut;
import org.springframework.stereotype.Service;

@Service
public class CancelCoffeeOrderUseCase implements CancelCoffeeOrderInputPort {
    private final LoadOrderOutputPort repository;

    public CancelCoffeeOrderUseCase(LoadOrderOutputPort repository) {
        this.repository = repository;
    }

    @Override
    public CancelOrderOut cancelOrder(CancelOrderIn cancelOrderIn) {
        repository.loadPayment();
        return new CancelOrderOut();
    }
}
