package com.example.furama.controller;


import com.example.furama.model.Customer;
import com.example.furama.service.implement.CustomerServiceImpl;
import com.example.furama.service.implement.CustomerTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerServiceImpl customerService;
    @Autowired
    private CustomerTypeServiceImpl customerTypeService;

    @GetMapping("")
    public String find(Model model, @RequestParam(value = "page", defaultValue = "0") Integer page, @RequestParam(value = "nameCustomer", defaultValue = "") String name) {
        if (!name.isEmpty()) {
            model.addAttribute("customers", customerService.findAllWithName(PageRequest.of(page, 1), name));
            model.addAttribute("nameCustomer", name);
        } else {
            model.addAttribute("customers", customerService.findAllWithPage(PageRequest.of(page, 1)));
        }
        return "ListCustomer";
    }

    @GetMapping("/addCustomer")
    public String add(Model model) {
        model.addAttribute("customer", new Customer());
        model.addAttribute("types", customerTypeService.findAll());
        return "AddNewCustomer";
    }

    @PostMapping("/addCustomer")
    public String save(RedirectAttributes redirectAttributes, @ModelAttribute("customer") Customer customer) {
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("mess", "Add success");
        return "redirect:/customer";
    }
    @GetMapping("/edit/{id}")
    public String update(@PathVariable Long id,Model model){
        model.addAttribute("customer",customerService.findById(id));
        model.addAttribute("types", customerTypeService.findAll());
        return "UpdateCustomer";
    }
}
