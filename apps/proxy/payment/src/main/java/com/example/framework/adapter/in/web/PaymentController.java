package com.example.framework.adapter.in.web;

import com.example.application.port.in.CancelCoffeeOrderInputPort;
import com.example.application.port.in.CreateCoffeeIOrderInputPort;
import com.example.application.port.in.QueryCoffeeOrderInputPort;
import com.example.framework.adapter.in.web.dto.in.CancelOrderIn;
import com.example.framework.adapter.in.web.dto.in.CreateOrderIn;
import com.example.framework.adapter.in.web.dto.out.CancelOrderOut;
import com.example.framework.adapter.in.web.dto.out.CreateOrderOut;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/payments")
public class PaymentController {
    private final CreateCoffeeIOrderInputPort createCoffeeIOrderInputPort;
    private final QueryCoffeeOrderInputPort queryCoffeeOrderInputPort;
    private final CancelCoffeeOrderInputPort cancelCoffeeOrderInputPort;

    @PostMapping("/order")
    public ResponseEntity<CreateOrderOut> crateOrder(
            @RequestBody CreateOrderIn orderIn
    ) {
        System.out.println("커피 주문 요청 : " + orderIn);
        CreateOrderOut orderOut = createCoffeeIOrderInputPort.createOrder(orderIn);
        return ResponseEntity.ok(orderOut);
    }

    @PostMapping("/{id}/cancel")
    public ResponseEntity<CancelOrderOut> cancelOrder(
            @RequestBody CancelOrderIn cancelOrderIn)
    {
        CancelOrderOut cancelOrderOut = cancelCoffeeOrderInputPort.cancelOrder(cancelOrderIn);
        return ResponseEntity.ok(cancelOrderOut);
    }
}