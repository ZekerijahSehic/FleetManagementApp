package com.zekerijah.fleetmanagement.controller;

import com.zekerijah.fleetmanagement.model.EmployeeType;
import com.zekerijah.fleetmanagement.service.EmployeeTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class EmployeeTypeController {

    @Autowired
    private EmployeeTypeService employeeTypeService;

    @GetMapping("/employees-types")
    public String getEmployeesTypes(Model model){
        List<EmployeeType> employeeTypeList = employeeTypeService.getEmployeesTypes();
        model.addAttribute("employeesTypes", employeeTypeList);
        return "employee_type";
    }

    @PostMapping("/employees-types/add-new")
    public String addEmployeeType(EmployeeType employeeType){
        employeeTypeService.saveEmployeeType(employeeType);
        return "redirect:/employees-types";
    }

    @RequestMapping("/employees-types/find-by-id")
    @ResponseBody
    public Optional<EmployeeType> getEmployeType(Integer id){
        return employeeTypeService.getEmpolyeeTypeById(id);
    }

    @RequestMapping(value = "/employees-types/update", method = {RequestMethod.GET, RequestMethod.PUT})
    public String updateEmployeeType(EmployeeType employeeType){
        employeeTypeService.saveEmployeeType(employeeType);
        return "redirect:/employees-types";
    }

    @RequestMapping(value = "/employees-types/delete", method = {RequestMethod.GET, RequestMethod.DELETE})
    public String deleteEmployeeType(Integer id) {
        employeeTypeService.deleteEmployeTypeById(id);
        return "redirect:/employees-types";
    }
}
