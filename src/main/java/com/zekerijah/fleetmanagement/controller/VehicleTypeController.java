package com.zekerijah.fleetmanagement.controller;

import com.zekerijah.fleetmanagement.model.VehicleType;
import com.zekerijah.fleetmanagement.service.VehicleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class VehicleTypeController {

    @Autowired
    private VehicleTypeService vehicleTypeService;

    @GetMapping("/vehicles-types")
    public String getVehiclesTypes(Model model, String keyword){

        if(keyword != null) {
            model.addAttribute("vehiclesTypes", vehicleTypeService.findByKeyword(keyword));
        } else {
            model.addAttribute("vehiclesTypes", vehicleTypeService.getVehiclesTypes());
        }
        return "vehicle_type";
    }

    @PostMapping("/vehicles-types/add-new")
    public String addVehicleType(VehicleType vehicleType) {
        vehicleTypeService.saveVehicleType(vehicleType);
        return "redirect:/vehicles-types";
    }

    @RequestMapping("/vehicles-types/find-by-id")
    @ResponseBody
    public Optional<VehicleType> getVehicleType(Integer id) {
        return vehicleTypeService.getVehicleTypeById(id);
    }

    @RequestMapping(value = "/vehicles-types/update", method = {RequestMethod.GET, RequestMethod.PUT})
    public String updateVehicleType(VehicleType vehicleType) {
        vehicleTypeService.saveVehicleType(vehicleType);
        return "redirect:/vehicles-types";
    }

    @RequestMapping(value = "/vehicles-types/delete", method = {RequestMethod.GET, RequestMethod.DELETE})
    public String deleteVehicleType(Integer id) {
        vehicleTypeService.deleteVehicleTypeById(id);
        return "redirect:/vehicles-types";
    }

}
