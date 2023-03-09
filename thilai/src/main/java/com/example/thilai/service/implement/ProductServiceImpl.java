package com.example.thilai.service.implement;

import com.example.thilai.model.Product;
import com.example.thilai.repository.IProductRepository;
import com.example.thilai.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    private IProductRepository iProductRepository;
     public List<Product> findAll(){
         return iProductRepository.findAll();
     }
}
