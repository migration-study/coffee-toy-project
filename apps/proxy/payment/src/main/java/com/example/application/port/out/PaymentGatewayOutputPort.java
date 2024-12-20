package com.example.application.port.out;

import com.example.framework.adapter.out.network.response.GraphQLRequestPaymentResponse;

public interface PaymentGatewayOutputPort {
    GraphQLRequestPaymentResponse.RequestPaymentResponseData requestPayment();
}
