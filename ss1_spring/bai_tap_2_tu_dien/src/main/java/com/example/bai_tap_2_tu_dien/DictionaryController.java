package com.example.bai_tap_2_tu_dien;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class DictionaryController {
    private static final Map<String, String> dictionary = new HashMap<>();

    static {
        dictionary.put("hello", "xin chào");
        dictionary.put("book", "quyển sách");
        dictionary.put("car", "xe hơi");
        dictionary.put("computer", "máy tính");
        dictionary.put("dog", "con chó");
        dictionary.put("cat", "con mèo");
        dictionary.put("house", "ngôi nhà");
    }
    @GetMapping("/home")
    public String showForm() {
        return "home";
    }
    @PostMapping("/search")
    public String search(@RequestParam("word") String word, Model model) {
        String result = dictionary.get(word.toLowerCase());
        if (result != null) {
            model.addAttribute("word", word);
            model.addAttribute("result", result);
        } else {
            model.addAttribute("word", word);
            model.addAttribute("result", "Không tìm thấy từ này trong từ điển.");
        }
        return "result";
    }
}
