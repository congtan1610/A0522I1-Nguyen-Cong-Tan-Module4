package com.codegym.productmanagement.service;

import com.codegym.productmanagement.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface IProductService {
    Page<Product> findAllWithPage(PageRequest pageRequest);
    List<Product> findAll();
    Product findById(Integer id);
    void save(Product product);
    void delete(Integer id);
    Page<Product> findByName(String name,PageRequest pageRequest);
}
