package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller("/")
public class SandwichController {
    @GetMapping("/")
    public String home(Model model){
        return "/index";
    }
    @PostMapping("/save")
    public String save(@RequestParam(value = "lettuce",required = false) String lettuce, @RequestParam(value = "tomato",required = false) String tomato, @RequestParam(value = "mustard",required = false) String mustard, @RequestParam(value = "sprouts",required = false) String sprouts, Model  model){
        model.addAttribute("lettuce",lettuce);
        model.addAttribute("tomato",tomato);
        model.addAttribute("sprouts",sprouts);
        model.addAttribute("mustard",mustard);
        return "/index";
    }
}
