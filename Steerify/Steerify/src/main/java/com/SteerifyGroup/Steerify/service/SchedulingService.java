package com.SteerifyGroup.Steerify.service;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SchedulingService {
    private final String BASE_URL = "https://acuityscheduling.com/api/v1";
    private final String USER_ID = "YOUR_ACUITY_USER_ID";  // Replace with actual User ID
    private final String API_KEY = "YOUR_ACUITY_API_KEY";  // Replace with actual API Key

    public String getAvailableDates() {
        String url = BASE_URL + "/availability/dates";

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth(USER_ID, API_KEY); // Acuity uses Basic Authentication
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        return response.getBody();
    }
}

