package com.example.framework.adapter.out.network;

import com.example.application.port.out.PaymentGatewayOutputPort;
import com.example.framework.adapter.out.network.response.GraphQLCancelResponse;
import com.example.framework.adapter.out.network.response.GraphQLRequestPaymentResponse;
import lombok.AllArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;
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
public class PaymentGatewayNetworkAdapter implements PaymentGatewayOutputPort {
    private final RestTemplate restTemplate;

    public PaymentGatewayNetworkAdapter(final RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @Override
    public GraphQLRequestPaymentResponse.RequestPaymentResponseData requestPayment(
            String paymentId, String merchantId, BigDecimal price)
    {
        // GraphQL 쿼리 및 변수 설정
        String query = PaymentGatewayInfo.CREATE_PAYMENT_GRAPHQL_QUERY.value;

        // 요청 변수 설정
        Map<String, Object> variables = new HashMap<>();
        Map<String, Object> request = new HashMap<>();
        request.put("orderId", paymentId);
        request.put("merchantId", merchantId);
        request.put("price", price);
        variables.put("request", request);

        // 요청 본문 구성
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("query", query);
        requestBody.put("variables", variables);

        // 요청 헤더 설정
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // 요청 본문을 포함한 HTTP 엔티티 생성
        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(requestBody, headers);

        // GraphQL 서버에 POST 요청 보내기
        URI url = UriComponentsBuilder.fromUriString(PaymentGatewayInfo.PG_END_POINT.value)
                .build()
                .toUri();
        GraphQLRequestPaymentResponse response = restTemplate.exchange(
                url, HttpMethod.POST, entity, GraphQLRequestPaymentResponse.class
        ).getBody();

        // 응답 처리 (결과에 따른 로직 추가)
        System.out.println("PG 결제 응답 : " + response);

        return response.getData().getCreatePayment();
    }

    @Override
    public GraphQLCancelResponse.CancelResponseData requestCancel(String paymentId, String merchantId) {
        // GraphQL 쿼리 및 변수 설정
        String query = PaymentGatewayInfo.CREATE_CANCEL_GRAPHQL_QUERY.value;

        // 요청 변수 설정
        Map<String, Object> variables = new HashMap<>();
        Map<String, Object> request = new HashMap<>();
        request.put("orderId", paymentId);
        request.put("merchantId", merchantId);
        variables.put("request", request);

        // 요청 본문 구성
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("query", query);
        requestBody.put("variables", variables);

        // 요청 헤더 설정
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // 요청 본문을 포함한 HTTP 엔티티 생성
        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(requestBody, headers);

        // GraphQL 서버에 POST 요청 보내기
        URI url = UriComponentsBuilder.fromUriString(PaymentGatewayInfo.PG_END_POINT.value)
                .build()
                .toUri();
        GraphQLCancelResponse response = restTemplate.exchange(
                url, HttpMethod.POST, entity, GraphQLCancelResponse.class
        ).getBody();

        // 응답 처리 (결과에 따른 로직 추가)
        System.out.println("PG 결제 응답 : " + response);

        return response.getData().getCancelPayment();
    }

    @AllArgsConstructor
    private enum PaymentGatewayInfo {
        PG_END_POINT("http://localhost:7070/graphql"),
        CREATE_PAYMENT_GRAPHQL_QUERY("mutation createPayment($request: CreatePaymentRequest!) { createPayment(request: $request) { paymentId result } }"),
        CREATE_CANCEL_GRAPHQL_QUERY("mutation cancelPayment($request: CancelPaymentRequest!) { cancelPayment(request: $request) { orderId, result } }");

        private String value;
    }
}
