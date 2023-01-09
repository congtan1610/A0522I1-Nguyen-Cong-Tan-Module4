package com.codegym.blog.service;

import com.codegym.blog.model.Blog;
import com.codegym.blog.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BlogService implements IBlogService{
    @Autowired
    private IBlogRepository iBlogRepository;
    @Override
    public List<Blog> findAll() {
        return iBlogRepository.findAll();
    }

    @Override
    public void save(Blog blog) {

    }

    @Override
    public void delete(Integer id) {

    }
}
