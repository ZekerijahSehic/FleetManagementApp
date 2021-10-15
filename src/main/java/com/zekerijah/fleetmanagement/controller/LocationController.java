package com.zekerijah.fleetmanagement.controller;

import com.zekerijah.fleetmanagement.model.Country;
import com.zekerijah.fleetmanagement.model.Location;
import com.zekerijah.fleetmanagement.model.Region;
import com.zekerijah.fleetmanagement.service.CountryService;
import com.zekerijah.fleetmanagement.service.LocationService;
import com.zekerijah.fleetmanagement.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class LocationController {

    @Autowired
    private LocationService locationService;

    @Autowired
    private CountryService countryService;

    @Autowired
    private RegionService regionService;

    @GetMapping("/locations")
    public String getLocations(Model model){
        List<Location> locationList = locationService.getLocations();
        model.addAttribute("locations", locationList);

        List<Country> countryList = countryService.getCountries();
        model.addAttribute("countries", countryList);

        List<Region> regionList = regionService.getRegions();
        model.addAttribute("regions", regionList);

        return "location";
    }

    @PostMapping("/locations/add-new")
    public String addLocation(Location location){
        locationService.saveLocation(location);
        return "redirect:/locations";
    }

    @RequestMapping("/locations/find-by-id")
    @ResponseBody
    public Optional<Location> getLocation(Integer id){
        return locationService.getLocationById(id);
    }

    @RequestMapping(value = "/locations/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String updateLocation(Location country) {
        locationService.saveLocation(country);
        return "redirect:/locations";
    }

    @RequestMapping(value = "/locations/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteLocation(Integer id){
        locationService.deleteLocationById(id);
        return "redirect:/locations";
    }
}
