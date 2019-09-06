package com.codegym.rentapartmentbe.service;

import com.codegym.rentapartmentbe.entity.LandLord;

import java.util.List;
import java.util.Optional;

public interface LandLordService {
    List<LandLord> findAllLandLord();
    void saveLandLord( Long id, LandLord landLord);
    void deleteLandLord( Long id);
    Optional<LandLord> findLandLordById(Long id);
}
