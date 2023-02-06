package com.example.borrow_books.controller;

import com.example.borrow_books.model.Book;
import com.example.borrow_books.service.implement.BookService;
import com.example.borrow_books.service.implement.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BorrowController {
    @Autowired
    private BookService bookService;
    @Autowired
    private BorrowService borrowService;
    @GetMapping("/home")
    public String home(Model model){
        model.addAttribute("list",bookService.getList());
        return "home";
    }
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") Integer id,Model model){
        model.addAttribute("book",bookService.find(id));
        return "detail";
    }
    @PostMapping("/borrow")
    public String borrow(Model model, @ModelAttribute("book")Book book) throws Exception {
        borrowService.borrow(book.getId());
        model.addAttribute("list",bookService.getList());
        return "/home";
    }
    @PostMapping("/pay")
    public String pay(Model model,@RequestParam("id") Long id){
        borrowService.pay(id);
        model.addAttribute("list",bookService.getList());
        return "/home";
    }
    @GetMapping("/history")
    public String history(Model model){
        model.addAttribute("list",borrowService.getList());
        return "history";
    }
    @ExceptionHandler(Exception.class)
    public String handleException() {
        return "error";
    }
}
