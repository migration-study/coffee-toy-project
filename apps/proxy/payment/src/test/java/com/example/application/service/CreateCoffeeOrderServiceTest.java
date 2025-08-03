package com.example.application.service;

import com.example.application.port.out.PaymentGatewayOutputPort;
import com.example.application.port.out.SaveCoffeeOrderOutputPort;
import com.example.domain.constant.PaymentStatus;
import com.example.framework.adapter.in.web.dto.in.CreateOrderIn;
import com.example.framework.adapter.in.web.dto.out.CreateOrderOut;
import com.example.framework.adapter.out.network.response.GraphQLPaymentResponse;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayName("커피 주문 생성 서비스 테스트")
@ExtendWith(MockitoExtension.class)
public class CreateCoffeeOrderServiceTest {
    @Mock
    private PaymentGatewayOutputPort paymentGatewayOutputPort;
    @Mock
    private SaveCoffeeOrderOutputPort saveCoffeeOrderOutputPort;
    @InjectMocks
    private CreateCoffeeOrderService createCoffeeOrderService;

    @Test
    void createOrder_success() {
        // given
        Mockito.when(paymentGatewayOutputPort.requestPayment(
                Mockito.anyString(),
                Mockito.anyString(),
                Mockito.any(BigDecimal.class)
        )).thenReturn(PG_결제_응답_생성("SUCCESS"));

        // when
        CreateOrderOut 주문_결과 = createCoffeeOrderService.createOrder(
                new CreateOrderIn(1L, "아메리카노", BigDecimal.valueOf(4500))
        );

        // Then
        assertAll(
                () -> Assertions.assertThat(주문_결과.getStatus()).isEqualTo(PaymentStatus.PAID.toString()),
                () -> Assertions.assertThat(주문_결과.getResult()).isEqualTo("SUCCESS")
        );
    }

    @Test
    void createOrder_fail() {
        // given
        Mockito.when(paymentGatewayOutputPort.requestPayment(
                Mockito.anyString(),
                Mockito.anyString(),
                Mockito.any(BigDecimal.class)
        )).thenReturn(PG_결제_응답_생성("FAIL"));

        // when
        CreateOrderOut 주문_결과 = createCoffeeOrderService.createOrder(
                new CreateOrderIn(1L, "아메리카노", BigDecimal.valueOf(4500))
        );

        // Then
        assertAll(
                () -> Assertions.assertThat(주문_결과.getStatus()).isEqualTo(PaymentStatus.PENDING.toString()),
                () -> Assertions.assertThat(주문_결과.getResult()).isEqualTo("FAIL")
        );
    }

    private GraphQLPaymentResponse.RequestPaymentResponseData PG_결제_응답_생성(String result) {
        return new GraphQLPaymentResponse.RequestPaymentResponseData(
                UUID.randomUUID().toString(),
                result
        );
    }
}
