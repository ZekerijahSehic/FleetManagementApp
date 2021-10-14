package com.zekerijah.fleetmanagement;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FleetManagementController {
    @GetMapping("/index")
    public String getHome(){
        return "index";
    }
}
