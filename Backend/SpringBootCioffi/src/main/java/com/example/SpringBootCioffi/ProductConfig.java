package com.example.SpringBootCioffi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ProductConfig {
    @Bean
    CommandLineRunner commandLineRunner(ProductRepository productRepository){
        return args -> {
            Product product1 = new Product(1, "Sacred Cat", "White", 2.5f, 6);
            List<Product> list = List.of(product1);
            productRepository.saveAll(list);
        };
    }
}
