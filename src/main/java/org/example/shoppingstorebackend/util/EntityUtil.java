package org.example.shoppingstorebackend.util;

import org.example.shoppingstorebackend.dto.ProductDto;
import org.example.shoppingstorebackend.entity.Product;
import org.springframework.beans.BeanUtils;

public class EntityUtil {

    public static ProductDto toProductDto(Product product) {
        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(product, productDto);
        return productDto;
    }
    public static Product toProduct(ProductDto productDto) {
        Product product = new Product();
        BeanUtils.copyProperties(productDto, product);
        return product;
    }
}
