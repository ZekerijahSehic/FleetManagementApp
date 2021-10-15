package com.zekerijah.fleetmanagement.controller;

import com.zekerijah.fleetmanagement.model.Country;
import com.zekerijah.fleetmanagement.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping("/countries")
    public String getCountries(Model model){
        List<Country> countryList = countryService.getCountries();
        model.addAttribute("countries", countryList);
        return "country";
    }

    @PostMapping("/countries/add-new")
    public String addCountry(Country country){
        countryService.saveCountry(country);
        return "redirect:/countries";
    }

    @RequestMapping("/countries/find-by-id")
    @ResponseBody
    public Optional<Country> getCountry(Integer id){
        return countryService.getCountryById(id);
    }

    @RequestMapping(value = "/countries/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String updateCountry(Country country) {
        countryService.saveCountry(country);
        return "redirect:/countries";
    }

    @RequestMapping(value = "/countries/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteCountry(Integer id){
        countryService.deleteCountryById(id);
        return "redirect:/countries";
    }
}
