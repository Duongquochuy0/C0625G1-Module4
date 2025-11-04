package com.example.blog_spring_boot.repository;

import com.example.blog_spring_boot.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    List<Blog> findByTitleContaining(String keyword);
}
