package com.example.furama.repository;

import com.example.furama.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer,Long> {
    @Query(value = "select * from Customer ",countQuery = "select * from Customer",nativeQuery = true)
    Page<Customer> findAllWithPage(Pageable pageable);
    Page<Customer> findAllByNameContaining(Pageable  pageable,String name);
}
