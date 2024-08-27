package org.example.shoppingstorebackend.dao;

import org.example.shoppingstorebackend.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDao extends JpaRepository<Product, String> {
}
