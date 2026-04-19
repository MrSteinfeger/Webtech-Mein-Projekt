package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    @GetMapping("/api/test")
    public String getTest() {
        return "Milestone 1 erfolgreich!";
    }
}
