package com.example.application.service;

import com.example.application.port.in.CancelCoffeeOrderInputPort;
import com.example.application.port.out.LoadCoffeeOrderOutputPort;
import com.example.application.port.out.PaymentGatewayOutputPort;
import com.example.application.port.out.SaveOrderOutputPort;
import com.example.domain.entity.Payment;
import com.example.framework.adapter.in.web.dto.in.CancelOrderIn;
import com.example.framework.adapter.in.web.dto.out.CancelOrderOut;
import com.example.framework.adapter.out.network.response.GraphQLCancelResponse;
import com.example.framework.adapter.out.network.response.GraphQLRequestPaymentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.bind.Nested;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class CancelCoffeeOrderUseCase implements CancelCoffeeOrderInputPort {
    private final LoadCoffeeOrderOutputPort repository;
    private final SaveOrderOutputPort saveOrderOutputPort;
    private final PaymentGatewayOutputPort paymentGatewayOutputPort;

    @Override
    @Transactional
    public CancelOrderOut cancelOrder(CancelOrderIn cancelOrderIn) {
        Payment payment = repository.loadPayment(cancelOrderIn.getOrderId());
        GraphQLCancelResponse.CancelResponseData response =
                paymentGatewayOutputPort.requestCancel(
                        payment.getId(),
                        "MIGRATION_CAFE"
                );
        /**
         * ToDo
         * - 성공 및 실패에 따른 로직 처리 필요
         */
        if ("SUCCESS".equals(response.getResult())) {
            payment.updateCancel();
        }

        saveOrderOutputPort.save(payment);

        return CancelOrderOut.createSuccess();
    }
}
