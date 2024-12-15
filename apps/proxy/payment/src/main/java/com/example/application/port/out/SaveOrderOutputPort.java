package com.example.application.port.out;

import com.example.domain.entity.Payment;

public interface SaveOrderOutputPort {
    void save(Payment payment);
}
