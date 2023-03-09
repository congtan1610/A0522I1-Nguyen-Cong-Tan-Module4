package com.example.thilai.controller;

import com.example.thilai.model.Build;
import com.example.thilai.model.BuildDto;
import com.example.thilai.service.implement.BuildServiceImpl;
import com.example.thilai.service.implement.ProductServiceImpl;
import com.example.thilai.service.implement.ProductTypeServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.Date;

@Controller
@RequestMapping("/build")
public class BuildController {
    @Autowired
    private BuildServiceImpl buildService;
    @Autowired
    private ProductTypeServiceImpl productTypeService;
    @Autowired
    private ProductServiceImpl productService;

    @GetMapping("")
    public String find(@RequestParam(value = "page", defaultValue = "0") Integer page, Model model, @RequestParam(value = "start", defaultValue = "") String start, @RequestParam(value = "end", defaultValue = "") String end,@RequestParam(value = "top",defaultValue = "")Integer top) {
        if (!(start.isEmpty()) && !(end.isEmpty())) {
            model.addAttribute("builds", buildService.findAllWithDayBuy(PageRequest.of(page, 5), Date.valueOf(start), Date.valueOf(end)));
            model.addAttribute("start",start);
            model.addAttribute("end",end);
        } else if(!(top==null)){
            model.addAttribute("builds",buildService.findAllWithTop(PageRequest.of(page,top)));
            model.addAttribute("top",top);
        }else
        {
            model.addAttribute("builds", buildService.findAll(PageRequest.of(page, 5)));
        }
        return "home";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("build", buildService.findById(id));
        model.addAttribute("types", productTypeService.findAll());
        model.addAttribute("products", productService.findAll());
        return "edit";
    }

    @PostMapping("/update")
    public String update(Model model, @Valid @ModelAttribute("build") BuildDto build, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        new BuildDto().validate(build, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("types", productTypeService.findAll());
            model.addAttribute("products", productService.findAll());
            model.addAttribute("build", build);
            return "edit";
        }
        Build build1 = new Build();
        build1.setId(build.getId());
        build1.setDayBuy(Date.valueOf(build.getDayBuy()));
        build1.setSize(build.getSize());
        build1.setProduct(build.getProduct());
        buildService.save(build1);
        redirectAttributes.addFlashAttribute("mess", "save success");
        return "redirect:/build";
    }
}
