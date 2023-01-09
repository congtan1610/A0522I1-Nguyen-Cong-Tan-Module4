package com.codegym.customer_management.controller;

import com.codegym.customer_management.model.Customer;
import com.codegym.customer_management.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CustomerController {

    private CustomerService customerService=new CustomerService();

//    @GetMapping("/create-customer")
//    public ModelAndView showCreateForm() {
//        ModelAndView modelAndView = new ModelAndView("create");
//        modelAndView.addObject("customer", new Customer());
//        return modelAndView;
//    }
//
//    @PostMapping("/create-customer")
//    public ModelAndView saveCustomer(@ModelAttribute("customer") Customer customer) {
//        customerService.save(customer);
//        ModelAndView modelAndView = new ModelAndView("create");
//        modelAndView.addObject("customer", new Customer());
//        modelAndView.addObject("message", "New customer created successfully");
//        return modelAndView;
//    }
    @GetMapping("/customers")
    public ModelAndView listCustomers() {
        List<Customer> customers = customerService.findAll();
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }
}
