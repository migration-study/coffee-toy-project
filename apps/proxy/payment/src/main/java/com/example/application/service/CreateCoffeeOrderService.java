package com.example.application.service;

import com.example.application.port.in.CreateCoffeeOrderUseCase;
import com.example.application.port.out.PaymentGatewayOutputPort;
import com.example.application.port.out.SaveCoffeeOrderOutputPort;
import com.example.domain.entity.Payment;
import com.example.framework.adapter.in.web.dto.in.CreateOrderIn;
import com.example.framework.adapter.in.web.dto.out.CreateOrderOut;
import com.example.framework.adapter.out.network.response.GraphQLPaymentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateCoffeeOrderService implements CreateCoffeeOrderUseCase {
    private final SaveCoffeeOrderOutputPort saveCoffeeOrderOutputPort;
    private final PaymentGatewayOutputPort paymentGatewayOutputPort;

    @Override
    public CreateOrderOut createOrder(CreateOrderIn orderIn) {
        Payment payment = orderIn.toPayment();

        GraphQLPaymentResponse.RequestPaymentResponseData response =
                paymentGatewayOutputPort.requestPayment(
                        payment.getOrderId(),
                        "MIGRATION_CAFE",
                        payment.getCoffeePrice()
                );

        if ("SUCCESS".equals(response.getResult())) {
            payment.updateComplete(response.getPaymentId().toString());
            saveCoffeeOrderOutputPort.save(payment);
            return CreateOrderOut.createSuccess(payment.getStatus().toString());
        } else {
            payment.updateFail();
            return CreateOrderOut.createFail(payment.getStatus().toString());
        }
    }

    private Payment createOrderInToPayment(CreateOrderIn orderIn) {
        return Payment.createPayment(
                orderIn.getMemberId(),
                orderIn.getCoffeeMenu(),
                orderIn.getCoffeePrice()
        );
    }
}
