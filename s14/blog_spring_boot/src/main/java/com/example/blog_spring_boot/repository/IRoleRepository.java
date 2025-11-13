package com.example.blog_spring_boot.repository;

import com.example.blog_spring_boot.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleRepository extends JpaRepository<Role, Integer> {
    Role findByName(String name);
}