package com.zekerijah.fleetmanagement.controller;

import com.zekerijah.fleetmanagement.model.*;
import com.zekerijah.fleetmanagement.service.ClientService;
import com.zekerijah.fleetmanagement.service.LocationService;
import com.zekerijah.fleetmanagement.service.VehicleHireService;
import com.zekerijah.fleetmanagement.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class VehicleHireController {

    @Autowired
    private VehicleHireService vehicleHireService;

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private LocationService locationService;

    @GetMapping("/vehicles-hires")
    public String getVehiclesMakes(Model model){
        List<VehicleHire> vehicleHireList = vehicleHireService.getVehicleHires();
        List<Vehicle> vehicleList = vehicleService.getVehicles();
        List<Client> clientList = clientService.getClients();
        List<Location> locationList = locationService.getLocations();

        model.addAttribute("vehiclesHires", vehicleHireList);
        model.addAttribute("vehicles", vehicleList);
        model.addAttribute("clients", clientList);
        model.addAttribute("locations", locationList);


        return "vehicle_hire";
    }

    @PostMapping("/vehicles-hires/add-new")
    public String addVehicleHire(VehicleHire vehicleHire){
        vehicleHireService.saveVehicleHire(vehicleHire);
        return "redirect:/vehicles-hires";
    }

    @RequestMapping("/vehicles-hires/find-by-id")
    @ResponseBody
    public Optional<VehicleHire> getVehicleHire(Integer id){
        return vehicleHireService.getVehicleHireById(id);
    }

    @RequestMapping(value = "/vehicles-hires/update", method = {RequestMethod.GET, RequestMethod.PUT})
    public String updateVehicleHire(VehicleHire vehicleHire){
        vehicleHireService.saveVehicleHire(vehicleHire);
        return "redirect:/vehicles-hires";
    }

    @RequestMapping(value = "/vehicles-hires/delete", method = {RequestMethod.GET, RequestMethod.PUT})
    public String deleteVehicleHire(Integer id){
        vehicleHireService.deleteVehicleHire(id);
        return "redirect:/vehicles-hires";
    }
}

