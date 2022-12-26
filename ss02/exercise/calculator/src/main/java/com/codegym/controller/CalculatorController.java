package com.codegym.controller;

import com.codegym.service.CalculatorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller("/")
public class CalculatorController {
    private final CalculatorService calculatorService=new CalculatorService();
    @GetMapping("/")
    public String home(Model model) {
        return "/index";
    }

    @GetMapping("/cal")
    public String cal(Model model, @RequestParam(value = "a", required = false) String a, @RequestParam(value = "b", required = false) String b, @RequestParam(value = "cal", required = false) String cal) {
        switch (cal) {
            case "Addition":
                model.addAttribute("result", calculatorService.Addition(a,b));
                model.addAttribute("mes", cal);
                model.addAttribute("a",a);
                model.addAttribute("b",b);
                break;
            case "Subtraction":
                model.addAttribute("result", calculatorService.Subtraction(a,b));
                model.addAttribute("mes", cal);
                model.addAttribute("a",a);
                model.addAttribute("b",b);
                break;
            case "Multiplication":
                model.addAttribute("result", calculatorService.Multiplication(a,b));
                model.addAttribute("mes", cal);
                model.addAttribute("a",a);
                model.addAttribute("b",b);
                break;
            case "Division":
                if (Integer.parseInt(b) ==0){
                    model.addAttribute("result", "Error");
                    model.addAttribute("a",a);
                    model.addAttribute("b",b);
                }else{
                    model.addAttribute("result", calculatorService.Division(a,b));
                    model.addAttribute("mes", cal);
                    model.addAttribute("a",a);
                    model.addAttribute("b",b);
                }
                break;
        }

        return "/index";
    }
}
