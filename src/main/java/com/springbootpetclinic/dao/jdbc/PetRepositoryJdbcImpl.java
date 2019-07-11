package com.springbootpetclinic.dao.jdbc;

import com.springbootpetclinic.dao.PetRepository;
import com.springbootpetclinic.model.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PetRepositoryJdbcImpl implements PetRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Pet findById(Long id) {
        return null;
    }

    @Override
    public List<Pet> findByOwnerId(Long ownerId) {
        return null;
    }

    @Override
    public void create(Pet pet) {

    }

    @Override
    public Pet update(Pet pet) {
        return null;
    }

    @Override
    public void delete() {

    }

    @Override
    public void deleteByOwnerId(Long ownerId) {

        String sql = "delete from t_pet where owner_id= ?";
        jdbcTemplate.update(sql, ownerId);

    }
}
