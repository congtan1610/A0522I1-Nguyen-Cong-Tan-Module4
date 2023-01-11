package com.example.demo.service;

import com.example.demo.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();
    void save(Blog blog);
    void delete(Integer id);

}
