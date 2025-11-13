package com.example.blog_spring_boot.repository;



import com.example.blog_spring_boot.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser,Long> {
    AppUser findByUserName(String username);

}
