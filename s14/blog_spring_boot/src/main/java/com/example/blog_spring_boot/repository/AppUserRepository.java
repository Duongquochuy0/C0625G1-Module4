package com.example.blog_spring_boot.repository;



import com.example.blog_spring_boot.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser,Integer> {
    AppUser findByUserName(String username);
}
