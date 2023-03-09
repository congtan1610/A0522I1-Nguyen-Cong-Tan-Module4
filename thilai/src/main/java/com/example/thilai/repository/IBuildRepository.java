package com.example.thilai.repository;

import com.example.thilai.model.Build;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;

@Repository
public interface IBuildRepository extends JpaRepository<Build,Integer> {
    @Query(value = "select * from Build",countQuery = "select * from Build",nativeQuery = true)
    Page<Build> findAllWithPage(Pageable pageable);
    Page<Build> findAllByDayBuyIsBetween(Pageable pageable,Date start,Date end);
    @Query(value = "select b.id,b.size,b.day_buy,b.id_product from build b join product p on b.id_product=p.id order by b.size*p.price desc",countQuery = "select b.id,b.size,b.day_buy,b.id_product from build b join product p on b.id_product=p.id order by b.size*p.price desc",nativeQuery = true)
    Page<Build> findAllByLimit(Pageable pageable);
}
