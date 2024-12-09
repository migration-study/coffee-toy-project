package com.example.application.service;

import com.example.application.port.in.CancelOrderInputPort;
import com.example.application.port.out.LoadOrderOutputPort;
import com.example.framework.adapter.in.web.dto.CancelOrderIn;
import com.example.framework.adapter.in.web.dto.CancelOrderOut;
import org.springframework.stereotype.Service;

@Service
public class CancelOrderUseCase implements CancelOrderInputPort {
    private final LoadOrderOutputPort repository;

    public CancelOrderUseCase(LoadOrderOutputPort repository) {
        this.repository = repository;
    }

    @Override
    public CancelOrderOut cancelOrder(CancelOrderIn cancelOrderIn) {
        repository.loadPayment();
        return new CancelOrderOut();
    }
}
