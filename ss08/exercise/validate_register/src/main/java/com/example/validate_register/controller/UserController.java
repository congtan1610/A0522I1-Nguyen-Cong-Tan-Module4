package com.example.validate_register.controller;

import com.example.validate_register.model.User;
import com.example.validate_register.service.IUserService;
import com.example.validate_register.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @Autowired
    private IUserService userService;
    @GetMapping("/index")
    public String home(Model model){
        return "index";
    }
    @PostMapping("/create")
    public String createStudent(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "index";
        }
       userService.save(user);
        return "result";
    }
}
