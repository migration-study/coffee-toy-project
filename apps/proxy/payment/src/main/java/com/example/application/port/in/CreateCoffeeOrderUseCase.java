package com.example.application.port.in;

import com.example.framework.adapter.in.web.dto.in.CreateOrderIn;
import com.example.framework.adapter.in.web.dto.out.CreateOrderOut;

public interface CreateCoffeeOrderUseCase {
    CreateOrderOut createOrder(CreateOrderIn orderIn);
}
