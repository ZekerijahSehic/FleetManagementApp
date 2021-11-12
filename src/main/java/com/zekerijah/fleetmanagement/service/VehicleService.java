package com.zekerijah.fleetmanagement.service;

import com.zekerijah.fleetmanagement.model.Vehicle;
import com.zekerijah.fleetmanagement.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    public List<Vehicle> getVehicles() {
        return vehicleRepository.findAll();
    }

    public void saveVehicle(Vehicle vehicle) {
        vehicleRepository.save(vehicle);
    }

    public Optional<Vehicle> getVehicleById(Integer id){
        return vehicleRepository.findById(id);
    }

    public void deleteVehicle(Integer id){
        vehicleRepository.deleteById(id);
    }
}
