package com.example.blog_spring_boot.controller;

import com.example.blog_spring_boot.entity.AppUser;
import com.example.blog_spring_boot.service.AppUserService;
import com.example.blog_spring_boot.ultil.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private AppUserService appUserService;

    // Trang chủ / welcome
    @GetMapping({"/", "/welcome", "/home"})
    public String welcomePage(Model model, Principal principal) {
        String message;
        if (principal != null) {
            message = "Bạn đã đăng nhập vào hệ thống! Hãy trải nghiệm";
            model.addAttribute("username", principal.getName());
            List<String> rolesList = new ArrayList<>();
            Authentication authentication = (Authentication) principal;
            Collection<? extends GrantedAuthority> roles = authentication.getAuthorities();
            for (GrantedAuthority role : roles) {
                rolesList.add(role.getAuthority());
            }
            model.addAttribute("roles", rolesList);
        } else {
            message = "Xin chào các bạn đến với trang web của chúng tôi! Hãy đăng nhập để trải nghiệm tốt hơn";
        }
        model.addAttribute("message", message);
        return "home/home";
    }


    // Form login
    @GetMapping("/login")
    public String loginPage(Model model) {
        model.addAttribute("user", new AppUser());
        return "home/login";
    }


    // Logout thành công
    @GetMapping("/logoutSuccessful")
    public String logoutSuccessfulPage(Model model) {
        model.addAttribute("title", "Logout");
        return "home/logoutSuccessfulPage";
    }

    // Xem thông tin user
    @GetMapping("/userInfo")
    public String userInfo(Model model, Authentication authentication) {
        if (authentication != null) {
            String userName = authentication.getName();
            List<String> rolesList = new ArrayList<>();
            Collection<? extends GrantedAuthority> roles = authentication.getAuthorities();
            for (GrantedAuthority role : roles) {
                rolesList.add(role.getAuthority());
            }
            model.addAttribute("username", userName);
            model.addAttribute("roles", rolesList);
        }
        return "home/userInfoPage";
    }

    // Trang admin
    @GetMapping("/admin")
    public String adminPage(Model model, Authentication authentication) {
        if (authentication != null) {
            User loginedUser = (User) authentication.getPrincipal();
            String userInfo = WebUtils.toString(loginedUser);
            model.addAttribute("userInfo", userInfo);
        }
        return "home/adminPage";
    }

    // Trang 403
    @GetMapping("/403")
    public String accessDenied(Model model, Authentication authentication) {
        if (authentication != null) {
            User loginedUser = (User) authentication.getPrincipal();
            String userInfo = WebUtils.toString(loginedUser);
            model.addAttribute("userInfo", userInfo);

            String message = "Hi " + authentication.getName()
                    + "<br> Bạn không có quyền truy cập vào trang web này!";
            model.addAttribute("message", message);
        }
        return "403Page";
    }

    // =================== Thêm phần tạo user mới ===================
    // Hiển thị form tạo user
    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new AppUser());
        return "home/register"; // tạo file home/register.html
    }

    // Xử lý POST từ form tạo user
    @PostMapping("/register")
    public String processRegister(@ModelAttribute("user") AppUser user, Model model) {

        if (appUserService.getUserByUsername(user.getUserName()) != null) {
            model.addAttribute("errorMessage", "Tên tài khoản đã tồn tại!");
            return "home/register";
        }

        user.setEnabled(true);
        appUserService.saveUser(user);

        model.addAttribute("successMessage", "Đăng ký thành công! Hãy đăng nhập.");
        return "home/login";
    }


}
