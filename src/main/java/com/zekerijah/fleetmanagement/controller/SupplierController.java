package com.zekerijah.fleetmanagement.controller;

import com.zekerijah.fleetmanagement.model.Country;
import com.zekerijah.fleetmanagement.model.Region;
import com.zekerijah.fleetmanagement.model.Supplier;
import com.zekerijah.fleetmanagement.service.CountryService;
import com.zekerijah.fleetmanagement.service.RegionService;
import com.zekerijah.fleetmanagement.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @Autowired
    private CountryService countryService;

    @Autowired
    private RegionService regionService;

    @GetMapping("/suppliers")
    public String getSuppliers(Model model){
        List<Supplier> supplierList = supplierService.getSuppliers();
        List<Country> countryList = countryService.getCountries();
        List<Region> regionList = regionService.getRegions();

        model.addAttribute("suppliers", supplierList);
        model.addAttribute("countries", countryList);
        model.addAttribute("regions", regionList);

        return "supplier";
    }

    @PostMapping("/suppliers/add-new")
    public String addSupplier(Supplier supplier){
        supplierService.saveSupplier(supplier);
        return "redirect:/suppliers";
    }

    @RequestMapping("/suppliers/find-by-id")
    @ResponseBody
    public Optional<Supplier> getSupplier(Integer id){
        return supplierService.getSupplierById(id);
    }

    @RequestMapping(value = "/suppliers/update", method = {RequestMethod.GET, RequestMethod.PUT})
    public String updateSupplier(Supplier supplier){
        supplierService.saveSupplier(supplier);
        return "redirect:/suppliers";
    }

    @RequestMapping(value = "/suppliers/delete", method = {RequestMethod.GET, RequestMethod.DELETE})
    public String deleteSupplier(Integer id){
        supplierService.deleteSupplierById(id);
        return "redirect:/suppliers";
    }
}
