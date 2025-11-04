package com.example.blog_spring_boot.service;

import com.example.blog_spring_boot.entity.Category;
import com.example.blog_spring_boot.repository.ICategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryService implements ICategoryService{
    private final ICategoryRepository categoryRepository;
    public CategoryService(ICategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public void save(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public Category findById(Integer id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Integer id) {
        categoryRepository.deleteById(id);
    }
}
