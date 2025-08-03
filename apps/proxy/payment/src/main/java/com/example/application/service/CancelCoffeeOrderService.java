package com.example.application.service;

import com.example.application.port.in.CancelCoffeeOrderUseCase;
import com.example.application.port.out.LoadCoffeeOrderOutputPort;
import com.example.application.port.out.PaymentGatewayOutputPort;
import com.example.application.port.out.SaveCoffeeOrderOutputPort;
import com.example.domain.entity.Payment;
import com.example.framework.adapter.in.web.dto.in.CancelOrderIn;
import com.example.framework.adapter.in.web.dto.out.CancelOrderOut;
import com.example.framework.adapter.out.network.response.GraphQLCancelResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CancelCoffeeOrderService implements CancelCoffeeOrderUseCase {
    private final SaveCoffeeOrderOutputPort saveCoffeeOrderOutputPort;
    private final LoadCoffeeOrderOutputPort loadCoffeeOrderOutputPort;
    private final PaymentGatewayOutputPort paymentGatewayOutputPort;

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
            return CancelOrderOut.createSuccess(payment.getStatus().toString());
        } else {
            payment.updateFail();
            return CancelOrderOut.createFail(payment.getStatus().toString());
        }
    }
}
