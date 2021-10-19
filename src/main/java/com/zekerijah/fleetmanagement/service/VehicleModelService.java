package com.zekerijah.fleetmanagement.service;

import com.zekerijah.fleetmanagement.model.VehicleModel;
import com.zekerijah.fleetmanagement.repository.VehicleModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleModelService {

    @Autowired
    private VehicleModelRepository vehicleModelRepository;

    public List<VehicleModel> getVehiclesModels(){
        return vehicleModelRepository.findAll();
    }

    public void saveVehicleModel(VehicleModel vehicleModel) {
        vehicleModelRepository.save(vehicleModel);
    }

    public Optional<VehicleModel> getVehicleModelById(Integer id) {
        return vehicleModelRepository.findById(id);
    }

    public void deleteVehicleModelById (Integer id) {
        vehicleModelRepository.deleteById(id);
    }



}
