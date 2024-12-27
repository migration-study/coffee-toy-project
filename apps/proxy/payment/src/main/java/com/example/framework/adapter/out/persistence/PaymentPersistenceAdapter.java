package com.example.framework.adapter.out.persistence;

import com.example.application.port.out.SaveOrderOutputPort;
import com.example.domain.entity.Payment;
import com.example.application.port.out.LoadCoffeeOrderOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Repository
@RequiredArgsConstructor
public class PaymentPersistenceAdapter implements
        SaveOrderOutputPort,
        LoadCoffeeOrderOutputPort {
    private final PaymentPersistenceMapper mapper;
    private final PaymentJpaRepository paymentJpaRepository;

    @Override
    public Payment loadPayment(String orderId) {
        PaymentEntity paymentEntity = paymentJpaRepository.findByOrderId(orderId)
                .orElseThrow(NoSuchElementException::new);
        System.out.println("paymentEntity orderId : " + paymentEntity.getOrderId());
        return mapper.entityToDomain(paymentEntity);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void save(Payment payment) {
        PaymentEntity paymentEntity = mapper.domainToEntity(payment);
        paymentJpaRepository.save(paymentEntity);
    }

    /**
     * ToDO
     * - 아래 코드 QueryDSL로 처리 필요
     */
//    @Override
//    @Transactional(propagation = Propagation.MANDATORY)
//    public void saveForCancel(Payment payment) {
//        PaymentEntity paymentEntity = paymentJpaRepository.findByOrderId(payment.getId())
//                .orElseThrow(NoSuchElementException::new);
//        paymentEntity.completeCancel(payment.getStatus().toString());
//        paymentJpaRepository.save(paymentEntity);
//    }
}
