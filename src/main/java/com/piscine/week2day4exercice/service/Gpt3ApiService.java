package com.piscine.week2day4exercice.service;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class Gpt3ApiService {

    @Value("${openai.api.key}")
    private String apiKey;

    public String getResponse(String question) {
        String url = "https://api.openai.com/v1/engines/davinci-codex/completions";

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(apiKey);
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("prompt", question);
        requestMap.put("max_tokens", 100);
        requestMap.put("n", 1);
        requestMap.put("stop", "\n");

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(requestMap, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);

        return response.getBody();
    }
}

