package com.example.application.service;

import com.example.application.port.in.QueryCoffeeOrderInputPort;
import org.springframework.stereotype.Service;

@Service
public class QueryCoffeeOrderUseCase implements QueryCoffeeOrderInputPort {

    @Override
    public void queryOrder() {
        // PG사 API를 통해 id에 해당하는 결제 정보를 반환
    }
}
