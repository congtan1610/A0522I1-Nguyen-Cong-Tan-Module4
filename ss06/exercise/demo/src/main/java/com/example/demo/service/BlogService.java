package com.example.demo.service;

import com.example.demo.model.Blog;
import com.example.demo.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository iBlogRepository;

    @Override
    public Page<Blog> findAll(PageRequest pageRequest) {
        return iBlogRepository.findAllWithPage(pageRequest);
    }

    @Override
    public void save(Blog blog) {
        iBlogRepository.save(blog);
    }

    public Blog findById(Integer id) {
//        List<Blog> list=iBlogRepository.findAll();
//        return list.get(list.indexOf(new Blog(id)));
        return iBlogRepository.findById(id).orElse(new Blog());
    }

    @Override
    public void delete(Integer id) {
            iBlogRepository.deleteById(id);
    }
}
