package com.SteerifyGroup.Steerify.controller;

import com.SteerifyGroup.Steerify.service.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/pay")
    public ResponseEntity<String> pay(@RequestParam String email, @RequestParam int amount) {
        String response = paymentService.initiatePayment(email, amount);
        return ResponseEntity.ok(response);
    }
}
