package com.example.framework.adapter.out.network.response;

import lombok.Data;

@Data
public class GraphQLCancelResponse {
    private CancelResponse data;

    @Override
    public String toString() {
        return "GraphQLCancelResponse{" +
                "data=" + data +
                '}';
    }

    @Data
    public static class CancelResponse {
        private CancelResponseData cancelPayment;

        @Override
        public String toString() {
            return "CancelResponse{" +
                    "cancelPayment=" + cancelPayment +
                    '}';
        }
    }

    @Data
    public static class CancelResponseData {
        private String orderId;
        private String result;

        public CancelResponseData(String orderId, String result) {
            this.orderId = orderId;
            this.result = result;
        }

        @Override
        public String toString() {
            return "CancelResponseData{" +
                    "orderId='" + orderId + '\'' +
                    ", result='" + result + '\'' +
                    '}';
        }
    }
}
