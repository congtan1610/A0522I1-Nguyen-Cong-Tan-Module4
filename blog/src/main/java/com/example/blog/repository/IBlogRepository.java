package com.example.blog.repository;

import com.example.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    @Query(value = "select * from Blog",countQuery = "select * from Blog ", nativeQuery = true)
    Page<Blog> findAllWithPage(Pageable pageable);

    Blog findByName( @Param("name") String name);

    Page<Blog> findAllByNameContaining(Pageable pageable,String name);
}
