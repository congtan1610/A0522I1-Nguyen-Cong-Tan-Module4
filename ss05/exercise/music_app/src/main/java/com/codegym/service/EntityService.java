package com.codegym.service;

import com.codegym.model.Entity;
import com.codegym.repository.EntityRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EntityService implements IEntityService {
    @Autowired
    private EntityRepository entityRepository;

    @Override
    public List<Entity> findAll() {
        return entityRepository.findAll();
    }

    @Override
    public void add(Entity entity) {
        entityRepository.add(entity);
    }

    @Override
    public void update(Entity entity) {
        entityRepository.update(entity);
    }

    @Override
    public void delete(Integer id) {
        entityRepository.delete(id);
    }

    @Override
    public void play() {
        entityRepository.play();
    }
}
