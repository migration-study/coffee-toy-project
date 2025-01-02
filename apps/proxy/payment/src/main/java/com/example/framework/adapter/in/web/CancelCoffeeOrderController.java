package com.example.framework.adapter.in.web;

import com.example.application.port.in.CancelCoffeeOrderUseCase;
import com.example.framework.adapter.in.web.dto.in.CancelOrderIn;
import com.example.framework.adapter.in.web.dto.out.CancelOrderOut;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/payments")
public class CancelCoffeeOrderController {
    private final CancelCoffeeOrderUseCase cancelCoffeeOrderUseCase;

    @PostMapping("/cancel")
    public ResponseEntity<CancelOrderOut> cancelOrder(
            @RequestBody CancelOrderIn cancelOrderIn
    ) {
        System.out.println("커피 주문 취소 요청 : " + cancelOrderIn);
        CancelOrderOut cancelOrderOut = cancelCoffeeOrderUseCase.cancelOrder(cancelOrderIn);
        System.out.println("커피 주문 취소 응답 : " + cancelOrderOut);
        return ResponseEntity.ok(cancelOrderOut);
    }
}
