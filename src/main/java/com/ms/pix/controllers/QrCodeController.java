package com.ms.pix.controllers;

import com.google.zxing.WriterException;
import com.ms.pix.dtos.PaymentAmountDto;
import com.ms.pix.services.PaymentService;
import com.ms.pix.services.QrCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class QrCodeController {

    @Autowired
    private QrCodeService qrCodeService;

    @Autowired
    private PaymentService paymentService;


    @PostMapping("/generateQrCode")
    public ResponseEntity<byte[]> generateQrCode(@RequestBody String amount) {
        try {
            byte[] qrCodeRequest = qrCodeService.generateQRCode(amount, 200, 200);
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=qrCode.png");
            headers.add(HttpHeaders.CONTENT_TYPE, "image/png");
            return ResponseEntity.ok().headers(headers).body(qrCodeRequest);
        } catch (WriterException | IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping("/receivePayment")
    public void receiveOrderPayment(@RequestBody PaymentAmountDto paymentAmountDto) {
        paymentService.paymentReceive(paymentAmountDto);
    }

}
