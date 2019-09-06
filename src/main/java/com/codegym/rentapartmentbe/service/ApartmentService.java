package com.codegym.rentapartmentbe.service;

import com.codegym.rentapartmentbe.entity.Apartment;
import com.codegym.rentapartmentbe.entity.LandLord;

import java.util.List;
import java.util.Optional;

public interface ApartmentService {
    List<Apartment> findAllApartment();
    void saveApartment(Long id, Apartment apartment);
    void deleteApartment(Long id);
    Optional<Apartment> findById(Long id);
    List<Apartment> findAllByLandLord(LandLord landLord);
}
