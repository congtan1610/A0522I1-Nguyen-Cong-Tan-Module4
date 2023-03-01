package com.example.furama.service.facility;

import com.example.furama.model.facility.Facility;
import com.example.furama.model.facility.FacilityType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Optional;

public interface IFacilityService {
    Page<Facility> findAllWithPage(PageRequest pageRequest);
    Page<Facility> findAllWithName(PageRequest pageRequest,String name);
    Page<Facility> findAllWithType(PageRequest pageRequest,String name);
    Page<Facility> findAllWithNameAndType(PageRequest pageRequest, String name, String nameType);
    void save(Facility facility);
    void delete(Long id);
    Optional<Facility> findById(Long id);
}
