package com.example.quan_ly_shop.repository;

import com.example.quan_ly_shop.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product,Integer> {
}
