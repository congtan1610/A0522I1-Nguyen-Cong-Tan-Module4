package com.example.demo.controller;

import com.example.demo.model.Blog;
import com.example.demo.model.Category;
import com.example.demo.service.IBlogService;
import com.example.demo.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("api/blog")
public class BlogRestController {
    @Autowired
    private ICategoryService iCategoryService;
    @Autowired
    private IBlogService iBlogService;

    @GetMapping("/listCategory")
    public List<Category> getListCategory() {
        return iCategoryService.findAll();
    }

    @GetMapping("/listBlog")
    public List<Blog> getListBlog() {
        return iBlogService.findAll();
    }

    @GetMapping("/listBlog/{idCategory}")
    public List<Blog> getListBlogByIdCategory(@PathVariable("idCategory") Integer id) {
        return iBlogService.findAllByIdCategory(id);
    }

    @GetMapping("/{id}")
    public Blog detail(@PathVariable("id") Integer id) {
        return iBlogService.findById(id);
    }

    @GetMapping("/find/{name}")
    public Blog detailWithName(@PathVariable("name") String name) {
        return iBlogService.findByName(name);
    }

}

