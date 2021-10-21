package com.zekerijah.fleetmanagement.controller;

import com.zekerijah.fleetmanagement.model.Client;
import com.zekerijah.fleetmanagement.model.Country;
import com.zekerijah.fleetmanagement.model.Region;
import com.zekerijah.fleetmanagement.service.ClientService;
import com.zekerijah.fleetmanagement.service.CountryService;
import com.zekerijah.fleetmanagement.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class CilentController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private CountryService countryService;

    @Autowired
    private RegionService regionService;

    @GetMapping("/clients")
    public String getClients(Model model){
        List<Client> clientList = clientService.getClients();
        List<Country> countryList = countryService.getCountries();
        List<Region> regionList = regionService.getRegions();

        model.addAttribute("clients", clientList);
        model.addAttribute("countries", countryList);
        model.addAttribute("regions", regionList);
        return "client";
    }

    @PostMapping("/clients/add-new")
    public String addClient(Client client){
        clientService.saveClient(client);
        return "redirect:/clients";
    }

    @RequestMapping("/clients/find-by-id")
    @ResponseBody
    public Optional<Client> getClient(Integer id){
        return clientService.getClientById(id);
    }

    @RequestMapping(value = "/clients/update", method = {RequestMethod.GET, RequestMethod.PUT})
    public String updateClient(Client client){
        clientService.saveClient(client);
        return "redirect:/clients";
    }

    @RequestMapping(value = "/clients/delete", method = {RequestMethod.GET, RequestMethod.DELETE})
    public String deleteClient(Integer id){
        clientService.deleteClientById(id);
        return "redirect:/clients";
    }
}
