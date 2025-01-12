package com.example.domain;

import com.example.domain.constant.PaymentStatus;
import com.example.domain.entity.Payment;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.UUID;

@DisplayName("결제 도메인 테스트")
public class PaymentTest {

    @Test
    void createPayment() {
        Payment 아메리카노 = 아메리카노_결제_생성();

        Assertions.assertThat(아메리카노.getOrderId()).isNotNull();
    }

    @Test
    void updateComplete() {
        Payment 아메리카노 = 아메리카노_결제_생성();
        아메리카노.updateComplete(UUID.randomUUID().toString());

        Assertions.assertThat(아메리카노.getStatus()).isEqualTo(PaymentStatus.PAID);
    }

    @Test
    void updateCancel() {
        Payment 아메리카노 = 아메리카노_결제_생성();
        아메리카노.updateComplete(UUID.randomUUID().toString());
        아메리카노.updateCancel();

        Assertions.assertThat(아메리카노.getStatus()).isEqualTo(PaymentStatus.CANCELED);
    }

    @Test
    @DisplayName("결제 완료 상태가 아닐 경우 결제 취소를 할 수 없다.")
    void updateCancel_exception() {
        Payment 아메리카노 = 아메리카노_결제_생성();
        Assertions.assertThatThrownBy(
                () -> 아메리카노.updateCancel()
        ).isExactlyInstanceOf(IllegalStateException.class);
    }

    private Payment 아메리카노_결제_생성() {
        return Payment.createPayment(
                1L, "아메리카노", BigDecimal.valueOf(4500)
        );
    }
}
