package com.codegym.service;

import com.codegym.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    void addNew(Product product);
    Product findById(String id);
    void update(Product product);
    void delete(String id);
    List<Product> findByName(String name);
}
