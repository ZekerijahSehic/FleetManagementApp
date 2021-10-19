package com.zekerijah.fleetmanagement.service;

import com.zekerijah.fleetmanagement.model.VehicleStatus;
import com.zekerijah.fleetmanagement.repository.VehicleStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleStatusService {

    @Autowired
    private VehicleStatusRepository vehicleStatusRepository;

    public List<VehicleStatus> getVehiclesStatuses() {
        return vehicleStatusRepository.findAll();
    }

    public void saveVehicleStatus(VehicleStatus vehicleStatus) {
        vehicleStatusRepository.save(vehicleStatus);
    }

    public Optional<VehicleStatus> getVehicleStatusById(Integer id) {
        return vehicleStatusRepository.findById(id);
    }

    public void deleteVehicleStatusById(Integer id) {
        vehicleStatusRepository.deleteById(id);
    }
}
