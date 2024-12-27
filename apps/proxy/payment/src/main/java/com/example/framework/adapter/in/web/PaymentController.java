package com.example.framework.adapter.in.web;

import com.example.application.port.in.CancelCoffeeOrderInputPort;
import com.example.application.port.in.CreateCoffeeIOrderInputPort;
import com.example.application.port.in.QueryCoffeeOrderInputPort;
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
    private final CreateCoffeeIOrderInputPort createCoffeeIOrderInputPort;
    private final CancelCoffeeOrderInputPort cancelCoffeeOrderInputPort;
    private final QueryCoffeeOrderInputPort queryCoffeeOrderInputPort;

    @PostMapping("/order")
    public ResponseEntity<CreateOrderOut> crateOrder(
            @RequestBody CreateOrderIn orderIn
    ) {
        System.out.println("커피 주문 요청 : " + orderIn);
        CreateOrderOut orderOut = createCoffeeIOrderInputPort.createOrder(orderIn);
        System.out.println("커피 주문 응답 : " + orderOut);
        return ResponseEntity.ok(orderOut);
    }

    @PostMapping("/cancel")
    public ResponseEntity<CancelOrderOut> cancelOrder(
            @RequestBody CancelOrderIn cancelOrderIn
    ) {
        System.out.println("커피 주문 취소 요청 : " + cancelOrderIn);
        CancelOrderOut cancelOrderOut = cancelCoffeeOrderInputPort.cancelOrder(cancelOrderIn);
        System.out.println("커피 주문 취소 응답 : " + cancelOrderOut);
        return ResponseEntity.ok(cancelOrderOut);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<RetrieveOut> retrieveOrder(
            @PathVariable(value = "orderId") String orderId
    ) {
        System.out.println("커피 주문 조회 요청 : " + orderId);
        RetrieveOut retrieveOut = queryCoffeeOrderInputPort.queryOrder(orderId);
        System.out.println("커피 주문 조회 응답 : " + retrieveOut);
        return ResponseEntity.ok(retrieveOut);
    }
}
