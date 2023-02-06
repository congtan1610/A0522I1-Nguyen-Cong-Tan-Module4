package com.example.borrow_books.repository;

import com.example.borrow_books.model.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IBorrowRepository extends JpaRepository<Borrow,Long> {
    @Query(value = "select * from borrow where id like :id",nativeQuery = true)
    Borrow findId(@Param("id") Long id);
}
