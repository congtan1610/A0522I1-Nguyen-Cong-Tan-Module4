package com.example.register_new.service;

import com.example.register_new.model.User;
import com.example.register_new.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{
    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public void save(User user) {
      iUserRepository.save(user);
    }
}
