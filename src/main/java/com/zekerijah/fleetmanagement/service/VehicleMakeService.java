package com.zekerijah.fleetmanagement.service;

import com.zekerijah.fleetmanagement.model.VehicleMake;
import com.zekerijah.fleetmanagement.repository.VehicleMakeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleMakeService {

    @Autowired
    private VehicleMakeRepository vehicleMakeRepository;

    public List<VehicleMake> getVehiclesMakes() {
        return vehicleMakeRepository.findAll();
    }

    public void saveVehicleMake(VehicleMake vehicleMake) {
        vehicleMakeRepository.save(vehicleMake);
    }

    public Optional<VehicleMake> getVehicleMakeById(Integer id){
        return vehicleMakeRepository.findById(id);
    }

    public void deleteVehicleMakeById(Integer id){
        vehicleMakeRepository.deleteById(id);
    }


}
