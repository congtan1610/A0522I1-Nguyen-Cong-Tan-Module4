package com.example.borrow_books.service.implement;

import com.example.borrow_books.model.Book;
import com.example.borrow_books.repository.IBookRepository;
import com.example.borrow_books.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService {
    @Autowired
    private IBookRepository iBookRepository;

    @Override
    public List<Book> getList() {
        return iBookRepository.findAll();
    }
    public Book find(Integer id){
        return iBookRepository.find(id);
    }
}
