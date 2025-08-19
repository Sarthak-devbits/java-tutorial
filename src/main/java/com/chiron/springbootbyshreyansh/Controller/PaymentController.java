package com.chiron.springbootbyshreyansh.Controller;


import com.chiron.springbootbyshreyansh.DTO.PaymentRequest;
import com.chiron.springbootbyshreyansh.DTO.PaymentResponse;
import com.chiron.springbootbyshreyansh.Service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @GetMapping("/{id}")
    public PaymentResponse getPaymentById(@PathVariable Long id){
        PaymentRequest internalRequestObj= new PaymentRequest();
        internalRequestObj.setPaymentId(id);
        return paymentService.getPaymentById(internalRequestObj);
    }
}
