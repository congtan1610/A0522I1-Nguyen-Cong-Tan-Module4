package com.example.borrow_books.service;

import com.example.borrow_books.model.Borrow;

import java.util.List;

public interface IBorrowService {
    void borrow(Integer id) throws Exception;
    void pay(Long id);
    List<Borrow> getList();
}
