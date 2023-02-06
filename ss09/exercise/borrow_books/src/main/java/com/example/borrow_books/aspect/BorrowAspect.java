package com.example.borrow_books.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BorrowAspect {
    @After("execution(* com.example.borrow_books.controller.BorrowController.*(..))")
    public void logAfterMethod(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        System.out.println(name);
    }
}
