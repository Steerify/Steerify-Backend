package com.SteerifyGroup.Steerify.service;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService {
    private final String paystackUrl = "https://api.paystack.co/transaction/initialize";
    private final String secretKey = "Bearer sk_test_b8b6d56e1f0e845d9fbadb024f838520792bf21c";

    public String initiatePayment(String email, int amount) {
        RestTemplate restTemplate = new RestTemplate();

        // Request Headers
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", secretKey);
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Request Body
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("email", email);
        requestBody.put("amount", amount * 100); // Convert to kobo
        requestBody.put("currency", "NGN");

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(requestBody, headers);

        // Send request to Paystack
        ResponseEntity<String> response = restTemplate.exchange(paystackUrl, HttpMethod.POST, entity, String.class);

        return response.getBody();
    }
}
