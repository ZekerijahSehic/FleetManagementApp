package com.zekerijah.fleetmanagement.controller;

import com.zekerijah.fleetmanagement.model.Region;
import com.zekerijah.fleetmanagement.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class StateController {

    @Autowired
    private StateService stateService;

    @GetMapping("/states")
    public String getStates(Model model){
        List<Region> stateList = stateService.getStates();
        model.addAttribute("states", stateList);
        return "state";
    }

    @PostMapping("/states/add-new")
    public String addState(Region state){
        stateService.saveState(state);
        return "redirect:/states";
    }

    @RequestMapping("/states/find-by-id")
    @ResponseBody
    public Optional<Region> getState(Integer id){
        return stateService.getStateById(id);
    }

    @RequestMapping(value = "/states/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String updateState(Region state) {
        stateService.saveState(state);
        return "redirect:/states";
    }

    @RequestMapping(value = "/states/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteState(Integer id){
        stateService.deleteStateById(id);
        return "redirect:/states";
    }
}
