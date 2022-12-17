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
    public String save(@RequestParam(value = "l",required = false) String l, @RequestParam(value = "t",required = false) String t, @RequestParam(value = "m",required = false) String m, @RequestParam(value = "s",required = false) String s, Model  model){
        model.addAttribute("l",l);
        model.addAttribute("t",t);
        model.addAttribute("s",s);
        model.addAttribute("m",m);
        return "/index";
    }
}
