package com.springbootpetclinic.dao.jpa;

import com.springbootpetclinic.dao.PetRepository;
import com.springbootpetclinic.model.Pet;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class PetRepositoryJpaImpl implements PetRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Pet findById(Long id) {
        return entityManager.find(Pet.class, id);
    }

    @Override
    public List<Pet> findByOwnerId(Long ownerId) {
        return entityManager.createQuery("from Pet where owner.id=:ownerId", Pet.class)
                .setParameter("ownerId", ownerId).getResultList();
    }

    @Override
    public void create(Pet pet) {
        entityManager.persist(pet);
    }

    @Override
    public Pet update(Pet pet) {
        return entityManager.merge(pet);
    }

    @Override
    public void delete(Long id) {
        entityManager.remove(entityManager.getReference(Pet.class, id));
    }

    @Override
    public void deleteByOwnerId(Long ownerId) {
        entityManager.createQuery("delete from pet where owner.id=:ownerId")
                .setParameter("onwerId", ownerId).executeUpdate();
    }
}
