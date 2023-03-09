package com.example.thi.controller;

import com.example.thi.model.Sale;
import com.example.thi.model.SaleDto;
import com.example.thi.service.implement.SaleServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.Date;

@Controller
@RequestMapping("/sale")
public class SaleController {
    @Autowired
    private SaleServiceImpl saleService;

    @GetMapping("")
    public String findAll(Model model, @RequestParam(value = "page", defaultValue = "0") Integer page, @RequestParam(value = "range", defaultValue = "") Integer range, @RequestParam(value = "start", defaultValue = "") String start, @RequestParam(value = "end", defaultValue = "") String end) {
        if (!(range == null)) {
            model.addAttribute("sales", saleService.findAllWithRange(PageRequest.of(page, 10), range));
            model.addAttribute("range", range);
        } else if (!(start.isEmpty())&&(range == null)&&(end.isEmpty())) {
            model.addAttribute("sales", saleService.findAllWithStart(PageRequest.of(page, 10), Date.valueOf(start)));
        }
        else if (!(end.isEmpty())&&(range == null)&&(start.isEmpty())) {
            model.addAttribute("sales", saleService.findAllWithEnd(PageRequest.of(page, 10), Date.valueOf(end)));
        }else {
            model.addAttribute("sales", saleService.findAllWithPage(PageRequest.of(page, 10)));
        }
        return "home";
    }

    @GetMapping("/add")
    public String addNew(Model model) {
        model.addAttribute("sale", new Sale());
        return "add";
    }

    @PostMapping("/save")
    public String save(Model model, @Valid @ModelAttribute("sale") SaleDto saleDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        new SaleDto().validate(saleDto, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("sale", saleDto);
            return "add";
        }
        Sale sale = new Sale();
        sale.setTitle(saleDto.getTitle());
        sale.setDateStart(Date.valueOf(saleDto.getDateStart()));
        sale.setDateEnd(Date.valueOf(saleDto.getDateEnd()));
        sale.setRangeSale(saleDto.getRangeSale());
        sale.setDetail(saleDto.getDetail());
        saleService.save(sale);
        redirectAttributes.addFlashAttribute("mess", "save success");
        return "redirect:/sale";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("sale", saleService.finById(id));
        return "edit";
    }

    @PostMapping("/update")
    public String update(Model model, @Valid @ModelAttribute("sale") SaleDto saleDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        new SaleDto().validate(saleDto, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("sale", saleDto);
            return "edit";
        }
        Sale sale = new Sale();
        sale.setId(saleDto.getId());
        sale.setTitle(saleDto.getTitle());
        sale.setDateStart(Date.valueOf(saleDto.getDateStart()));
        sale.setDateEnd(Date.valueOf(saleDto.getDateEnd()));
        sale.setRangeSale(saleDto.getRangeSale());
        sale.setDetail(saleDto.getDetail());
        saleService.save(sale);
        redirectAttributes.addFlashAttribute("mess", "save success");
        return "redirect:/sale";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, Model model, RedirectAttributes redirectAttributes) {
        model.addAttribute("sale", saleService.delete(id));
        redirectAttributes.addFlashAttribute("mess", "delete success");
        return "redirect:/sale";
    }
}
