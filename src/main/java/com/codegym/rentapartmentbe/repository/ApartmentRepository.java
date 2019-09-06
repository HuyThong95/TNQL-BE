package com.codegym.rentapartmentbe.repository;

import com.codegym.rentapartmentbe.entity.Apartment;
import com.codegym.rentapartmentbe.entity.LandLord;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
@Repository
@CrossOrigin(origins = "*")
public interface ApartmentRepository extends CrudRepository<Apartment, Long> {
    List<Apartment> findAllByLandLord(LandLord landLord);
}
