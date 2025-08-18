package com.chiron.springbootbyshreyansh.Service;

import com.chiron.springbootbyshreyansh.DTO.PaymentRequest;
import com.chiron.springbootbyshreyansh.DTO.PaymentResponse;
import com.chiron.springbootbyshreyansh.Entity.PaymentEntity;
import com.chiron.springbootbyshreyansh.Repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    PaymentRepository paymentRepository;

    public PaymentResponse getPaymentById(PaymentRequest internalRequestObj){
        PaymentEntity paymentModel= paymentRepository.getPaymemntByid(internalRequestObj);

        // map it to the response Obj
        PaymentResponse paymentResponse= mapModeltoResponseDTO(paymentModel);
        return paymentResponse;
    }

    private PaymentResponse mapModeltoResponseDTO(PaymentEntity paymentModel){
        PaymentResponse response= new PaymentResponse();
        response.setPaymentId(paymentModel.getId());
        response.setAmount(paymentModel.getPaymentAmount());
        response.setCurrency(paymentModel.getPaymentCurrency());
        return response;
    }
}
