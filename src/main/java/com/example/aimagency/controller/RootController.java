package com.example.aimagency.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class RootController {

    @GetMapping("/")
    public ResponseEntity<String> root() {
        return ResponseEntity.ok("AIM API");
    }
}
