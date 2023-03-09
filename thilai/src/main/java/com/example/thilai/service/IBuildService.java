package com.example.thilai.service;

import com.example.thilai.model.Build;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.sql.Date;
import java.util.Optional;

public interface IBuildService {
     Page<Build> findAll(PageRequest pageRequest);
     Optional<Build> findById(Integer id);
     void save(Build build);
     Page<Build> findAllWithDayBuy(PageRequest pageRequest, Date start, Date end);
     Page<Build> findAllWithTop(PageRequest pageRequest);
}
