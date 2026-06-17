package com.example.demo;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class MyController {

    // Hier binden wir dein neues ProductRepository ein
    private final ProductRepository productRepository;

    public MyController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // Holt die Daten jetzt direkt LIVE aus der PostgreSQL-Datenbank!
    @GetMapping("/api/products")
    public List<Product> getProducts() {
        return productRepository.findAll();
    }
}