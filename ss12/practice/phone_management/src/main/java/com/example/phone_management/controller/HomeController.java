package com.example.phone_management.controller;

import com.example.phone_management.model.Smartphone;
import com.example.phone_management.service.ISmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class HomeController {
@Autowired
private ISmartphoneService smartphoneService;
    @GetMapping("/")
    public String showIndex() {
        return "/list";
    }
    @GetMapping("/update/{id}")
    public String showUP(@PathVariable Long id, Model model) {
        model.addAttribute("smartphone",smartphoneService.findById(id));
        return "/update";
    }
}

