package com.example.application.service;

import com.example.application.port.in.CreateCoffeeIOrderInputPort;
import com.example.application.port.out.PaymentGatewayOutputPort;
import com.example.application.port.out.SaveOrderOutputPort;
import com.example.domain.entity.Payment;
import com.example.framework.adapter.in.web.dto.in.CreateOrderIn;
import com.example.framework.adapter.in.web.dto.out.CreateOrderOut;
import com.example.framework.adapter.out.network.response.GraphQLRequestPaymentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CreateCoffeeIOrderUseCase implements CreateCoffeeIOrderInputPort {
    private final SaveOrderOutputPort saveOrderOutputPort;
    private final PaymentGatewayOutputPort paymentGatewayOutputPort;

    @Override
    @Transactional
    public CreateOrderOut createOrder(CreateOrderIn orderIn) {
        Payment payment = createOrderInToPayment(orderIn);

        GraphQLRequestPaymentResponse.RequestPaymentResponseData response =
                paymentGatewayOutputPort.requestPayment(
                        payment.getId(),
                        "MIGRATION_CAFE",
                        payment.getCoffeePrice()
                );
        /**
         * ToDO
         * - 결제 성공 또는 실패에 따른 UPDATE 로직 추가 필요
         */
        payment.setPaymentGatewayId(response.getPaymentId().toString());
        payment.updateComplete();
        saveOrderOutputPort.save(payment);

        return CreateOrderOut.createSuccess();
    }

    private Payment createOrderInToPayment(CreateOrderIn orderIn) {
        return Payment.createPayment(
                orderIn.getMemberId(),
                orderIn.getCoffeeMenu(),
                orderIn.getCoffeePrice()
        );
    }
}
