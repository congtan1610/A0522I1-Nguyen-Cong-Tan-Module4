package com.example.furama.service.customer;

import com.example.furama.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Optional;

public interface ICustomerService {
    Page<Customer> findAllWithPage(PageRequest pageRequest);
    Page<Customer> findAllWithName(PageRequest pageRequest,String name);
    void save(Customer customer);
    void delete(Long id);
    Optional<Customer> findById(Long id);
}
