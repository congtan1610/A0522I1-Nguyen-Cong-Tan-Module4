package com.codegym.controller;

import com.codegym.model.Entity;
import com.codegym.model.EntityForm;
import com.codegym.service.EntityService;
import com.codegym.service.IEntityService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class EntityController {
    private final IEntityService entityService=new EntityService();

    @Value("${file-upload}")
    private String fileUpload;

    @GetMapping("")
    public String index(Model model) {
        List<Entity> entityList = entityService.findAll();
        model.addAttribute("entityList", entityList);
        return "/index";
    }
    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("entityForm", new EntityForm());
        return modelAndView;
    }
    @PostMapping("/save")
    public ModelAndView saveEntity(@ModelAttribute EntityForm entityForm) {
        MultipartFile multipartFile = entityForm.getFilePath();
        String fileName = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(entityForm.getFilePath().getBytes(), new File(fileUpload + fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Entity entity1 = new Entity(entityForm.getId(), entityForm.getName(),
                entityForm.getArtist(),entityForm.getType(), fileName);
        entityService.add(entity1);
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("entityForm", entityForm);
        modelAndView.addObject("message", "Created new Entity successfully !");
        return modelAndView;
    }
}
