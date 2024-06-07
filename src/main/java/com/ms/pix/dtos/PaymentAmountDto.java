package com.ms.pix.dtos;

import com.ms.pix.enums.PaymentStatus;
import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentAmountDto {

    private Long orderId;
    private BigDecimal amount;
    private PaymentStatus paymentStatus;
}
