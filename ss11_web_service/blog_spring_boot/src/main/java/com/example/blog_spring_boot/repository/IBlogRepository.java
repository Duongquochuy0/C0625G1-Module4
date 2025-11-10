package com.example.blog_spring_boot.repository;

import com.example.blog_spring_boot.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    List<Blog> findByTitleContaining(String keyword);

    List<Blog> findByCategoryId(Integer categoryId);

    @Query("SELECT b FROM Blog b WHERE " +
            "(:title IS NULL OR LOWER(b.title) LIKE LOWER(CONCAT('%', :title, '%'))) AND " +
            "(:categoryId IS NULL OR b.category.id = :categoryId)")
    Page<Blog> searchByTitleAndCategory(@Param("title") String title,
                                        @Param("categoryId") Integer categoryId,
                                        Pageable pageable);
}
