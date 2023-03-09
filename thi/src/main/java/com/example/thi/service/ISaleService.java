package com.example.thi.service;

import com.example.thi.model.Sale;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Optional;

@Service
public interface ISaleService {
    Page<Sale> findAllWithPage(PageRequest pageRequest);
    Page<Sale> findAllWithRange(PageRequest pageRequest,Integer range);
    Page<Sale> findAllWithStart(PageRequest pageRequest, Date start);
    Page<Sale> findAllWithEnd(PageRequest pageRequest,Date end);

    void save(Sale sale);

    Object delete(Integer id);
    Optional<Sale> finById(Integer id);
}
