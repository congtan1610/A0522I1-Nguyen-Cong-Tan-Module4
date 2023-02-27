package com.example.furama.controller;

import com.example.furama.model.Customer;
import com.example.furama.service.implement.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/customer")
public class CustomerRestController {
    @Autowired private CustomerServiceImpl customerService;

    @GetMapping("/find/{id}")
    public Optional<Customer> findById(@PathVariable Long id){
        return customerService.findById(id);
    }
    @GetMapping("/findAll")
    public Page<Customer> findAll(PageRequest page){
        return customerService.findAllWithPage(page);
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        customerService.delete(id);
    }
}
