package com.example.bai_tap_1_cau_hinh_thu_dien_tu.controller;

import com.example.bai_tap_1_cau_hinh_thu_dien_tu.entity.EmailSetting;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class SettingController {
    @GetMapping("/settings")
    public String showForm(Model model) {
        EmailSetting setting = new EmailSetting();
        setting.setLanguage("Vietnamese");
        setting.setPageSize(5);
        setting.setSpamsFilter(false);
        setting.setSignature("Huy\nDương Quốc Huy");
        model.addAttribute("emailSetting", setting);
        model.addAttribute("languages", List.of("English", "Vietnamese", "Japanese", "Chinese"));
        model.addAttribute("pageSizes", List.of(5, 10, 15, 25, 50, 100));
        return "setting";
    }

    @PostMapping("/update")
    public String updateSetting(@ModelAttribute("emailSetting") EmailSetting emailSetting, Model model) {
        model.addAttribute("updatedSetting", emailSetting);
        return "info";
    }

}
