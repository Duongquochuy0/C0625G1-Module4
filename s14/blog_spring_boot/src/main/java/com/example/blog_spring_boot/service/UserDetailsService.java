package com.example.blog_spring_boot.service;

import com.example.blog_spring_boot.entity.AppUser;
import com.example.blog_spring_boot.entity.Role;
import com.example.blog_spring_boot.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private AppUserRepository appUserRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        AppUser appUser = this.appUserRepository.findByUserName(userName);

        if (appUser == null) {
            System.out.println("User not found! " + userName);
            throw new UsernameNotFoundException("User " + userName + " was not found in the database");
        }

        System.out.println("Found User: " + appUser);

        // Lấy roles từ AppUser
        List<GrantedAuthority> grantList = new ArrayList<>();

        if (appUser.getRoles() != null) {
            for (Role role : appUser.getRoles()) {
                // role.getName() là ví dụ "ROLE_USER", "ROLE_ADMIN"
                GrantedAuthority authority = new SimpleGrantedAuthority(role.getName());
                grantList.add(authority);
            }
        }

        return new User(
                appUser.getUserName(),
                appUser.getEncryptedPassword(),
                appUser.isEnabled(),
                true, true, true,
                grantList
        );
    }
}
