package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.service.BlogService;
import com.example.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private BlogService blogService;
    @Autowired
    private ICategoryService icategoryService;

    @GetMapping("")
    public String find(Model model, @RequestParam(value = "page", defaultValue = "0") int page, @RequestParam (value = "nameBlog",defaultValue = "") String name) {
        if (!name.isEmpty()) {
            model.addAttribute("blogs", blogService.findAllByName(PageRequest.of(page, 1), name));
            model.addAttribute("nameBlog",name);
        } else {
            model.addAttribute("blogs", blogService.findAllWithPage(PageRequest.of(page, 2)));
        }
        return "list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("categoryList", icategoryService.findAll());
        return "create";
    }

    @PostMapping("/create")
    public String save(RedirectAttributes redirectAttributes, @ModelAttribute("blog") Blog blog) {
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("mess", "create success");
        return "redirect:/blog";
    }

    @GetMapping("/view/{id}")
    public String view(Model model, @PathVariable("id") Integer id) {
        Blog blog = blogService.findById(id);
        model.addAttribute("blog", blog);
        model.addAttribute("category", blog.getCategory().getNameCategory());
        return "view";
    }

    @GetMapping("/update/{id}")
    public String update(Model model, @PathVariable("id") Integer id){
        model.addAttribute("blog", blogService.findById(id));
        model.addAttribute("categoryList", icategoryService.findAll());
        return "update";
    }

    @PostMapping("/update")
    public String update(RedirectAttributes redirectAttributes, @ModelAttribute("blog") Blog blog) {
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("mess", "update success");
        return "redirect:/blog?nameBlog="+blog.getName();
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
        blogService.delete(id);
        redirectAttributes.addFlashAttribute("mess", "delete success");
        return "redirect:/blog";
    }
}