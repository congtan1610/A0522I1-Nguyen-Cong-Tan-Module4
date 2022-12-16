package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CerrencyController {
    @GetMapping("/")
    public String getHome(@RequestParam(value = "u", required = false) String usd, Model model) {
        model.addAttribute("u", usd);
        model.addAttribute("v", usd != null ? Integer.parseInt(usd) * 23000 : null);
        return "/index";
    }
}
