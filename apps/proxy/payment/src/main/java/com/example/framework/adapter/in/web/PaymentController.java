package com.example.framework.adapter.in.web;

import com.example.application.port.in.CoffeeOrderInputPort;
import com.example.framework.adapter.in.web.dto.in.CancelOrderIn;
import com.example.framework.adapter.in.web.dto.in.CreateOrderIn;
import com.example.framework.adapter.in.web.dto.out.CancelOrderOut;
import com.example.framework.adapter.in.web.dto.out.CreateOrderOut;
import com.example.framework.adapter.in.web.dto.out.RetrieveOut;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/payments")
public class PaymentController {
    private final CoffeeOrderInputPort coffeeOrderInputPort;

    @PostMapping("/order")
    public ResponseEntity<CreateOrderOut> crateOrder(
            @RequestBody CreateOrderIn orderIn
    ) {
        System.out.println("커피 주문 요청 : " + orderIn);
        CreateOrderOut orderOut = coffeeOrderInputPort.createOrder(orderIn);
        System.out.println("커피 주문 응답 : " + orderOut);
        return ResponseEntity.ok(orderOut);
    }

    @PostMapping("/cancel")
    public ResponseEntity<CancelOrderOut> cancelOrder(
            @RequestBody CancelOrderIn cancelOrderIn
    ) {
        System.out.println("커피 주문 취소 요청 : " + cancelOrderIn);
        CancelOrderOut cancelOrderOut = coffeeOrderInputPort.cancelOrder(cancelOrderIn);
        System.out.println("커피 주문 취소 응답 : " + cancelOrderOut);
        return ResponseEntity.ok(cancelOrderOut);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<RetrieveOut> retrieveOrder(
            @PathVariable(value = "orderId") String orderId
    ) {
        System.out.println("커피 주문 조회 요청 : " + orderId);
        RetrieveOut retrieveOut = coffeeOrderInputPort.queryOrder(orderId);
        System.out.println("커피 주문 조회 응답 : " + retrieveOut);
        return ResponseEntity.ok(retrieveOut);
    }
}
