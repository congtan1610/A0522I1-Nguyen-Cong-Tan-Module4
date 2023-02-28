package com.example.furama.controller.facility;

import com.example.furama.model.facility.Facility;
import com.example.furama.service.facility.implement.FacilityServiceImpl;
import com.example.furama.service.facility.implement.FacilityTypeServiceImpl;
import com.example.furama.service.facility.implement.RentTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/facility")
public class FacilityController {
    @Autowired
    private FacilityServiceImpl facilityService;
    @Autowired
    private FacilityTypeServiceImpl facilityTypeService;
    @Autowired
    private RentTypeServiceImpl  rentTypeService;
    @GetMapping("")
    public String find(Model model, @RequestParam(value = "page", defaultValue = "0") Integer page, @RequestParam(value = "nameFacility", defaultValue = "") String name) {
        if (!name.isEmpty()) {
            Sort sort=Sort.by("id").ascending();
            model.addAttribute("facilitys", facilityService.findAllWithName(PageRequest.of(page, 2,sort), name));
            model.addAttribute("nameFacility", name);
        } else {
            Sort sort=Sort.by("id").ascending();
            model.addAttribute("facilitys", facilityService.findAllWithPage(PageRequest.of(page, 2,sort)));
        }
        return "ListFacility";
    }
    @GetMapping("/addFacility")
    public  String addFacility(Model  model){
        model.addAttribute("facility",new Facility());
        model.addAttribute("rentTypes",rentTypeService.findAll());
        model.addAttribute("facilityTypes",facilityTypeService.findAll());
        return "AddNewFacility";
    }
    @PostMapping("/addFacility")
    public  String saveFacility(@ModelAttribute Facility facility, RedirectAttributes redirectAttributes){
       facilityService.save(facility);
        redirectAttributes.addFlashAttribute("mess", "Add success");
        return "redirect:/facility";
    }
}
