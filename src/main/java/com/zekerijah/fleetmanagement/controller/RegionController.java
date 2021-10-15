package com.zekerijah.fleetmanagement.controller;

import com.zekerijah.fleetmanagement.model.Country;
import com.zekerijah.fleetmanagement.model.Region;
import com.zekerijah.fleetmanagement.service.CountryService;
import com.zekerijah.fleetmanagement.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class RegionController {

    @Autowired
    private RegionService regionService;

    @Autowired
    private CountryService countryService;

    @GetMapping("/regions")
    public String getRegions(Model model){
        List<Region> regionList = regionService.getRegions();
        model.addAttribute("regions", regionList);

        List<Country> countryList = countryService.getCountries();
        model.addAttribute("countries", countryList);

        return "region";
    }

    @PostMapping("/regions/add-new")
    public String addRegion(Region region){
        regionService.saveRegion(region);
        return "redirect:/regions";
    }

    @RequestMapping("/regions/find-by-id")
    @ResponseBody
    public Optional<Region> getRegion(Integer id){
        return regionService.getRegionById(id);
    }

    @RequestMapping(value = "/regions/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String updateRegion(Region region) {
        regionService.saveRegion(region);
        return "redirect:/regions";
    }

    @RequestMapping(value = "/regions/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteRegion(Integer id){
        regionService.deleteRegionById(id);
        return "redirect:/regions";
    }
}
