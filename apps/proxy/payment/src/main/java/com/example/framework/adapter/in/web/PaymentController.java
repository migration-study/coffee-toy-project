package com.example.framework.adapter.in.web;

import com.example.application.port.in.CancelOrderInputPort;
import com.example.application.port.in.OrderCoffeeInputPort;
import com.example.application.port.in.QueryOrderInputPort;
import com.example.framework.adapter.in.web.dto.CancelOrderIn;
import com.example.framework.adapter.in.web.dto.CancelOrderOut;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PaymentController {
    private final OrderCoffeeInputPort orderCoffeeInputPort;
    private final QueryOrderInputPort queryOrderInputPort;
    private final CancelOrderInputPort cancelOrderInputPort;

    @PostMapping("/payments/{id}/cancel")
    public ResponseEntity<CancelOrderOut> cancelOrder(
            @RequestBody CancelOrderIn cancelOrderIn)
    {
        CancelOrderOut cancelOrderOut = cancelOrderInputPort.cancelOrder(cancelOrderIn);
        return ResponseEntity.ok(cancelOrderOut);
    }
}
