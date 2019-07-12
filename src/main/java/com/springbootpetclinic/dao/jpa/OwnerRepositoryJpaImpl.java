package com.springbootpetclinic.dao.jpa;

import com.springbootpetclinic.dao.OwnerRepository;
import com.springbootpetclinic.model.Owner;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository("ownerRepository")
public class OwnerRepositoryJpaImpl implements OwnerRepository {
    @PersistenceContext
    //Spring konteynerın runtime da yönettiği transactional entity manager istance'nin buraya enjekte edilmesini sağlar
    private EntityManager entityManager;


    @Override
    public List<Owner> findAll() {
        return entityManager.createQuery("from Owner", Owner.class).getResultList();
    }

    @Override
    public Owner findById(Long id) {
        return entityManager.find(Owner.class, id);
    }

    @Override
    public List<Owner> findByLastName(String lastName) {
        return entityManager.createQuery("from Owner Where lastname=:lastName", Owner.class)
                .setParameter("lastName", lastName).getResultList();
    }

    @Override
    public void create(Owner owner) {
        entityManager.persist(owner);
    }

    @Override
    public Owner update(Owner owner) {
        return entityManager.merge(owner);
    }


    @Override
    public void delete(Long id) {
        entityManager.remove(entityManager.getReference(Owner.class, id));//önce persistence contexten referans alarak remove parametre olarak gönderiyoruz
    }
}
