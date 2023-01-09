package com.codegym.repository;

import com.codegym.model.Entity;

import java.util.List;

public interface IEntityRepository {
    List<Entity> findAll();
    void add(Entity entity);
    void update(Entity entity);
    void delete(Integer id);
    void play();
}
