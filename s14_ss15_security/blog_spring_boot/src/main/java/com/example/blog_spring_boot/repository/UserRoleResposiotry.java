package com.example.blog_spring_boot.repository;



import com.example.blog_spring_boot.entity.AppUser;
import com.example.blog_spring_boot.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoleResposiotry extends JpaRepository<UserRole,Long> {
    List<UserRole> findByAppUser(AppUser appUser);
}
