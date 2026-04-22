package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class MyController {

    @GetMapping("/api/products")
    public List<Product> getProducts() {
        return List.of(
                new Product("1", "Laptop", 500.00),
                new Product("2", "Kopfhörer", 150.00)
        );
    }
}