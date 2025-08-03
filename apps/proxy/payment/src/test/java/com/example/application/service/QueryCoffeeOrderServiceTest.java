package com.example.application.service;

import com.example.application.port.out.LoadCoffeeOrderOutputPort;
import com.example.domain.entity.Payment;
import com.example.framework.adapter.in.web.dto.out.RetrieveOut;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.UUID;

@DisplayName("커피 주문 조회 서비스 테스트")
@ExtendWith(MockitoExtension.class)
public class QueryCoffeeOrderServiceTest {
    @Mock
    private LoadCoffeeOrderOutputPort loadCoffeeOrderOutputPort;
    @InjectMocks
    private QueryCoffeeOrderService queryCoffeeOrderService;

    @Test
    void queryOrder() {
        Mockito.when(loadCoffeeOrderOutputPort.loadPayment(Mockito.any(String.class)))
                .thenReturn(
                        Payment.createPayment(1L, "아메리카노", BigDecimal.valueOf(4500))
                );

        RetrieveOut 커피_주문_조회 = queryCoffeeOrderService.queryOrder(UUID.randomUUID().toString());

        Assertions.assertThat(커피_주문_조회.getOrderId()).isNotNull();
    }
}
