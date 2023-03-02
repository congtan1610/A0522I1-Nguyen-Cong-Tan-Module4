package com.example.furama.controller.facility;

import com.example.furama.model.facility.Facility;
import com.example.furama.service.facility.implement.FacilityServiceImpl;
import com.example.furama.service.facility.implement.FacilityTypeServiceImpl;
import com.example.furama.service.facility.implement.RentTypeServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
    private RentTypeServiceImpl rentTypeService;

    @GetMapping("")
    public String find(Model model, @RequestParam(value = "page", defaultValue = "0") Integer page, @RequestParam(value = "nameFacility", defaultValue = "") String name, @RequestParam(value = "nameFacilityType", defaultValue = "") String nameType) {
        if (!name.isEmpty() &&(nameType.equals("All") ||nameType.isEmpty()) ) {
            Sort sort = Sort.by("id").ascending();
            model.addAttribute("facilitys", facilityService.findAllWithName(PageRequest.of(page, 2, sort), name));
            model.addAttribute("nameFacility", name);
            model.addAttribute("nameFacilityType", nameType);
        } else if (name.isEmpty() && !nameType.isEmpty() && !nameType.equals("All")) {
            Sort sort = Sort.by("id").ascending();
            model.addAttribute("facilitys", facilityService.findAllWithType(PageRequest.of(page, 2, sort), nameType));
            model.addAttribute("nameFacility", name);
            model.addAttribute("nameFacilityType", nameType);
        } else if (!name.isEmpty() && !nameType.isEmpty()) {
            Sort sort = Sort.by("id").ascending();
            model.addAttribute("facilitys", facilityService.findAllWithNameAndType(PageRequest.of(page, 2, sort), name, nameType));
            model.addAttribute("nameFacility", name);
            model.addAttribute("nameFacilityType", nameType);
        } else {
            Sort sort = Sort.by("id").ascending();
            model.addAttribute("facilitys", facilityService.findAllWithPage(PageRequest.of(page, 2, sort)));
            model.addAttribute("nameFacility", name);
            model.addAttribute("nameFacilityType", nameType);
        }
        return"ListFacility";
}

    @GetMapping("/addFacility")
    public String addFacility(Model model) {
        model.addAttribute("facility", new Facility());
        model.addAttribute("type", "add");
        model.addAttribute("rentTypes", rentTypeService.findAll());
        model.addAttribute("facilityTypes", facilityTypeService.findAll());
        return "AddNewFacility";
    }

    @PostMapping("/addFacility")
    public String saveFacility(@Valid @ModelAttribute Facility facility, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        new Facility().validate(facility,bindingResult);
        if (bindingResult.hasErrors()){
            model.addAttribute("facility", facility);
            model.addAttribute("type", facility.getFacilityType().getName());
            model.addAttribute("rentTypes", rentTypeService.findAll());
            model.addAttribute("facilityTypes", facilityTypeService.findAll());
            return "AddNewFacility";
        }
        facilityService.save(facility);
        redirectAttributes.addFlashAttribute("mess", "Add success");
        return "redirect:/facility";
    }
}
