package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final ProductRepository productRepository;

    public DataInitializer(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Wir prüfen, ob die Datenbank noch leer ist
        if (productRepository.count() == 0) {
            System.out.println("--- Datenbank leer! Erstelle Testprodukte... ---");

            productRepository.save(new Product("Laptop", 799.99));
            productRepository.save(new Product("Kopfhörer", 149.50));
            productRepository.save(new Product("Gaming Maus", 59.90));

            System.out.println("--- Testprodukte erfolgreich in Render gespeichert! ---");
        } else {
            System.out.println("--- Datenbank enthält bereits Daten. Keine Testprodukte erstellt. ---");
        }
    }
}