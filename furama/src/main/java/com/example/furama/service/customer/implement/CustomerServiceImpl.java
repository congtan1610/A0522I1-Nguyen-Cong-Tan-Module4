package com.example.furama.service.customer.implement;

import com.example.furama.model.customer.Customer;
import com.example.furama.repository.customer.ICustomerRepository;
import com.example.furama.service.customer.ICustomerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements ICustomerService {
    private final ICustomerRepository iCustomerRepository;

    public CustomerServiceImpl(ICustomerRepository iCustomerRepository) {
        this.iCustomerRepository = iCustomerRepository;
    }

    @Override
    public Page<Customer> findAllWithPage(PageRequest pageRequest) {
        return iCustomerRepository.findAllWithPage(pageRequest);
    }

    @Override
    public Page<Customer> findAllWithName(PageRequest pageRequest, String name) {
        return iCustomerRepository.findAllByNameContaining(pageRequest, name);
    }

    @Override
    public void save(Customer customer) {
        iCustomerRepository.save(customer);
    }

    @Override
    public void delete(Long id) {
        iCustomerRepository.deleteById(id);
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return iCustomerRepository.findById(id);
    }
}
