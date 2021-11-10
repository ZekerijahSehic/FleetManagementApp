package com.zekerijah.fleetmanagement.controller;

import com.zekerijah.fleetmanagement.model.*;
import com.zekerijah.fleetmanagement.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private VehicleTypeService vehicleTypeService;

    @Autowired
    private VehicleMakeService vehicleMakeService;

    @Autowired
    private VehicleStatusService vehicleStatusService;

    @Autowired
    private VehicleModelService vehicleModelService;

    @Autowired
    private LocationService locationService;

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/vehicles")
    public String getVehicles(Model model){

        List<Vehicle> vehicleList =  vehicleService.getVehicles();
        List<VehicleType> vehicleTypeList = vehicleTypeService.getVehiclesTypes();
        List<VehicleMake> vehicleMakeList = vehicleMakeService.getVehiclesMakes();
        List<VehicleStatus> vehicleStatusList = vehicleStatusService.getVehiclesStatuses();
        List<VehicleModel> vehicleModelList = vehicleModelService.getVehiclesModels();
        List<Location> locationList = locationService.getLocations();
        List<Employee> employeeList = employeeService.getEmployees();

        model.addAttribute("vehicles", vehicleList);
        model.addAttribute("vehiclesTypes", vehicleTypeList);
        model.addAttribute("vehiclesMakes", vehicleMakeList);
        model.addAttribute("vehiclesStatuses", vehicleStatusList);
        model.addAttribute("vehiclesModels", vehicleModelList);
        model.addAttribute("locations", locationList);
        model.addAttribute("employees", employeeList);

        return "vehicle";
    }

    @PostMapping("/vehicles/add-new")
    public String addVehicle(Vehicle vehicle){
        vehicleService.saveVehicle(vehicle);
        return "redirect:/vehicles";
    }

    @GetMapping("/vehicles/find-by-id")
    @ResponseBody
    public Optional<Vehicle> getVehicle(Integer id){
        return vehicleService.getVehicleById(id);
    }

    @RequestMapping(value = "/vehicles/update", method = {RequestMethod.GET, RequestMethod.PUT})
    public String updateVehicle(Vehicle vehicle){
        vehicleService.saveVehicle(vehicle);
        return "redirect:/vehicles";
    }

    @RequestMapping(value = "/vehicles/delete", method = {RequestMethod.GET, RequestMethod.DELETE})
    public String deleteVehicle(Integer id){
        vehicleService.deleteVehicle(id);
        return "redirect:/vehicles";
    }
}
