package com.example.blog_spring_boot.service;


import com.example.blog_spring_boot.entity.AppUser;
import com.example.blog_spring_boot.entity.UserRole;
import com.example.blog_spring_boot.repository.AppUserRepository;
import com.example.blog_spring_boot.repository.UserRoleResposiotry;
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

    private final AppUserRepository appUserRepository;

    private final UserRoleResposiotry userRoleResposiotry;

    public UserDetailsService(AppUserRepository appUserRepository, UserRoleResposiotry userRoleResposiotry) {
        this.appUserRepository = appUserRepository;
        this.userRoleResposiotry = userRoleResposiotry;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        AppUser appUser = this.appUserRepository.findByUserName(userName);
        if (appUser == null) {
            System.out.println("User not found! " + userName);
            throw new UsernameNotFoundException("User " + userName + " was not found in the database");
        }
        System.out.println("Found User: " + appUser);
        // lấy ra các role của user
        // [ROLE_USER, ROLE_ADMIN,..]
        List<UserRole> userRoles = this.userRoleResposiotry.findByAppUser(appUser);

        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
        if (userRoles != null) {
            for (UserRole userRole : userRoles) {
                // ROLE_USER, ROLE_ADMIN,..
                GrantedAuthority authority = new SimpleGrantedAuthority(userRole.getAppRole().getRoleName());
                grantList.add(authority);
            }
        }
        UserDetails userDetails = new User(appUser.getUserName(),
                appUser.getEncrytedPassword(), grantList);

        return userDetails;
    }

}

