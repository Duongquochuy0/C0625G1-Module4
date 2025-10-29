package com.example.bai_tap_3_to_khai_y_te.controller;
import com.example.bai_tap_3_to_khai_y_te.entity.ToKhaiYTe;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class ToKhaiYTeController {
    private ToKhaiYTe toKhaiYTe = new ToKhaiYTe();

    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("toKhaiYTe", new ToKhaiYTe());
        return "form";
    }

    @PostMapping("/save")
    public String saveForm(@ModelAttribute("toKhaiYTe") ToKhaiYTe form, Model model) {
        this.toKhaiYTe = form;
        model.addAttribute("toKhaiYTe", form);
        return "result";
    }

    @GetMapping("/edit")
    public String editForm(Model model) {
        model.addAttribute("toKhaiYTe", toKhaiYTe);
        return "form";
    }
}
