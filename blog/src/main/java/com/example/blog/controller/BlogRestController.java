package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.model.Category;
import com.example.blog.service.IBlogService;
import com.example.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

