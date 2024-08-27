package org.example.shoppingstorebackend.service;

import lombok.RequiredArgsConstructor;
import org.example.shoppingstorebackend.dao.ProductDao;
import org.example.shoppingstorebackend.dto.ProductDto;
import org.example.shoppingstorebackend.entity.Product;
import org.example.shoppingstorebackend.util.EntityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    private ProductDao productDao;

    private final RestClient restClient;
    public ProductService(){
        restClient = RestClient.builder()
                .baseUrl("http://localhost:3000").build();
    }

    public List<ProductDto> getProducts(){
        return productDao.findAll()
                .stream()
                .map(EntityUtil::toProductDto)
                .collect(Collectors.toUnmodifiableList());
    }

    public List<ProductDto> getAllProducts(){
        return  restClient.get()
                .uri("/products")
                .retrieve()
                .body(new ParameterizedTypeReference<List<ProductDto>>() {
                });

    }

}
