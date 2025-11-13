package com.example.blog_spring_boot.service;
import com.example.blog_spring_boot.entity.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
    void save(Category category);
    Category findById(Integer id);
    void deleteById(Integer id);

}
