package com.zekerijah.fleetmanagement.service;

import com.zekerijah.fleetmanagement.model.VehicleType;
import com.zekerijah.fleetmanagement.repository.VehicleTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleTypeService {

    @Autowired
    private VehicleTypeRepository vehicleTypeRepository;

    public List<VehicleType> getVehiclesTypes(){
        return vehicleTypeRepository.findAll();
    }

    public void saveVehicleType(VehicleType vehicleType){
        vehicleTypeRepository.save(vehicleType);
    }

    public Optional<VehicleType> getVehicleTypeById(Integer id) {
        return vehicleTypeRepository.findById(id);
    }

    public void deleteVehicleTypeById(Integer id) {
        vehicleTypeRepository.deleteById(id);
    }

    public List<VehicleType> findByKeyword(String keyword){
        return vehicleTypeRepository.findByKeyword(keyword);
    }
}
