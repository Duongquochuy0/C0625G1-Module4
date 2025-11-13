package com.example.blog_spring_boot.service;

import com.example.blog_spring_boot.entity.AppUser;
import com.example.blog_spring_boot.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AppUserService {

    @Autowired
    private AppUserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    // Tạo user mới từ thông tin cơ bản
    public AppUser createUser(String username, String rawPassword, boolean enabled) {
        AppUser user = new AppUser();
        user.setUserName(username);
        user.setEncrytedPassword(passwordEncoder.encode(rawPassword));
        user.setEnabled(enabled);
        return userRepository.save(user);
    }

    // Phương thức lưu trực tiếp một AppUser đã tạo
    public AppUser saveUser(AppUser user) {
        // Giả sử password chưa mã hóa, cần check trước
        if (user.getEncrytedPassword() != null && !user.getEncrytedPassword().startsWith("$2a$")) {
            // BCrypt hash luôn bắt đầu bằng $2a$ hoặc $2b$, $2y$
            user.setEncrytedPassword(passwordEncoder.encode(user.getEncrytedPassword()));
        }
        return userRepository.save(user);
    }


    // Phương thức tạo và lưu user từ form (ví dụ có thêm email, role,...)
    public AppUser registerUser(String username, String rawPassword, boolean enabled) {
        AppUser user = new AppUser();
        user.setUserName(username);
        user.setEncrytedPassword(passwordEncoder.encode(rawPassword));
        user.setEnabled(enabled);
        return userRepository.save(user);
    }
    public AppUser getUserByUsername(String username) {
        return userRepository.findByUserName(username);
    }
}
