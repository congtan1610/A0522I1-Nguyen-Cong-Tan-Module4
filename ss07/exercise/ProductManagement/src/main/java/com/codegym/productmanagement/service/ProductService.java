package com.codegym.productmanagement.service;

import com.codegym.productmanagement.model.Product;
import com.codegym.productmanagement.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProductService implements IProductService{
    @Autowired
    private IProductRepository iProductRepository;

    @Override
    public List<Product> findAll() {
        return iProductRepository.findAll();
    }

    @Override
    public Product findById(String id) {
        return iProductRepository.findById(id).orElse(new Product());
    }

    @Override
    public void save(Product product) {
        iProductRepository.save(product);
    }

    @Override
    public void delete(String id) {
        iProductRepository.deleteById(id);
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> listFind=new ArrayList<>();
        List<Product> list=iProductRepository.findAll();
        name.toLowerCase();
        String tmp;
        for (Product x:list){
            tmp=x.getName().toLowerCase();
            for (int i=0;i<=tmp.length()-name.length();i++){
                if (name.equals(tmp.substring(i,i+name.length()))){
                    listFind.add(x);
                }
            }
        }
        return listFind;
    }
}
