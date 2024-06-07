package com.ms.pix.services;

import com.ms.pix.dtos.PaymentAmountDto;
import com.ms.pix.producers.StatusProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    StatusProducer statusProducer;

    public void paymentReceive(PaymentAmountDto paymentAmountDto) {
        statusProducer.publishMessageStatus(paymentAmountDto);
    }
}
