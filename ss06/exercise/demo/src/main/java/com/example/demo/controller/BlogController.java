package com.example.demo.controller;

import com.example.demo.model.Blog;
import com.example.demo.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private BlogService blogService;
    @GetMapping("")
    public String find(Model model){
        model.addAttribute("blogs",blogService.findAll());
        return "list";
    }
    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("blog",new Blog());
        return "create";
    }
    @PostMapping("/create")
    public String save(RedirectAttributes redirectAttributes, @ModelAttribute( "blog")Blog blog){
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("mess","create success");
        return "redirect:/blog";
    }

    @GetMapping("/view/{id}")
    public String view(Model model,@PathVariable("id") Integer id){
        model.addAttribute("blog",blogService.findById(id));
        return "view";
    }
    @GetMapping("/update/{id}")
    public String update(Model model,@PathVariable("id") Integer id){
        model.addAttribute("blog",blogService.findById(id));
        return "update";
    }
    @PostMapping("/update")
    public String update(RedirectAttributes redirectAttributes, @ModelAttribute( "blog")Blog blog){
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("mess","update success");
        return "redirect:/blog";
    }
    @GetMapping("/delete/{id}")
    public String delete(Model model,@PathVariable("id") Integer id,RedirectAttributes redirectAttributes){
        blogService.delete(id);
        redirectAttributes.addFlashAttribute("mess","delete success");
        return "redirect:/blog";
    }
}

