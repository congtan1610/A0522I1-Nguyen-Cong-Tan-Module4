package com.codegym.controller;

import com.codegym.model.BoxMail;
import com.codegym.service.BoxMailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.jws.WebParam;

@Controller("/")
public class BoxMailController {
    private BoxMailService boxMailService=new BoxMailService();
    @GetMapping("/")
    public ModelAndView home(Model model){
        ModelAndView modelAndView=new ModelAndView("index","boxMail",boxMailService.findAll());
        String[] languages={"English", "Vietnamese", "Japanese", "Chinese"};
        Integer[] sizes={5, 10, 15, 25, 50, 100};
        model.addAttribute("languages",languages);
        model.addAttribute("sizes",sizes);
        return modelAndView;
    }
    @PostMapping("/save")
    public String save(@ModelAttribute("boxMail") BoxMail boxMail, Model model, RedirectAttributes redirectAttributes){
        boxMailService.save(boxMail);
        String[] languages={"English", "Vietnamese", "Japanese", "Chinese"};
        Integer[] sizes={5, 10, 15, 25, 50, 100};
        model.addAttribute("languages",languages);
        model.addAttribute("sizes",sizes);
        model.addAttribute("boxMail",boxMailService.findAll());
        redirectAttributes.addFlashAttribute("msg","updated");
        return "redirect:/";
    }
}
