package com.chiron.springbootbyshreyansh.Repository;

import com.chiron.springbootbyshreyansh.DTO.PaymentRequest;
import com.chiron.springbootbyshreyansh.Entity.PaymentEntity;
import org.springframework.stereotype.Repository;

//PaymentEntity
@Repository
public class PaymentRepository {
    public PaymentEntity getPaymemntByid(PaymentRequest request){
        PaymentEntity result=executeQuery(request);
        return result;
    }

    private PaymentEntity executeQuery(PaymentRequest request){
        // connecting with db and get the data
        PaymentEntity payment= new PaymentEntity();
        payment.setId(request.getPaymentId());
        payment.setPaymentAmount(1000);
        payment.setPaymentCurrency("INR");
        payment.setUserEmail("sarthaknaik010@gmail.com");
        return payment;
    }
}
