package com.example.borrow_books.model;

import jakarta.persistence.*;

@Entity
public class Borrow {
    @Id
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(name="id_book")
    private Book book;

    public Borrow() {
    }

    public Borrow(Long id, String name, Book book) {
        this.id = id;
        this.name = name;
        this.book = book;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
