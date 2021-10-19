package com.zekerijah.fleetmanagement.controller;

import com.zekerijah.fleetmanagement.model.VehicleMake;
import com.zekerijah.fleetmanagement.service.VehicleMakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class VehicleMakeController {

    @Autowired
    private VehicleMakeService vehicleMakeService;

    @GetMapping("/vehicles-makes")
    public String getVehiclesMakes(Model model){
        List<VehicleMake> vehicleMakeList = vehicleMakeService.getVehiclesMakes();
        model.addAttribute("vehiclesMakes", vehicleMakeList);
        return "vehicle_make";
    }

    @PostMapping("/vehicles-makes/add-new")
    public String addVehicleMake (VehicleMake vehicleMake){
        vehicleMakeService.saveVehicleMake(vehicleMake);
        return "redirect:/vehicles-makes";
    }

    @GetMapping("/vehicles-makes/find-by-id")
    @ResponseBody
    public Optional<VehicleMake> getVehicleMake(Integer id){
        return vehicleMakeService.getVehicleMakeById(id);
    }

    @RequestMapping(value ="/vehicles-makes/update", method = {RequestMethod.GET, RequestMethod.PUT})
    public String updateVehicleMake (VehicleMake vehicleMake) {
        vehicleMakeService.saveVehicleMake(vehicleMake);
        return "redirect:/vehicles-makes";
    }

    @RequestMapping(value = "/vehicles-makes/delete", method = {RequestMethod.GET, RequestMethod.DELETE})
    public String deleteVehicleMake(Integer id) {
        vehicleMakeService.deleteVehicleMakeById(id);
        return "redirect:/vehicles-makes";
    }
}
