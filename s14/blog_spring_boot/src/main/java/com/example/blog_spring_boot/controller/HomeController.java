package com.example.blog_spring_boot.controller;

import com.example.blog_spring_boot.entity.Blog;
import com.example.blog_spring_boot.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/home")
public class HomeController {
    @Autowired
    private BlogService blogService;

    @GetMapping
    public String home(Model model) {
        List<Blog> blogs = blogService.findAll();
        model.addAttribute("blogs", blogs);
        return "home/home";
    }

    @GetMapping("/secure")
    public String securePage() {
        return "home/secure"; // Trang này yêu cầu login
    }

    @GetMapping("/redirect")
    public String redirectAfterLogin() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth != null && auth.isAuthenticated()
                && !"anonymousUser".equals(auth.getPrincipal())) {
            // Nếu đã login thì chuyển đến trang userInfo
            return "redirect:/userInfo";
        }

        // Nếu chưa login thì ở lại trang home
        return "redirect:/home";
    }
}
