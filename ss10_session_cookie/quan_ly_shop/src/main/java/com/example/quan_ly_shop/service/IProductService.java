package com.example.quan_ly_shop.service;

import com.example.quan_ly_shop.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {
    Page<Product> findAll(Pageable pageable);
    Product findById(Integer id);
}
