package com.example.framework.adapter.out.network.response;

import lombok.Data;

@Data
public class GraphQLPaymentResponse {
    private RequestPaymentResponse data;

    @Data
    public static class RequestPaymentResponse {
        private RequestPaymentResponseData createPayment;

        @Override
        public String toString() {
            return "RequestPaymentResponse{" +
                    "createPayment=" + createPayment +
                    '}';
        }
    }

    @Data
    public static class RequestPaymentResponseData {
        private String paymentId;
        private String result;

        @Override
        public String toString() {
            return "RequestPaymentResponse{" +
                    "paymentId=" + paymentId +
                    ", result='" + result + '\'' +
                    '}';
        }
    }
}
