package com.zekerijah.fleetmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VehicleMaintenanceController {

    @GetMapping("/vehicles-maintenances")
    public String getVehiclesMaintenances(Model model){
        return "vehicle_maintenance";
    }
}
