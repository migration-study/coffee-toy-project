package com.example.framework.adapter.in.web;

import com.example.application.port.in.QueryCoffeeOrderUseCase;
import com.example.framework.adapter.in.web.dto.out.RetrieveOut;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/payments")
public class QueryCoffeeOrderController {
    private final QueryCoffeeOrderUseCase queryCoffeeOrderUseCase;


    @GetMapping("/{orderId}")
    public ResponseEntity<RetrieveOut> retrieveOrder(
            @PathVariable(value = "orderId") String orderId
    ) {
        System.out.println("커피 주문 조회 요청 : " + orderId);
        RetrieveOut retrieveOut = queryCoffeeOrderUseCase.queryOrder(orderId);
        System.out.println("커피 주문 조회 응답 : " + retrieveOut);
        return ResponseEntity.ok(retrieveOut);
    }
}
