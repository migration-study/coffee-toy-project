package com.example.application.port.in;

import com.example.framework.adapter.in.web.dto.out.RetrieveOut;

public interface QueryCoffeeOrderUseCase {
    RetrieveOut queryOrder(String orderId);
}
