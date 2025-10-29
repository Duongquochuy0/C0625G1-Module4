package com.example.bai_tap_1_cau_hinh_thu_dien_tu.controller;

import com.example.bai_tap_1_cau_hinh_thu_dien_tu.entity.EmailSetting;
import com.example.bai_tap_1_cau_hinh_thu_dien_tu.service.IEmailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/setting")
public class EmailController {
    private final IEmailService emailService;

    public EmailController(IEmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping
    public String showForm(Model model) {
        model.addAttribute("setting", emailService.getSetting());
        model.addAttribute("languages", new String[]{"English", "Vietnamese", "Japanese", "Chinese"});
        model.addAttribute("pageSizes", new int[]{5, 10, 15, 25, 50, 100});
        return "setting";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("setting") EmailSetting updated, Model model) {
        emailService.update(updated);
        model.addAttribute("setting", emailService.getSetting());
        return "info";
    }
}
