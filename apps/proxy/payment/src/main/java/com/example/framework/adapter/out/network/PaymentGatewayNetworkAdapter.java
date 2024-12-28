package com.example.framework.adapter.out.network;

import com.example.application.port.out.PaymentGatewayOutputPort;
import com.example.framework.adapter.out.network.response.GraphQLCancelResponse;
import com.example.framework.adapter.out.network.response.GraphQLRequestPaymentResponse;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.math.BigDecimal;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class PaymentGatewayNetworkAdapter implements PaymentGatewayOutputPort {
    private final RestTemplate restTemplate;

    @Override
    public GraphQLRequestPaymentResponse.RequestPaymentResponseData requestPayment(
            String paymentId, String merchantId, BigDecimal price
    ) {
        // 요청 변수 설정
        Map<String, Object> request = new HashMap<>();
        request.put("orderId", paymentId);
        request.put("merchantId", merchantId);
        request.put("price", price);

        // 요청 본문 구성
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("query", PaymentGatewayInfo.CREATE_PAYMENT_GRAPHQL_QUERY.value);
        requestBody.put("variables", createVariables(request));

        GraphQLRequestPaymentResponse response = restTemplate.exchange(
                fromPGUrl(),
                HttpMethod.POST,
                createEntity(requestBody),
                GraphQLRequestPaymentResponse.class
        ).getBody();

        System.out.println("PG 결제 응답 : " + response);
        return response.getData().getCreatePayment();
    }

    @Override
    public GraphQLCancelResponse.CancelResponseData requestCancel(
            String paymentId,
            String merchantId
    ) {
        // 요청 변수 설정
        Map<String, Object> request = new HashMap<>();
        request.put("orderId", paymentId);
        request.put("merchantId", merchantId);

        // 요청 본문 구성
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("query", PaymentGatewayInfo.CREATE_CANCEL_GRAPHQL_QUERY.value);
        requestBody.put("variables", createVariables(request));

        // GraphQL 서버에 POST 요청 보내기
        GraphQLCancelResponse response = restTemplate.exchange(
                fromPGUrl(),
                HttpMethod.POST,
                createEntity(requestBody),
                GraphQLCancelResponse.class
        ).getBody();

        System.out.println("PG 결제 응답 : " + response);
        return response.getData().getCancelPayment();
    }

    private Map<String, Object> createVariables(Map<String, Object> request) {
        Map<String, Object> variables = new HashMap<>();
        variables.put("request", request);
        return variables;
    }

    private HttpEntity<Map<String, Object>> createEntity(
            Map<String, Object> requestBody
    ) {
        // 요청 헤더 설정
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        return new HttpEntity<>(requestBody, headers);
    }

    private URI fromPGUrl() {
        return UriComponentsBuilder.fromUriString(PaymentGatewayInfo.PG_END_POINT.value)
                .build()
                .toUri();
    }

    @AllArgsConstructor
    private enum PaymentGatewayInfo {
        PG_END_POINT("http://localhost:7070/graphql"),
        CREATE_PAYMENT_GRAPHQL_QUERY("mutation createPayment($request: CreatePaymentRequest!) { createPayment(request: $request) { paymentId result } }"),
        CREATE_CANCEL_GRAPHQL_QUERY("mutation cancelPayment($request: CancelPaymentRequest!) { cancelPayment(request: $request) { orderId, result } }");

        private String value;
    }
}
