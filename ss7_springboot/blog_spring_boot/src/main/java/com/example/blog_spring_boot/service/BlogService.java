package com.example.blog_spring_boot.service;

import com.example.blog_spring_boot.entity.Blog;
import com.example.blog_spring_boot.repository.IBlogRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BlogService implements IBlogService {
    private final IBlogRepository blogRepository;
    public BlogService(IBlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }
    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public Blog findById(Integer id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Integer id) {
        blogRepository.deleteById(id);
    }

    @Override
    public List<Blog> findByTitleContaining(String keyword) {
        return blogRepository.findByTitleContaining(keyword);
    }
}
