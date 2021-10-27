package com.zekerijah.fleetmanagement.service;

import com.zekerijah.fleetmanagement.model.VehicleHire;
import com.zekerijah.fleetmanagement.repository.VehicleHireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleHireService {

    @Autowired
    private VehicleHireRepository vehicleHireRepository;

    public List<VehicleHire> getVehicleHires(){
        return vehicleHireRepository.findAll();
    }

    public Optional<VehicleHire> getVehicleHireById(Integer id){
        return vehicleHireRepository.findById(id);
    }

    public void saveVehicleHire(VehicleHire vehicleHire){
        vehicleHireRepository.save(vehicleHire);
    }

    public void deleteVehicleHire(Integer id){
        vehicleHireRepository.deleteById(id);
    }
}
