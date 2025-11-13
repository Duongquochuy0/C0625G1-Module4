package com.example.blog_spring_boot.controller;

import com.example.blog_spring_boot.entity.AppUser;
import com.example.blog_spring_boot.repository.AppUserRepository;
import com.example.blog_spring_boot.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AuthController {

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);  // Thêm logger

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") AppUser user, Model model) {
        logger.info("Bắt đầu đăng ký user với username: {}", user.getUserName());
        String error = userService.registerUser(user);
        if (error != null) {
            logger.error("Lỗi đăng ký user: {}", error);
            model.addAttribute("error", error);
            model.addAttribute("showRegisterTab", true); // 🔹 thêm dòng này
            return "home/login"; // vẫn ở trang đăng ký nếu lỗi
        }

        logger.info("Đăng ký thành công cho username: {}", user.getUserName());
        return "redirect:/login?success"; // redirect sang login nếu thành công
    }


    @GetMapping("/login")
    public String loginPage(@RequestParam(value = "error", required = false) String error,
                            Model model) {
        SecurityContextHolder.clearContext();
        if (error != null) {
            logger.warn("Lỗi đăng nhập: {}", "Tên đăng nhập hoặc mật khẩu không đúng!");  // Log lỗi login
            model.addAttribute("loginError", "Tên đăng nhập hoặc mật khẩu không đúng!");
        }
        model.addAttribute("user", new AppUser()); // để form đăng ký hoạt động
        logger.debug("Truy cập trang login");  // Log truy cập trang
        return "home/login"; // tên file Thymeleaf
    }
}