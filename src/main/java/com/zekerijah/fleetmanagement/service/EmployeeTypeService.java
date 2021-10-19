package com.zekerijah.fleetmanagement.service;

import com.zekerijah.fleetmanagement.model.EmployeeType;
import com.zekerijah.fleetmanagement.repository.EmployeeTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeTypeService {

    @Autowired
    private EmployeeTypeRepository employeeTypeRepository;

    public List<EmployeeType> getEmployeesTypes() {
        return employeeTypeRepository.findAll();
    }

    public void saveEmployeeType(EmployeeType employeeType) {
        employeeTypeRepository.save(employeeType);
    }

    public Optional<EmployeeType> getEmpolyeeTypeById(Integer id) {
        return employeeTypeRepository.findById(id);
    }

    public void deleteEmployeTypeById(Integer id) {
        employeeTypeRepository.deleteById(id);
    }
}
