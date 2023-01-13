package com.codegym.productmanagement.repository;

import com.codegym.productmanagement.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface IProductRepository extends JpaRepository<Product,String> {
    @Query(value = "select * from Product",countQuery = "select * from Product", nativeQuery = true)
    Page<Product> findAllWithPage(Pageable pageable);
    @Query(value = "select * from Product where ten_san_pham like :name",countQuery = "select * from Product where ten_san_pham like :name", nativeQuery = true)
    Page<Product> findByNameWithPage(Pageable pageable, @Param("name")String name);
}
