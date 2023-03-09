package com.example.thilai.repository;

import com.example.thilai.model.TypeProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductTypeRepository extends JpaRepository<TypeProduct,Integer> {
}
