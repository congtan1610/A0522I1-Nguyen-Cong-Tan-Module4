package com.codegym.productmanagement.service;

import com.codegym.productmanagement.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    Product findById(String id);
    void save(Product product);
    void delete(String id);
    List<Product> findByName(String name);
}
