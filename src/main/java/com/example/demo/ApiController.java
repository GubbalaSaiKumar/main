package com.example.demo;

import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping("/hello")
    public Map<String, String> hello() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Hello from DevOps Demo App!");
        response.put("timestamp", LocalDateTime.now().toString());
        return response;
    }

    @GetMapping("/status")
    public Map<String, Object> status() {
        Map<String, Object> response = new HashMap<>();
        response.put("status", "UP");
        response.put("application", "DevOps Demo Application");
        response.put("version", "1.0.0");
        response.put("timestamp", LocalDateTime.now().toString());
        return response;
    }

    @GetMapping("/greet/{name}")
    public Map<String, String> greet(@PathVariable String name) {
        Map<String, String> response = new HashMap<>();
        response.put("greeting", "Hello, " + name + "!");
        response.put("timestamp", LocalDateTime.now().toString());
        return response;
    }

    @PostMapping("/echo")
    public Map<String, Object> echo(@RequestBody Map<String, Object> payload) {
        Map<String, Object> response = new HashMap<>();
        response.put("received", payload);
        response.put("timestamp", LocalDateTime.now().toString());
        return response;
    }
}
