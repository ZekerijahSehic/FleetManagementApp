package com.zekerijah.fleetmanagement.service;

import com.zekerijah.fleetmanagement.model.Employee;
import com.zekerijah.fleetmanagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getEmployees(){
        return employeeRepository.findAll();
    }

    public void saveEmployee(Employee employee){
        employeeRepository.save(employee);
    }

    public void deleteEmployee(Integer id){
        employeeRepository.deleteById(id);
    }

    public Optional<Employee> getEmployeById(Integer id){
        return employeeRepository.findById(id);
    }
}
