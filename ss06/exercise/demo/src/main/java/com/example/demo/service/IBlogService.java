package com.example.demo.service;

import com.example.demo.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface IBlogService {
    Page<Blog> findAll(PageRequest pageRequest);
    void save(Blog blog);
    void delete(Integer id);

}
