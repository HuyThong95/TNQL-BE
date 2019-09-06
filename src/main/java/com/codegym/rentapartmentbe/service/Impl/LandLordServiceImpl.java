package com.codegym.rentapartmentbe.service.Impl;

import com.codegym.rentapartmentbe.entity.LandLord;
import com.codegym.rentapartmentbe.repository.LandLordRepository;
import com.codegym.rentapartmentbe.service.LandLordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class LandLordServiceImpl implements LandLordService {
    @Autowired
    private LandLordRepository landLordRepository;
    @Override
    public List<LandLord> findAllLandLord() {
        return (List<LandLord>) landLordRepository.findAll();
    }

    @Override
    public void saveLandLord(Long id, LandLord landLord) {
        landLordRepository.save(landLord);

    }

    @Override
    public void deleteLandLord(Long id) {
        landLordRepository.deleteById(id);

    }

    @Override
    public Optional<LandLord> findLandLordById(Long id) {
        return landLordRepository.findById(id);
    }
}
