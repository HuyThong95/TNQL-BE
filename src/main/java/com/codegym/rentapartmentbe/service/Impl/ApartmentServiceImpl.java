package com.codegym.rentapartmentbe.service.Impl;

import com.codegym.rentapartmentbe.entity.Apartment;
import com.codegym.rentapartmentbe.entity.LandLord;
import com.codegym.rentapartmentbe.repository.ApartmentRepository;
import com.codegym.rentapartmentbe.service.ApartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ApartmentServiceImpl implements ApartmentService {
    @Autowired
    private ApartmentRepository apartmentRepository;
    @Override
    public List<Apartment> findAllApartment() {
        return (List<Apartment>) apartmentRepository.findAll();
    }

    @Override
    public void saveApartment(Long id, Apartment apartment) {
        apartmentRepository.save(apartment);

    }

    @Override
    public void deleteApartment(Long id) {
        apartmentRepository.deleteById(id);
    }

    @Override
    public Optional<Apartment> findById(Long id) {
        return apartmentRepository.findById(id);
    }

    @Override
    public List<Apartment> findAllByLandLord(LandLord landLord) {
        return apartmentRepository.findAllByLandLord(landLord);
    }
}
