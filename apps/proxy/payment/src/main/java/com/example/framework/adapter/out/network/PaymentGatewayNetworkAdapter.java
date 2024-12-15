package com.example.framework.adapter.out.network;

import com.example.application.port.out.PaymentGatewayOutputPort;
import com.example.framework.adapter.out.network.response.RequestPaymentResponse;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@Component
public class PaymentGatewayNetworkAdapter implements PaymentGatewayOutputPort {
    private static final String PG_END_POINT = "http://localhost:7070/graphql";
    private final RestTemplate restTemplate;

    public PaymentGatewayNetworkAdapter(final RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @Override
    public boolean requestPayment() {
        // GraphQL 쿼리 및 변수 설정
        String query = "mutation createPayment($request: CreatePaymentRequest!) { createPayment(request: $request) { paymentId result } }";

        // 요청 변수 설정
        Map<String, Object> variables = new HashMap<>();
        Map<String, Object> request = new HashMap<>();
        request.put("orderId", "temp_orderId");
        request.put("merchantId", "temp_merchantId");
        request.put("price", 4500);
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
        URI url = UriComponentsBuilder.fromUriString(PG_END_POINT).build().toUri();
        RequestPaymentResponse response = restTemplate.exchange(
                url, HttpMethod.POST, entity, RequestPaymentResponse.class
                ).getBody();

        // 응답 처리 (결과에 따른 로직 추가)
        System.out.println("PG 결제 응답 : " + response);

        return false;  // 실패 처리
    }
}
