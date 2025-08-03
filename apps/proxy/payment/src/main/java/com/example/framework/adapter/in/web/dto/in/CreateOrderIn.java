package com.example.framework.adapter.in.web.dto.in;

import com.example.domain.entity.Payment;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@NoArgsConstructor
public class CreateOrderIn {
    private Long memberId;
    private String coffeeMenu;
    private BigDecimal coffeePrice;

    public CreateOrderIn(Long memberId, String coffeeMenu, BigDecimal coffeePrice) {
        this.memberId = memberId;
        this.coffeeMenu = coffeeMenu;
        this.coffeePrice = coffeePrice;
    }

    public Payment toPayment() {
        return Payment.createPayment(
                this.memberId,
                this.coffeeMenu,
                this.coffeePrice
        );
    }

    @Override
    public String toString() {
        return "CreateOrderIn{" +
                "memberId=" + memberId +
                ", coffeeMenu='" + coffeeMenu + '\'' +
                ", coffeePrice=" + coffeePrice +
                '}';
    }
}
