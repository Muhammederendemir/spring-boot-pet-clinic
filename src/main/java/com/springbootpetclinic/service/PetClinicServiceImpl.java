package com.springbootpetclinic.service;

import com.springbootpetclinic.dao.OwnerRepository;
import com.springbootpetclinic.dao.PetRepository;
import com.springbootpetclinic.exception.OwnerNotFoundException;
import com.springbootpetclinic.model.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service //Spring konteyerın ilgili sınıftan bir tane bean yaratmasını sağlar
@Transactional //bu sınıfa ait butun public metotlar transactional olacak
public class PetClinicServiceImpl implements PetClinicService {

    private OwnerRepository ownerRepository;

    private PetRepository petRepository;

    @Autowired
    public void setPetRepository(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    //@Autowired//Bu anatasyon sayesinde Spring koyternır OwnerRepository tipindeki bir beanı PetClinic Beanı içerisine setter vasıtası ile enjekte edilir.
    public PetClinicServiceImpl(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public List<Owner> findOwners() {
        return ownerRepository.findAll();
    }

    @Override
    public List<Owner> findOwners(String lastName) {
        return ownerRepository.findByLastName(lastName);
    }

    @Override
    public Owner findOwner(Long id) throws OwnerNotFoundException {
        Owner owner = ownerRepository.findById(id);
        if (owner == null) throw new OwnerNotFoundException("Owner not found with id: " + id);
        return owner;
    }

    @Override
    public void createOwner(Owner owner) {
        ownerRepository.create(owner);
    }

    @Override
    public void update(Owner owner) {
        ownerRepository.update(owner);
    }

    @Override
    public void deleteOwner(Long id) {
        petRepository.deleteByOwnerId(id);
        ownerRepository.delete(id);
        //if(true) throw new RuntimeException("Testing rollback");
    }
}
