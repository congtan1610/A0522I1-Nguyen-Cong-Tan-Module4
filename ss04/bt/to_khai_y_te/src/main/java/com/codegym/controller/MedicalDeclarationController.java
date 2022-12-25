package com.codegym.controller;

import com.codegym.service.MedicalDeclaration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;

@Controller("/")
public class MedicalDeclarationController {
    private final MedicalDeclaration medicalDeclaration=new MedicalDeclaration();
    private final ArrayList years=new ArrayList();
    private final String[] genders={"-chọn-","Nam","Nữ","Khác"};
    private final String[] vehicles={"Tàu bay","Tàu thuyền","Ô tô","Khác (ghi rõ)"};
    private final String[] nationals={"Việt Nam","Lào","Khác"};
    @GetMapping("/")
    public String home(Model model){
        for (int i=1900;i<=2022;i++){
            years.add(String.valueOf(i));
        }
        model.addAttribute("years",years);
        model.addAttribute("nationals",nationals);
        model.addAttribute("genders",genders);
        model.addAttribute("vehicles",vehicles);
        model.addAttribute("userInf",medicalDeclaration.findUserInf());
        model.addAttribute("symptom",medicalDeclaration.findSymptom());
        model.addAttribute("contact",medicalDeclaration.findContactAddress());
        return "index";
    }
}
