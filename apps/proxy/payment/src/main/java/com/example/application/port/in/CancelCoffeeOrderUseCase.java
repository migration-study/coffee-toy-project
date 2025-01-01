package com.example.application.port.in;

import com.example.framework.adapter.in.web.dto.in.CancelOrderIn;
import com.example.framework.adapter.in.web.dto.out.CancelOrderOut;

public interface CancelCoffeeOrderUseCase {
    CancelOrderOut cancelOrder(CancelOrderIn cancelOrderIn);
}
