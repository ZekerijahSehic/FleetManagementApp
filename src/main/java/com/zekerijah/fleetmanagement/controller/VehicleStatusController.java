package com.zekerijah.fleetmanagement.controller;

import com.zekerijah.fleetmanagement.model.VehicleStatus;
import com.zekerijah.fleetmanagement.service.VehicleStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class VehicleStatusController {

    @Autowired
    private VehicleStatusService vehicleStatusService;

    @GetMapping("/vehicles-statuses")
    public String getVehiclesStatuses(Model model){
        List<VehicleStatus> vehicleStatusList = vehicleStatusService.getVehiclesStatuses();
        model.addAttribute("vehiclesStatuses", vehicleStatusList);
        return "vehicle_status";
    }

    @PostMapping("/vehicles-statuses/add-new")
    public String addVehicleStatus(VehicleStatus vehicleStatus){
        vehicleStatusService.saveVehicleStatus(vehicleStatus);
        return "redirect:/vehicles-statuses";
    }

    @RequestMapping("/vehicles-statuses/find-by-id")
    @ResponseBody
    public Optional<VehicleStatus> getVehicleStatus(Integer id) {
        return vehicleStatusService.getVehicleStatusById(id);
    }

    @RequestMapping(value = "/vehicles-statuses/update", method = {RequestMethod.GET, RequestMethod.PUT})
    public String updateVehocleStatus(VehicleStatus vehicleStatus){
        vehicleStatusService.saveVehicleStatus(vehicleStatus);
        return "redirect:/vehicles-statuses";
    }

    @RequestMapping(value = "/vehicles-statuses/delete", method = {RequestMethod.GET, RequestMethod.DELETE})
    public String deleteVehicleStatus(Integer id) {
        vehicleStatusService.deleteVehicleStatusById(id);
        return "redirect:/vehicles-statuses";
    }
}

