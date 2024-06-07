package com.ms.pix.controllers;

import com.google.zxing.WriterException;
import com.ms.pix.services.QrCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/qrcode")
public class QrCodeController {

    @Autowired
    private QrCodeService qrCodeService;

    @PostMapping("/generateQrCode")
    public ResponseEntity<byte[]> generateQrCode(@RequestBody String amount) throws IOException, WriterException {
           return qrCodeService.generateQRCode(amount, 200, 200);
    }

}
