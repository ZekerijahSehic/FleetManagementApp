package com.zekerijah.fleetmanagement.controller;

import com.zekerijah.fleetmanagement.model.Contact;
import com.zekerijah.fleetmanagement.model.Supplier;
import com.zekerijah.fleetmanagement.model.Vehicle;
import com.zekerijah.fleetmanagement.model.VehicleMaintenance;
import com.zekerijah.fleetmanagement.service.SupplierService;
import com.zekerijah.fleetmanagement.service.VehicleMaintenanceService;
import com.zekerijah.fleetmanagement.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class VehicleMaintenanceController {

    @Autowired
    private VehicleMaintenanceService vehicleMaintenanceService;

    @Autowired
    private SupplierService supplierService;

    @Autowired
    private VehicleService vehicleService;

    @GetMapping("/vehicles-maintenances")
    public String getVehiclesMaintenances(Model model){
        List<VehicleMaintenance> vehicleMaintenanceList = vehicleMaintenanceService.getVehicleMaintenances();
        List<Supplier> supplierList = supplierService.getSuppliers();
        List<Vehicle> vehicleList = vehicleService.getVehicles();

        model.addAttribute("vehiclesMaintenances", vehicleMaintenanceList);
        model.addAttribute("suppliers", supplierList);
        model.addAttribute("vehicles", vehicleList);

        return "vehicle_maintenance";
    }

    @PostMapping("/vehicles-maintenances/add-new")
    public String addVehicleMaintenance(VehicleMaintenance vehicleMaintenance){
        vehicleMaintenanceService.saveVehicleMaintenance(vehicleMaintenance);
        return "redirect:/vehicles-maintenances";
    }

    @RequestMapping("/vehicles-maintenances/find-by-id")
    @ResponseBody
    public Optional<VehicleMaintenance> getVehicleMaintenance(Integer id){
        return vehicleMaintenanceService.getVehicleMaintenanceById(id);
    }

    @RequestMapping(value = "/vehicles-maintenances/update", method = {RequestMethod.GET, RequestMethod.PUT})
    public String updateVehicleMaintenance(VehicleMaintenance vehicleMaintenance){
        vehicleMaintenanceService.saveVehicleMaintenance(vehicleMaintenance);
        return "redirect:/vehicles-maintenances";
    }

    @RequestMapping(value = "/vehicles-maintenances/delete", method = {RequestMethod.GET, RequestMethod.PUT})
    public String deleteVehicleMaintenance(Integer id){
        vehicleMaintenanceService.deleteVehicleMaintenanceById(id);
        return "redirect:/vehicles-maintenances";
    }
}
