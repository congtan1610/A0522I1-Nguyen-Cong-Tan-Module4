package com.codegym.blog.controller;

import com.codegym.blog.service.BlogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BlogController {
    private BlogService blogService=new BlogService();
    @GetMapping("")
    public String findAll(Model model){
        model.addAttribute("blogs",blogService.findAll());
        return "list";
    }
}
