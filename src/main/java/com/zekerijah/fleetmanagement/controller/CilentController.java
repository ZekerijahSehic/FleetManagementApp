package com.zekerijah.fleetmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CilentController {

    @GetMapping("/clients")
    public String getClients(Model model){
        return "client";
    }
}
