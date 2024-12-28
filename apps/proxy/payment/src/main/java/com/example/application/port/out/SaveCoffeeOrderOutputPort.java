package com.example.application.port.out;

import com.example.domain.entity.Payment;

public interface SaveCoffeeOrderOutputPort {
    void save(Payment payment);
}
