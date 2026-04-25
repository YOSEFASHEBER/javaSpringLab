package com.ctbe.yosef.product_service.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.Map;

@RestController
public class HealthController {
    @GetMapping("/health")
    public ResponseEntity<Map<String, String>> health() {

        Map<String, String> response = new java.util.HashMap<>();
        response.put("service", "product-service");
        response.put("version", "1.0.0");
        response.put("status", "UP");
        response.put("timestamp", Instant.now().toString());

        return ResponseEntity.ok(response);
    }
}
