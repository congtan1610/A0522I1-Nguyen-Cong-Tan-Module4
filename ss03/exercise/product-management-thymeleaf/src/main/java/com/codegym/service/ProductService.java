package com.codegym.service;

import com.codegym.model.Product;

import javax.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.List;

public class ProductService implements IProductService{
    private static List<Product> list=new ArrayList<>();
//    static {
//        list=new ArrayList<>();
//        list.add(new Product("1","ga",120000,"ga con","tan"));
//        list.add(new Product("2","vit",120000,"vit me","tan"));
//        list.add(new Product("3","heo",120000,"heo con","tan"));
//    }
    @Override
    public List<Product> findAll() {
        List<Product> list=BaseService.entityManager.createQuery("select p from Product p",Product.class).getResultList();
        return list;
    }

    @Override
    public void addNew(Product product) {
        EntityTransaction entityTransaction=BaseService.entityManager.getTransaction();
        entityTransaction.begin();
        BaseService.entityManager.persist(product);
        entityTransaction.commit();
    }

    @Override
    public Product findById(String id) {
        Product product= (Product) BaseService.entityManager.createQuery("select p from Product p where p.id = ?1" ,Product.class).setParameter(1,id).getSingleResult();
        return product;
    }

    @Override
    public void update(Product product) {
        EntityTransaction entityTransaction=BaseService.entityManager.getTransaction();
        entityTransaction.begin();
        BaseService.entityManager.merge(product);
        entityTransaction.commit();
        //list.set(list.indexOf(new Product(product.getId())),product);
    }

    @Override
    public void delete(String id) {
        EntityTransaction entityTransaction=BaseService.entityManager.getTransaction();
        entityTransaction.begin();
        BaseService.entityManager.remove(findById(id));
        entityTransaction.commit();
       // list.remove(list.indexOf(new Product(id)));
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> listFind=new ArrayList<>();
        List<Product> list=BaseService.entityManager.createQuery("select p from Product p",Product.class).getResultList();
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
