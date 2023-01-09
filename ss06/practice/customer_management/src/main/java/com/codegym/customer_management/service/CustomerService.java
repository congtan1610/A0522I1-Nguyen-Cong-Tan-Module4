package com.codegym.customer_management.service;

import com.codegym.customer_management.model.Customer;
import com.codegym.customer_management.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CustomerService /*implements ICustomerService*/ {
    @Autowired
    private ICustomerRepository iCustomerRepository;

//    @Override
    public List<Customer> findAll() {
        return iCustomerRepository.findAll();
    }

//    @Override
//    public Customer findById(Long id) {
//        return iCustomerRepository.findById(id);
//    }
//
//    @Override
//    public void save(Customer customer) {
//        customerRepository.save(customer);
//    }
//
//    @Override
//    public void remove(Long id) {
//        customerRepository.remove(id);
//    }
}
