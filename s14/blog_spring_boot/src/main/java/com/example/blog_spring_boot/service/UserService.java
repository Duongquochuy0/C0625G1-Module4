package com.example.blog_spring_boot.service;

import com.example.blog_spring_boot.entity.AppUser;
import com.example.blog_spring_boot.entity.Role;
import com.example.blog_spring_boot.repository.AppUserRepository;
import com.example.blog_spring_boot.repository.IRoleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    private final AppUserRepository appUserRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    private final IRoleRepository roleRepository;

    public UserService(AppUserRepository appUserRepository,
                       BCryptPasswordEncoder passwordEncoder,
                       AuthenticationManager authenticationManager,
                       IRoleRepository roleRepository) {
        this.appUserRepository = appUserRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.roleRepository = roleRepository;
    }

    public String registerUser(AppUser user) {
        try {
            logger.info("Bắt đầu đăng ký user: {}", user.getUserName());
            if (appUserRepository.findByUserName(user.getUserName()) != null) {
                logger.warn("Username đã tồn tại: {}", user.getUserName());
                return "Tên đăng nhập đã tồn tại!";
            }

            String rawPassword = user.getEncryptedPassword();
            user.setEncryptedPassword(passwordEncoder.encode(rawPassword));
            user.setEnabled(true);

            Role userRole = roleRepository.findByName("ROLE_USER");
            if (userRole == null) {
                logger.info("Tạo role mới: ROLE_USER");
                userRole = new Role("ROLE_USER");
                roleRepository.save(userRole);
            } else {
                logger.info("Sử dụng role tồn tại: ROLE_USER");
            }
            user.getRoles().add(userRole);

            appUserRepository.save(user);
            logger.info("Đã lưu user thành công: {}", user.getUserName());

//            autoLogin(user.getUserName(), rawPassword);
//            logger.info("Auto-login thành công cho: {}", user.getUserName());

            return null;
        } catch (Exception e) {
            logger.error("Lỗi khi đăng ký user {}: {}", user.getUserName(), e.getMessage(), e);
            return "Lỗi hệ thống khi đăng ký: " + e.getMessage();
        }
    }
    public void autoLogin(String username, String password) {
        UsernamePasswordAuthenticationToken authToken =
                new UsernamePasswordAuthenticationToken(username, password);
        Authentication auth = authenticationManager.authenticate(authToken);
        SecurityContextHolder.getContext().setAuthentication(auth);
    }
}
