package com.example.application.port.in;

import com.example.framework.adapter.in.web.dto.CancelOrderIn;
import com.example.framework.adapter.in.web.dto.CancelOrderOut;

public interface CancelOrderInputPort {
    CancelOrderOut cancelOrder(CancelOrderIn cancelOrderIn);
}
