package com.zekerijah.fleetmanagement.controller;

import com.zekerijah.fleetmanagement.model.*;
import com.zekerijah.fleetmanagement.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeTypeService employeeTypeService;

    @Autowired
    private JobTitleService jobTitleService;

    @Autowired
    private CountryService countryService;

    @Autowired
    private RegionService regionService;

    @GetMapping("/employees")
    public String getEmployees(Model model){
        List<Employee> employeeList = employeeService.getEmployees();
        List<EmployeeType> employeeTypeList = employeeTypeService.getEmployeesTypes();
        List<JobTitle> jobTitleList = jobTitleService.getJobsTitles();
        List<Country> countryList = countryService.getCountries();
        List<Region> regionList = regionService.getRegions();

        model.addAttribute("employees", employeeList);
        model.addAttribute("employeesTypes", employeeTypeList);
        model.addAttribute("jobsTitles", jobTitleList);
        model.addAttribute("countries", countryList);
        model.addAttribute("regions", regionList);

        return "employee";
    }

    @PostMapping("/employees/add-new")
    public String addEmployee(Employee employee){
        employeeService.saveEmployee(employee);
        return "redirect:/employees";
    }

    @RequestMapping("/employees/find-by-id")
    @ResponseBody
    public Optional<Employee> getEmployee(Integer id){
        return employeeService.getEmployeById(id);
    }

    @RequestMapping(value = "/employees/update",method = {RequestMethod.GET, RequestMethod.PUT})
    public String updateEmployee(Employee employee){
        employeeService.saveEmployee(employee);
        return "redirect:/employees";
    }

    @RequestMapping(value = "/employees/delete", method = {RequestMethod.GET, RequestMethod.DELETE})
    public String deleteEmployee(Integer id){
        employeeService.deleteEmployee(id);
        return "redirect:/employees";
    }

}
