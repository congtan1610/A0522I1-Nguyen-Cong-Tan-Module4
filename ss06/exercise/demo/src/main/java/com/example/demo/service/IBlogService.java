package com.example.demo.service;

import com.example.demo.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface IBlogService {
    Page<Blog> findAllWithPage(PageRequest pageRequest);
    void save(Blog blog);
    void delete(Integer id);
    List<Blog> findAll();
    List<Blog> findAllByIdCategory(Integer id);
    Blog findById(Integer id);
    Blog findByName(String name);
}
