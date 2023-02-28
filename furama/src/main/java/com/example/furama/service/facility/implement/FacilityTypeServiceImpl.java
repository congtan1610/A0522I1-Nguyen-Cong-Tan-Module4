package com.example.furama.service.facility.implement;

import com.example.furama.model.facility.FacilityType;
import com.example.furama.repository.facility.IFacilityTypeRepository;
import com.example.furama.service.facility.IFacilityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityTypeServiceImpl implements IFacilityTypeService {
    @Autowired
    private IFacilityTypeRepository  iFacilityTypeRepository;
    @Override
    public List<FacilityType> findAll() {
        return iFacilityTypeRepository.findAll();
    }
}
