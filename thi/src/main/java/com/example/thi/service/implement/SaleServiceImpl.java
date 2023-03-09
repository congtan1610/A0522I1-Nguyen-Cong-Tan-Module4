package com.example.thi.service.implement;

import com.example.thi.model.Sale;
import com.example.thi.repository.ISaleRepository;
import com.example.thi.service.ISaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Optional;

@Service
public class SaleServiceImpl implements ISaleService {
    @Autowired
    private ISaleRepository iSaleRepository;

    @Override
    public Page<Sale> findAllWithPage(PageRequest pageRequest) {
        return iSaleRepository.findAllWithPage(pageRequest);
    }

    @Override
    public Page<Sale> findAllWithRange(PageRequest pageRequest, Integer range) {
        return iSaleRepository.findAllByRangeSale(pageRequest,range);
    }

    @Override
    public Page<Sale> findAllWithStart(PageRequest pageRequest, Date start) {
        return iSaleRepository.findAllByDateStart(pageRequest,start);
    }

    @Override
    public Page<Sale> findAllWithEnd(PageRequest pageRequest, Date end) {
        return iSaleRepository.findAllByDateEnd(pageRequest,end);
    }


    @Override
    public void save(Sale sale) {
        iSaleRepository.save(sale);
    }

    @Override
    public Object delete(Integer id) {
        iSaleRepository.deleteById(id);
        return null;
    }

    @Override
    public Optional<Sale> finById(Integer id) {
        return iSaleRepository.findById(id);
    }
}
