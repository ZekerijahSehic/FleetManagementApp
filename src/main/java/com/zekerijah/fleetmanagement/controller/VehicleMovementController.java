package com.zekerijah.fleetmanagement.controller;

import com.zekerijah.fleetmanagement.model.Location;
import com.zekerijah.fleetmanagement.model.Vehicle;
import com.zekerijah.fleetmanagement.model.VehicleMaintenance;
import com.zekerijah.fleetmanagement.model.VehicleMovement;
import com.zekerijah.fleetmanagement.service.LocationService;
import com.zekerijah.fleetmanagement.service.VehicleMovementService;
import com.zekerijah.fleetmanagement.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class VehicleMovementController {

    @Autowired
    private VehicleMovementService vehicleMovementService;

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private LocationService locationService;

    @GetMapping("/vehicles-movements")
    public String getVehiclesMovements(Model model){
        List<VehicleMovement> vehicleMovementList = vehicleMovementService.getAllVehicleMovements();
        List<Vehicle> vehicleList = vehicleService.getVehicles();
        List<Location> locationList = locationService.getLocations();

        model.addAttribute("vehiclesMovements", vehicleMovementList);
        model.addAttribute("vehicles", vehicleList);
        model.addAttribute("locations", locationList);

        return "vehicle_movement";
    }

    @PostMapping("/vehicles-movements/add-new")
    public String addVehicleMovement(VehicleMovement vehicleMovement){
        vehicleMovementService.saveVehicleMovement(vehicleMovement);
        return "redirect:/vehicles-movements";
    }

    @RequestMapping("/vehicles-movements/find-by-id")
    @ResponseBody
    public Optional<VehicleMovement> getVehicleMovement(Integer id){
        return vehicleMovementService.getVehicleMovementById(id);
    }

    @RequestMapping(value = "/vehicles-movements/update", method = {RequestMethod.GET, RequestMethod.PUT})
    public String updateVehicleMovement(VehicleMovement vehicleMovement){
        vehicleMovementService.saveVehicleMovement(vehicleMovement);
        return "redirect:/vehicles-movements";
    }

    @RequestMapping(value = "/vehicles-movements/delete", method = {RequestMethod.GET, RequestMethod.PUT})
    public String deleteVehicleMovement(Integer id){
        vehicleMovementService.deleteVehicleMovement(id);
        return "redirect:/vehicles-movements";
    }
}
