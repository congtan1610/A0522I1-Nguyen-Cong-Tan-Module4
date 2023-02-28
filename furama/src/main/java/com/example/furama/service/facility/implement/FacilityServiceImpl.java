package com.example.furama.service.facility.implement;

import com.example.furama.model.facility.Facility;
import com.example.furama.repository.facility.IFacitilyRepository;
import com.example.furama.service.facility.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FacilityServiceImpl implements IFacilityService {
    @Autowired
    private IFacitilyRepository iFacitilyRepository;

    @Override
    public Page<Facility> findAllWithPage(PageRequest pageRequest) {
        return iFacitilyRepository.findAllWithPage(pageRequest);
    }

    @Override
    public Page<Facility> findAllWithName(PageRequest pageRequest, String name) {
        return iFacitilyRepository.findAllByNameContaining(pageRequest,name);
    }

    @Override
    public void save(Facility facility) {
        iFacitilyRepository.save(facility);
    }

    @Override
    public void delete(Long id) {
        iFacitilyRepository.deleteById(id);
    }

    @Override
    public Optional<Facility> findById(Long id) {
        return iFacitilyRepository.findById(id);
    }
}
