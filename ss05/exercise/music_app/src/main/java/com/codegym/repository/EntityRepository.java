package com.codegym.repository;

import com.codegym.model.Entity;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityTransaction;
import java.util.List;

public class EntityRepository implements IEntityRepository{
    @Autowired
    BaseRepository baseRepository;
    @Override
    public List<Entity> findAll() {
        List<Entity> list=BaseRepository.entityManager.createQuery("select e from Entity e",Entity.class).getResultList();
        return list;
    }

    @Override
    public void add(Entity entity) {
        EntityTransaction entityTransaction=BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.persist(entity);
        entityTransaction.commit();
    }

    @Override
    public void update(Entity entity) {
        EntityTransaction entityTransaction=BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.merge(entity);
        entityTransaction.commit();
    }

    @Override
    public void delete(Integer id) {
        EntityTransaction entityTransaction=BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.remove(findById(id));
        entityTransaction.commit();
    }

    @Override
    public void play() {

    }
    public Entity findById(Integer id) {
//        Entity entity= (Entity) BaseRepository.entityManager.createQuery("select e from Entity e where e.id = ?1" ,Entity.class).setParameter(1,id).getSingleResult();

        return BaseRepository.entityManager.find(Entity.class,id);
    }
}
