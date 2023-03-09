package com.example.thilai.service.implement;

import com.example.thilai.model.Build;
import com.example.thilai.repository.IBuildRepository;
import com.example.thilai.service.IBuildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Optional;

@Service
public class BuildServiceImpl implements IBuildService {
    @Autowired
    private IBuildRepository iBuildRepository;

    public Page<Build> findAll(PageRequest pageRequest) {
        return iBuildRepository.findAllWithPage(pageRequest);
    }


    public Optional<Build> findById(Integer id) {
        return iBuildRepository.findById(id);
    }

    public void save(Build build) {
        iBuildRepository.save(build);
    }

    public Page<Build> findAllWithDayBuy(PageRequest pageRequest, Date start, Date end) {
        return iBuildRepository.findAllByDayBuyIsBetween(pageRequest, start, end);
    }
    public Page<Build> findAllWithTop(PageRequest pageRequest){
        return iBuildRepository.findAllByLimit(pageRequest);
    }
}
