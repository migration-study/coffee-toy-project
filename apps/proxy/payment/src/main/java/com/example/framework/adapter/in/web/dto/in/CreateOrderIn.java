package com.example.framework.adapter.in.web.dto.in;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@NoArgsConstructor
public class CreateOrderIn {
    private Long memberId;
    private String coffeeMenu;
    private BigDecimal coffeePrice;

    @Override
    public String toString() {
        return "CreateOrderIn{" +
                "memberId=" + memberId +
                ", coffeeMenu='" + coffeeMenu + '\'' +
                ", coffeePrice=" + coffeePrice +
                '}';
    }
}
