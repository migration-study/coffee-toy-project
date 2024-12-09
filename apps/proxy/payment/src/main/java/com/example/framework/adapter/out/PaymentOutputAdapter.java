package com.example.framework.adapter.out;

import com.example.domain.Payment;
import com.example.application.port.out.LoadOrderOutputPort;
import org.springframework.stereotype.Repository;

@Repository
public class PaymentOutputAdapter implements LoadOrderOutputPort {

    @Override
    public Payment loadPayment() {
        return null;
    }
}
