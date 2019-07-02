package com.springbootpetclinic.dao.mem;

import com.springbootpetclinic.dao.OwnerRepository;
import com.springbootpetclinic.model.Owner;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class OwnerRepositoryInMemoryImpl implements OwnerRepository {

    private Map<Long, Owner> ownersMap = new HashMap<>();

    public OwnerRepositoryInMemoryImpl() {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Muhammed");
        owner1.setLastName("Demir");

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Ahmet");
        owner2.setLastName("Şeker");

        Owner owner3 = new Owner();
        owner3.setId(3L);
        owner3.setFirstName("Bekir");
        owner3.setLastName("yılmaz");

        Owner owner4 = new Owner();
        owner4.setId(4L);
        owner4.setFirstName("Yunus");
        owner4.setLastName("Delibaş");

        ownersMap.put(owner1.getId(), owner1);
        ownersMap.put(owner2.getId(), owner2);
        ownersMap.put(owner3.getId(), owner3);
        ownersMap.put(owner4.getId(), owner4);


    }

    @Override
    public List<Owner> findAll() {
        return new ArrayList<>(ownersMap.values());
    }

    @Override
    public Owner findById(Long id) {
        return ownersMap.get(id);
    }

    @Override
    public List<Owner> findByLastName(String lastName) {
        return ownersMap.values().stream().filter(o -> o.getLastName().equals(lastName)).collect(Collectors.toList());
    }

    @Override
    public void create(Owner owner) {
        owner.setId(new Date().getTime());
        ownersMap.put(owner.getId(), owner);
    }

    @Override
    public Owner update(Owner owner) {
        ownersMap.replace(owner.getId(), owner);
        return owner;
    }

    @Override
    public void delete(Long id) {
        ownersMap.remove(id);
    }
}
