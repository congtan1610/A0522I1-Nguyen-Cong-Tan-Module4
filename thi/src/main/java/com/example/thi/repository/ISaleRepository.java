package com.example.thi.repository;

import com.example.thi.model.Sale;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;

@Repository
@Transactional
public interface ISaleRepository extends JpaRepository<Sale,Integer> {
    @Query(value = "select * from Sale",countQuery = "select * from Sale",nativeQuery = true)
    Page<Sale> findAllWithPage(Pageable pageable);
    Page<Sale> findAllByRangeSale(Pageable pageable,Integer range);
    Page<Sale> findAllByDateStart(Pageable pageable, java.util.Date start);
    Page<Sale> findAllByDateEnd(Pageable pageable,Date end);
}
