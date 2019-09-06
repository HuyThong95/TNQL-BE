package com.codegym.rentapartmentbe.repository;

import com.codegym.rentapartmentbe.entity.LandLord;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LandLordRepository extends CrudRepository<LandLord, Long> {
    LandLord findByName(String name);
    Boolean existsByName(String name);
    Boolean existsByEmail(String email);
}
