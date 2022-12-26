package com.codegym.controller;

import com.codegym.service.MedicalDeclarationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller("/")
public class MedicalDeclarationController {
    private final static MedicalDeclarationService medicalDeclaration=new MedicalDeclarationService();
    private final static ArrayList years=new ArrayList();
    private final static ArrayList months=new ArrayList();
    private final static ArrayList days=new ArrayList();
    private final static String[] genders={"-chọn-","Nam","Nữ","Khác"};
    private final static String[] citys={"-chọn-","Hà Nội","Đà Nẵng","Khác"};
    private final static String[] districts={"-chọn-","Hải Châu","Liên Chiểu","Khác"};
    private final static String[] warms={"-chọn-","Hòa Minh","Hòa Bắc","Khác"};
    private final static String[] vehicles={"Tàu bay","Tàu thuyền","Ô tô","Khác (ghi rõ)"};
    private final static String[] nationals={"Việt Nam","Lào","Khác"};
    static {
        for (int i=1900;i<=2022;i++){
            years.add(String.valueOf(i));
        }
        for (int i=1;i<=12;i++){
            months.add(String.valueOf(i));
        }
        for (int i=1;i<=31;i++){
            days.add(String.valueOf(i));
        }
    }

    @GetMapping("/")
    public String home(Model model){

        model.addAttribute("years",years);
        model.addAttribute("months",months);
        model.addAttribute("days",days);
        model.addAttribute("citys",citys);
        model.addAttribute("districts",districts);
        model.addAttribute("warms",warms);
        model.addAttribute("nationals",nationals);
        model.addAttribute("genders",genders);
        model.addAttribute("vehicles",vehicles);
        model.addAttribute("userInf",medicalDeclaration.findUserInf());
        model.addAttribute("symptom",medicalDeclaration.findSymptom());
        model.addAttribute("contact",medicalDeclaration.findContactAddress());
        return "index";
    }
}
