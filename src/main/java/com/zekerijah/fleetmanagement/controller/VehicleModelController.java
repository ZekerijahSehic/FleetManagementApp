package com.zekerijah.fleetmanagement.controller;

import com.zekerijah.fleetmanagement.model.VehicleModel;
import com.zekerijah.fleetmanagement.service.VehicleModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class VehicleModelController {

    @Autowired
    private VehicleModelService vehicleModelService;

    @GetMapping("/vehicles-models")
    public String getVehiclesModels(Model model){
        List<VehicleModel> vehicleModelList = vehicleModelService.getVehiclesModels();
        model.addAttribute("vehiclesModels", vehicleModelList);
        return "vehicle_model";
    }

    @PostMapping("/vehicles-models/add-new")
    public String addVehicleModel(VehicleModel vehicleModel) {
        vehicleModelService.saveVehicleModel(vehicleModel);
        return "redirect:/vehicles-models";
    }

    @GetMapping("/vehicles-models/find-by-id")
    @ResponseBody
    public Optional<VehicleModel> getVehicleModel(Integer id) {
        return vehicleModelService.getVehicleModelById(id);
    }

    @RequestMapping(value = "/vehicles-models/update", method = {RequestMethod.GET, RequestMethod.PUT})
    public String updateVehicleModel(VehicleModel vehicleModel) {
        vehicleModelService.saveVehicleModel(vehicleModel);
        return "redirect:/vehicles-models/";
    }

    @RequestMapping(value = "/vehicles-models/delete", method = {RequestMethod.GET, RequestMethod.DELETE})
    public String deleteVehicleModel(Integer id){
        vehicleModelService.deleteVehicleModelById(id);
        return "redirect:/vehicles-models/";
    }
}

