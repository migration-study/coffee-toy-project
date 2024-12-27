package com.example.application.port.out;

import com.example.framework.adapter.out.network.response.GraphQLCancelResponse;
import com.example.framework.adapter.out.network.response.GraphQLRequestPaymentResponse;

import java.math.BigDecimal;

public interface PaymentGatewayOutputPort {
    GraphQLRequestPaymentResponse.RequestPaymentResponseData requestPayment(
            String paymentId,
            String merchantId,
            BigDecimal price
    );

    GraphQLCancelResponse.CancelResponseData requestCancel(
            String paymentId,
            String merchantId
    );
}
