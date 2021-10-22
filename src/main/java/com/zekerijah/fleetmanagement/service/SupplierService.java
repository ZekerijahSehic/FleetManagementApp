package com.zekerijah.fleetmanagement.service;

import com.zekerijah.fleetmanagement.model.Supplier;
import com.zekerijah.fleetmanagement.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    public List<Supplier> getSuppliers(){
        return supplierRepository.findAll();
    }

    public Optional<Supplier> getSupplierById(Integer id){
        return supplierRepository.findById(id);
    }

    public void saveSupplier(Supplier supplier){
        supplierRepository.save(supplier);
    }

    public void deleteSupplierById(Integer id){
        supplierRepository.deleteById(id);
    }


}
