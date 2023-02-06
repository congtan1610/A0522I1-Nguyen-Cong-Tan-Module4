package com.example.borrow_books.service.implement;

import com.example.borrow_books.model.Book;
import com.example.borrow_books.model.Borrow;
import com.example.borrow_books.repository.IBookRepository;
import com.example.borrow_books.repository.IBorrowRepository;
import com.example.borrow_books.service.IBorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowService implements IBorrowService {
    @Autowired
    private IBorrowRepository iBorrowRepository;

    @Autowired
    IBookRepository iBookRepository;

    @Override
    public void borrow(Integer id) throws Exception {
        long random = (long) Math.floor(((Math.random() * 89999) + 10000));
        Book book= iBookRepository.find(id);
        if (book.getRemaining()<=0){
                throw new Exception();
        }else{
            book.setRemaining(book.getRemaining()-1);
            iBookRepository.save(book);
            Borrow borrow=new Borrow(random,book.getName(),book);
            iBorrowRepository.save(borrow);
        }

    }

    @Override
    public void pay(Long id) {
        Borrow borrow=iBorrowRepository.findId(id);
        Book book=borrow.getBook();
        book.setRemaining(book.getRemaining()+1);
        iBookRepository.save(book);
        iBorrowRepository.deleteById(id);
    }

    @Override
    public List<Borrow> getList() {
        return iBorrowRepository.findAll();
    }
}
