package com.example.thilai.service.implement;

import com.example.thilai.model.TypeProduct;
import com.example.thilai.repository.IProductTypeRepository;
import com.example.thilai.service.IProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductTypeServiceImpl implements IProductTypeService {
    @Autowired
    private IProductTypeRepository iProductTypeRepository;
    public List<TypeProduct> findAll(){
        return iProductTypeRepository.findAll();
    }
}
