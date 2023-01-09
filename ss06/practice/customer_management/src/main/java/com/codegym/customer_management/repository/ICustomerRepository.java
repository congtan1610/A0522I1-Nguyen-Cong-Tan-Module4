package com.codegym.customer_management.repository;

import com.codegym.customer_management.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface ICustomerRepository extends JpaRepository<Customer,Long> {
    List<Customer> findAllBy();
    List<Customer> getAllBy();
}
