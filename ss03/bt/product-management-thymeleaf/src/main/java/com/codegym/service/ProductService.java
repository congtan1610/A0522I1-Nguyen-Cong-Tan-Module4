package com.codegym.service;

import com.codegym.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService implements IProductService{
    private static List<Product> list;
    static {
        list=new ArrayList<>();
        list.add(new Product("1","ga",120000,"ga con","tan"));
        list.add(new Product("2","vit",120000,"vit me","tan"));
        list.add(new Product("3","heo",120000,"heo con","tan"));
    }
    @Override
    public List<Product> findAll() {
        return list;
    }

    @Override
    public void addNew(Product product) {
        list.add(product);
    }

    @Override
    public Product findById(String id) {
        return list.get(list.indexOf(new Product(id)));
    }

    @Override
    public void update(Product product) {
        list.set(list.indexOf(new Product(product.getId())),product);
    }

    @Override
    public void delete(String id) {
        list.remove(list.indexOf(new Product(id)));
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> listFind=new ArrayList<>();
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
