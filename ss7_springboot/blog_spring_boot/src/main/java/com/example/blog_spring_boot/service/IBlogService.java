package com.example.blog_spring_boot.service;

import com.example.blog_spring_boot.entity.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();

    void save(Blog blog);

    Blog findById(Integer id);
    void deleteById(Integer id);
    List<Blog> findByTitleContaining(String title);
}
