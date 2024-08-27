package org.example.shoppingstorebackend;

import lombok.RequiredArgsConstructor;
import org.example.shoppingstorebackend.dao.ProductDao;
import org.example.shoppingstorebackend.service.ProductService;
import org.example.shoppingstorebackend.util.EntityUtil;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
@RequiredArgsConstructor
public class ShoppingStoreBackendApplication {
    private final ProductService productService;
    private final ProductDao productDao;

    @Bean @Profile("dev")
    public ApplicationRunner runner(){
        return args -> {
            productService.getAllProducts()
                    .stream()
                    .map(EntityUtil::toProduct)
                    .forEach(productDao::save);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(ShoppingStoreBackendApplication.class, args);
    }

}
