package com.example.quan_ly_may_tinh.controller;

import com.example.quan_ly_may_tinh.entity.Usage;
import com.example.quan_ly_may_tinh.service.IComputerService;
import com.example.quan_ly_may_tinh.service.IUsageService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/usage")
public class UsageController {

    private final IUsageService usageService;
    private final IComputerService computerService;

    public UsageController(IUsageService usageService, IComputerService computerService) {
        this.usageService = usageService;
        this.computerService = computerService;
    }
    @GetMapping
    public String listUsage(
            Model model,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Integer computerId,
            @RequestParam(required = false) Boolean using
    ) {
        Page<Usage> usagePage = usageService.search(name, computerId, using, PageRequest.of(page, size));
        model.addAttribute("usagePage", usagePage);
        model.addAttribute("currentPage", page);
        model.addAttribute("name", name);
        model.addAttribute("computerId", computerId);
        model.addAttribute("using", using);
        return "usage/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("usage", new Usage());
        model.addAttribute("availableComputers", computerService.findAll());
        return "usage/add";
    }


    @PostMapping("/add")
    public String addUsage(@ModelAttribute Usage usage, Model model) {
        try {
            usageService.create(usage);
            return "redirect:/usage";
        } catch (RuntimeException e) {
            model.addAttribute("errorMessage", e.getMessage());
            model.addAttribute("usage", usage);
            model.addAttribute("availableComputers", computerService.findAll());
            return "usage/add";
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteUsage(@PathVariable Integer id) {
        usageService.deleteById(id);
        return "redirect:/usage";
    }
    @GetMapping("/finish/{id}")
    public String finishUsage(@PathVariable Integer id) {
        usageService.finishUsage(id);
        return "redirect:/usage";
    }

}
