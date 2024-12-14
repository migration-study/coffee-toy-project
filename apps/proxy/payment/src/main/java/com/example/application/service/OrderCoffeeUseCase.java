package com.example.application.service;

import com.example.application.port.in.OrderCoffeeInputPort;
import org.springframework.stereotype.Service;

@Service
public class OrderCoffeeUseCase implements OrderCoffeeInputPort {

    @Override
    public void orderCoffee() {
        // PG사 API를 통해 id에 해당하는 결제 정보를 반환
        // return new Payment();
    }
}
