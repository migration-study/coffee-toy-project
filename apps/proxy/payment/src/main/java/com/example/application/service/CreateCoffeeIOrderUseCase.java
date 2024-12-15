package com.example.application.service;

import com.example.application.port.in.CreateCoffeeIOrderInputPort;
import com.example.application.port.out.PaymentGatewayOutputPort;
import com.example.domain.entity.Payment;
import com.example.framework.adapter.in.web.dto.in.CreateOrderIn;
import com.example.framework.adapter.in.web.dto.out.CreateOrderOut;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateCoffeeIOrderUseCase implements CreateCoffeeIOrderInputPort {
    private final PaymentGatewayOutputPort paymentGatewayOutputPort;

    @Override
    public CreateOrderOut createOrder(CreateOrderIn orderIn) {
        Payment payment = createOrderInToPayment(orderIn);

        paymentGatewayOutputPort.requestPayment();

        // PG사 API를 통해 id에 해당하는 결제 정보를 반환
        // return new Payment();
        return null;
    }

    private Payment createOrderInToPayment(CreateOrderIn orderIn) {
        return Payment.createPayment(
                orderIn.getMemberId(),
                orderIn.getCoffeeMenu(),
                orderIn.getCoffeePrice()
        );
    }
}
