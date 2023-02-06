package com.example.validate_music.controller;

import com.example.validate_music.model.Song;
import com.example.validate_music.service.SongService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SongController {
    @Autowired
    private SongService songService;

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("songs", songService.getList());
        return "home";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("song", new Song());
        return "create";
    }

    @PostMapping("/save")
    public String save( @Valid @ModelAttribute("song") Song song, BindingResult bindingResult,Model model) {
        new Song().validate(song, bindingResult);
        if (bindingResult.hasErrors()) {
            return "create";
        }
        songService.save(song);
        model.addAttribute("songs", songService.getList());
        return "/home";
    }
    @GetMapping("/update/{id}")
    public String update(Model model, @PathVariable("id") Integer id) {
        model.addAttribute("song", songService.find(id));
        return "create";
    }

}
