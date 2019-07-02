package com.springbootpetclinic.dao;

import com.springbootpetclinic.model.Pet;

import java.util.List;

public interface PetRepository {
    Pet findById(Long id);

    List<Pet> findByOwnerId(Long ownerId);

    void create(Pet pet);

    Pet update(Pet pet);

    void delete();

    void deleteByOwnerId(Long ownerId);
}
