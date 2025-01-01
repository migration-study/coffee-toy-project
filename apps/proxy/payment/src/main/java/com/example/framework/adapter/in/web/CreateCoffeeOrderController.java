package com.example.framework.adapter.in.web;

import com.example.application.port.in.CreateCoffeeOrderUseCase;
import com.example.framework.adapter.in.web.dto.in.CreateOrderIn;
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
public class CreateCoffeeOrderController {
    private final CreateCoffeeOrderUseCase createCoffeeOrderUseCase;

    @PostMapping("/order")
    public ResponseEntity<CreateOrderOut> crateOrder(
            @RequestBody CreateOrderIn orderIn
    ) {
        System.out.println("커피 주문 요청 : " + orderIn);
        CreateOrderOut orderOut = createCoffeeOrderUseCase.createOrder(orderIn);
        System.out.println("커피 주문 응답 : " + orderOut);
        return ResponseEntity.ok(orderOut);
    }
}
