package com.ms.pix.controllers;

import com.ms.pix.dtos.PaymentAmountDto;
import com.ms.pix.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/receivePayment")
    public void receiveOrderPayment(@RequestBody PaymentAmountDto paymentAmountDto) {
        paymentService.paymentReceive(paymentAmountDto);
    }
}
