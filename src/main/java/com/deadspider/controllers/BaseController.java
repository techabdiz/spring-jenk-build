package com.deadspider.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.Map;

@RestController
public class BaseController {

    @GetMapping("hello")
    public ResponseEntity<Map<String, String>> helloWorld() {
        return ResponseEntity.ok(Map.of("message", "Hello, World!"));
    }
}
