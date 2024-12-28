package com.example.application.port.in;

import com.example.framework.adapter.in.web.dto.in.CancelOrderIn;
import com.example.framework.adapter.in.web.dto.in.CreateOrderIn;
import com.example.framework.adapter.in.web.dto.out.CancelOrderOut;
import com.example.framework.adapter.in.web.dto.out.CreateOrderOut;
import com.example.framework.adapter.in.web.dto.out.RetrieveOut;

public interface CoffeeOrderInputPort {
    CreateOrderOut createOrder(CreateOrderIn orderIn);
    CancelOrderOut cancelOrder(CancelOrderIn cancelOrderIn);
    RetrieveOut queryOrder(String orderId);
}
