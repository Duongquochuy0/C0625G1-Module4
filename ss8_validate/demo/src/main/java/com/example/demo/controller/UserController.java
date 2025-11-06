package com.example.demo.controller;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import com.example.demo.service.IUserService;
import com.example.demo.validate.UserValidate;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/form")
public class UserController {

    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public String showForm(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "user/form";
    }

    @PostMapping("/add")
    public String result(@Valid @ModelAttribute UserDto userDto,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes) {
        UserValidate userValidate = new UserValidate();
        userValidate.validate(userDto, bindingResult);

        if (bindingResult.hasErrors()) {
            return "user/form";
        }
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        String mess = "Sign up success";
        try {
            userService.addUser(user);
        } catch (Exception e) {
            mess = "Sign up fail!";
        }
        redirectAttributes.addFlashAttribute("mess", mess);
        return "user/result";
    }

}
