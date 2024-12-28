package com.example.application.service;

import com.example.application.port.in.CoffeeOrderInputPort;
import com.example.application.port.out.LoadCoffeeOrderOutputPort;
import com.example.application.port.out.PaymentGatewayOutputPort;
import com.example.application.port.out.SaveCoffeeOrderOutputPort;
import com.example.domain.entity.Payment;
import com.example.framework.adapter.in.web.dto.in.CancelOrderIn;
import com.example.framework.adapter.in.web.dto.in.CreateOrderIn;
import com.example.framework.adapter.in.web.dto.out.CancelOrderOut;
import com.example.framework.adapter.in.web.dto.out.CreateOrderOut;
import com.example.framework.adapter.in.web.dto.out.RetrieveOut;
import com.example.framework.adapter.out.network.response.GraphQLCancelResponse;
import com.example.framework.adapter.out.network.response.GraphQLPaymentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CoffeeOrderUseCase implements CoffeeOrderInputPort {
    private final SaveCoffeeOrderOutputPort saveCoffeeOrderOutputPort;
    private final LoadCoffeeOrderOutputPort loadCoffeeOrderOutputPort;
    private final PaymentGatewayOutputPort paymentGatewayOutputPort;

    @Override
    @Transactional
    public CreateOrderOut createOrder(CreateOrderIn orderIn) {
        Payment payment = createOrderInToPayment(orderIn);

        GraphQLPaymentResponse.RequestPaymentResponseData response =
                paymentGatewayOutputPort.requestPayment(
                        payment.getOrderId(),
                        "MIGRATION_CAFE",
                        payment.getCoffeePrice()
                );

        if ("SUCCESS".equals(response.getResult())) {
            payment.updateComplete(response.getPaymentId().toString());
            saveCoffeeOrderOutputPort.save(payment);
            return CreateOrderOut.createSuccess();
        } else {
            payment.updateFail();
            return CreateOrderOut.createFail();
        }
    }

    private Payment createOrderInToPayment(CreateOrderIn orderIn) {
        return Payment.createPayment(
                orderIn.getMemberId(),
                orderIn.getCoffeeMenu(),
                orderIn.getCoffeePrice()
        );
    }

    @Override
    @Transactional
    public CancelOrderOut cancelOrder(CancelOrderIn cancelOrderIn) {
        Payment payment = loadCoffeeOrderOutputPort.loadPayment(cancelOrderIn.getOrderId());
        GraphQLCancelResponse.CancelResponseData response =
                paymentGatewayOutputPort.requestCancel(
                        payment.getOrderId(),
                        "MIGRATION_CAFE"
                );

        if ("SUCCESS".equals(response.getResult())) {
            payment.updateCancel();
            saveCoffeeOrderOutputPort.save(payment);
            return CancelOrderOut.createSuccess();
        } else {
            payment.updateFail();
            return CancelOrderOut.createSuccess();
        }
    }

    @Override
    public RetrieveOut queryOrder(String orderId) {
        Payment payment = loadCoffeeOrderOutputPort.loadPayment(orderId);
        return new RetrieveOut(payment.getOrderId(), payment.getStatus().toString());
    }
}
