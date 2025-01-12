package com.example.application.service;

import com.example.application.port.out.LoadCoffeeOrderOutputPort;
import com.example.application.port.out.PaymentGatewayOutputPort;
import com.example.application.port.out.SaveCoffeeOrderOutputPort;
import com.example.domain.constant.PaymentStatus;
import com.example.domain.entity.Payment;
import com.example.framework.adapter.in.web.dto.in.CancelOrderIn;
import com.example.framework.adapter.in.web.dto.out.CancelOrderOut;
import com.example.framework.adapter.out.network.response.GraphQLCancelResponse;
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

import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayName("커피 주문 취소 서비스 테스트")
@ExtendWith(MockitoExtension.class)
public class CancelCoffeeOrderServiceTest {
    @Mock
    private SaveCoffeeOrderOutputPort saveCoffeeOrderOutputPort;
    @Mock
    private LoadCoffeeOrderOutputPort loadCoffeeOrderOutputPort;
    @Mock
    private PaymentGatewayOutputPort paymentGatewayOutputPort;
    @InjectMocks
    private CancelCoffeeOrderService cancelCoffeeOrderService;

    @Test
    void cancelOrder_success() {
        Payment 아메리카노_주문 = createCompletePayment(
                1L,
                "아메리카노",
                BigDecimal.valueOf(4500)
        );

        Mockito.when(loadCoffeeOrderOutputPort.loadPayment(Mockito.any(String.class)))
                .thenReturn(아메리카노_주문);

        Mockito.when(paymentGatewayOutputPort.requestCancel(
                Mockito.any(String.class),
                Mockito.any(String.class)))
                .thenReturn(PG_결제_취소_응답_생성("SUCCESS"));

        CancelOrderOut 취소_결과 = cancelCoffeeOrderService.cancelOrder(
                new CancelOrderIn(아메리카노_주문.getOrderId())
        );

        assertAll(
                () -> Assertions.assertThat(취소_결과.getResult()).isEqualTo("SUCCESS"),
                () -> Assertions.assertThat(취소_결과.getStatus()).isEqualTo(PaymentStatus.CANCELED.toString())
        );
    }

    @Test
    void cancelOrder_fail() {
        Payment 아메리카노_주문 = createCompletePayment(
                1L,
                "아메리카노",
                BigDecimal.valueOf(4500)
        );

        Mockito.when(loadCoffeeOrderOutputPort.loadPayment(Mockito.any(String.class)))
                .thenReturn(아메리카노_주문);

        Mockito.when(paymentGatewayOutputPort.requestCancel(
                        Mockito.any(String.class),
                        Mockito.any(String.class)))
                .thenReturn(PG_결제_취소_응답_생성("FAIL"));

        CancelOrderOut 취소_결과 = cancelCoffeeOrderService.cancelOrder(
                new CancelOrderIn(아메리카노_주문.getOrderId())
        );

        assertAll(
                () -> Assertions.assertThat(취소_결과.getResult()).isEqualTo("FAIL"),
                () -> Assertions.assertThat(취소_결과.getStatus()).isEqualTo(PaymentStatus.PENDING.toString())
        );
    }

    private Payment createCompletePayment(Long memberId, String coffeeMenu, BigDecimal coffeePrice) {
        Payment payment = Payment.createPayment(memberId, coffeeMenu, coffeePrice);
        payment.updateComplete(UUID.randomUUID().toString());
        return payment;
    }

    private GraphQLCancelResponse.CancelResponseData PG_결제_취소_응답_생성(String result) {
        return new GraphQLCancelResponse.CancelResponseData(
                UUID.randomUUID().toString(),
                result
        );
    }
}
