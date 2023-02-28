package com.example.furama.repository.facility;

import com.example.furama.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IFacitilyRepository extends JpaRepository<Facility,Long> {
    @Query(value = "select * from Facility ",countQuery = "select * from Facility ",nativeQuery = true)
    Page<Facility> findAllWithPage(Pageable pageable);
    Page<Facility> findAllByNameContaining(Pageable pageable,String name);
}
