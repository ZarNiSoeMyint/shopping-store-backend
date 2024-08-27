package org.example.shoppingstorebackend.controller;


import lombok.RequiredArgsConstructor;
import org.example.shoppingstorebackend.dto.ProductDto;
import org.example.shoppingstorebackend.service.ProductService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/store")
@CrossOrigin("*")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/products")
    public List<ProductDto> getAllProducts() {
        return productService.getProducts();
    }
}
