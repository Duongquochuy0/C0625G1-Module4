package com.example.bai_tap_2_calculator;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @GetMapping("/home")
    public String showForm() {
        return "home";
    }

    @GetMapping("/calculate")
    public String calculate(@RequestParam(value = "num1") double num1,
                            @RequestParam(value = "num2") double num2,
                            @RequestParam(value = "operator") String operator,
                            Model model) {
        double result = 0;
        String error = null;

        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                if (num2 == 0) {
                    error = "Không thể chia cho 0!";
                } else {
                    result = num1 / num2;
                }
                break;
            default:
                error = "Phép toán không hợp lệ!";
        }

        if (error != null) {
            model.addAttribute("error", error);
        } else {
            model.addAttribute("result", result);
        }

        model.addAttribute("num1", num1);
        model.addAttribute("num2", num2);
        model.addAttribute("operator", operator);

        return "home";
    }

}
