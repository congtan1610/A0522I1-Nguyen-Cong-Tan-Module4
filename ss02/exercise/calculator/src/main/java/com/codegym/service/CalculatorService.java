package com.codegym.service;

public class CalculatorService implements ICalculatorService{
    @Override
    public Integer Addition(String a, String b) {
        return Integer.parseInt(a) + Integer.parseInt(b);
    }

    @Override
    public Integer Subtraction(String a, String b) {
        return Integer.parseInt(a) - Integer.parseInt(b);
    }

    @Override
    public Integer Multiplication(String a, String b) {
        return Integer.parseInt(a) * Integer.parseInt(b);
    }

    @Override
    public Integer Division(String a, String b) {
        return Integer.parseInt(a) / Integer.parseInt(b);
    }
}
