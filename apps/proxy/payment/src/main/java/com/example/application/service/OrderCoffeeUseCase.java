package com.example.application.service;

import com.example.application.port.in.OrderCoffeeInputPort;
import org.springframework.stereotype.Service;

@Service
public class OrderCoffeeUseCase implements OrderCoffeeInputPort {

    @Override
    public void orderCoffee() {
    }
}
