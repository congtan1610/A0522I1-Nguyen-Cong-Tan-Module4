package com.codegym.productmanagement.controller;


import com.codegym.productmanagement.model.Product;
import com.codegym.productmanagement.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller("/")
public class ProductController {
    @Autowired
    private IProductService productService;
    @GetMapping("/home")
    public String home(Model model,@RequestParam(value = "page",defaultValue = "0")int page){
        Sort sort=Sort.by("ma_san_pham").descending();
        model.addAttribute("list",productService.findAllWithPage(PageRequest.of(page,2,sort)));
        return "home";
    }
    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("product",new Product());
        return "create";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute("product") Product product, RedirectAttributes redirectAttributes){
        productService.save(product);
        redirectAttributes.addFlashAttribute("success","Create product successfully");
        return "redirect:/home";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id,Model model){
        model.addAttribute("product",productService.findById(id));
        return "edit";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute("product")Product product,RedirectAttributes redirectAttributes){
        productService.save(product);
        redirectAttributes.addFlashAttribute("success","Update product successfully");
        return "redirect:/home";
    }
    @GetMapping("/view/{id}")
    public String view(@PathVariable("id") Integer id,Model model){
        model.addAttribute("product", productService.findById(id));
        return "view";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id,RedirectAttributes redirectAttributes){
        productService.delete(id);
        redirectAttributes.addFlashAttribute("success","Delete product successfully");
        return "redirect:/home";
    }
    @GetMapping("/find")
    public String findByname(Model model, @RequestParam(value = "name") String name,@RequestParam(value = "page",defaultValue = "0")int page){
        if (name.isEmpty()){
            model.addAttribute("list",productService.findAllWithPage(PageRequest.of(page,2)));
        }else{
            model.addAttribute("list",productService.findByName(name,PageRequest.of(page,8)));
        }
        return "home";
    }
}
