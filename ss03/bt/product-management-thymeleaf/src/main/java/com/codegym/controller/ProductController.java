package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller("/")
public class ProductController {
    private final ProductService productService=new ProductService();
    @GetMapping("/home")
    public String home(Model model){
        model.addAttribute("list",productService.findAll());
        return "home";
    }
    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("product",new Product());
        return "create";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute("product") Product product, RedirectAttributes redirectAttributes){
        productService.addNew(product);
        redirectAttributes.addFlashAttribute("success","Create product successfully");
        return "redirect:/home";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id,Model model){
        model.addAttribute("product",productService.findById(id));
        return "edit";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute("product")Product product,RedirectAttributes redirectAttributes){
        productService.update(product);
        redirectAttributes.addFlashAttribute("success","Update product successfully");
        return "redirect:/home";
    }
    @GetMapping("/view/{id}")
    public String view(@PathVariable("id") String id,Model model){
        model.addAttribute("product", productService.findById(id));
        return "view";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id,RedirectAttributes redirectAttributes){
        productService.delete(id);
        redirectAttributes.addFlashAttribute("success","Delete product successfully");
        return "redirect:/home";
    }
    @GetMapping("/find")
    public String findByname(Model model, @RequestParam("name") String name){
        if (name.isEmpty()){
            model.addAttribute("list",productService.findAll());
        }else{
            model.addAttribute("list",productService.findByName(name));
        }
        return "home";
    }
}
