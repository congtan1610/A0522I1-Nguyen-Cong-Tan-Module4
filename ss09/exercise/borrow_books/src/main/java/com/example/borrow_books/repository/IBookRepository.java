package com.example.borrow_books.repository;

import com.example.borrow_books.model.Book;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookRepository extends JpaRepository<Book,Integer> {
   @Query(value = "select * from book where id like :id",nativeQuery = true)
   Book find(@Param("id") Integer id);
}
