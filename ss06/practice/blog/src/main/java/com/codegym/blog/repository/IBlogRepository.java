package com.codegym.blog.repository;

import com.codegym.blog.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog,Integer> {
    List<Blog> findAllBy();
}
