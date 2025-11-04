package com.example.blog_spring_boot.service;

import com.example.blog_spring_boot.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();

    void save(Blog blog);

    Blog findById(Integer id);
    void deleteById(Integer id);
    List<Blog> findByCategoryId(Integer categoryId);
    List<Blog> findByTitleContaining(String keyword);
    Page<Blog> searchByTitleAndCategory(String title, Integer categoryId, Pageable pageable);
}
