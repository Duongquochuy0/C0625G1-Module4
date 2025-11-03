package com.example.blog.repository;

import com.example.blog.entity.Blog;

import java.util.List;

public interface IBlogRepository {
    List<Blog> findAll();
    Blog findById(int id);
    boolean save(Blog blog);
    void deleteById(int id);
    List<Blog> searchByName(String keyword);
}
