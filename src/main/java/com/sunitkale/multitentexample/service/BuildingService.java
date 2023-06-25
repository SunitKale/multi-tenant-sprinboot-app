package com.sunitkale.multitentexample.service;

import com.sunitkale.multitentexample.entity.Building;
import com.sunitkale.multitentexample.repository.BuildingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuildingService {

    @Autowired
    private BuildingRepository buildingRepository;

    public void createBuilding(Building building) {
        buildingRepository.save(building);
    }
}
