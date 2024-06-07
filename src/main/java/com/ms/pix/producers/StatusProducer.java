package com.ms.pix.producers;

import com.ms.pix.dtos.PaymentAmountDto;
import com.ms.pix.enums.PaymentStatus;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class StatusProducer {

    final RabbitTemplate rabbitTemplate;

    public StatusProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Value(value = "${broker.queue.api.name}")
    private String routingKey;

    public void publishMessageStatus(PaymentAmountDto paymentAmountDto) {
        paymentAmountDto.setPaymentStatus(PaymentStatus.COMPLETED);
        rabbitTemplate.convertAndSend("", routingKey, paymentAmountDto);
    }

}
