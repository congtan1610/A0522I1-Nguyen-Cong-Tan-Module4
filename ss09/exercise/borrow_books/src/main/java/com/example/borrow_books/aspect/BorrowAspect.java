package com.example.borrow_books.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BorrowAspect {
    private int visitedNumber =0;
    @After("execution(* com.example.borrow_books.controller.BorrowController.*(..))")
    public void logAfterMethod(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        System.out.println(name);
    }
    @Pointcut("execution(* com.example.borrow_books.service.IBorrowService.*(..))")
    public void afterVisitedController(){
    }

    @After("afterVisitedController()")
    public void throwAfterVisitedController(){
        visitedNumber++;
        System.out.println("Current visit count is "+ visitedNumber);
    }
}
