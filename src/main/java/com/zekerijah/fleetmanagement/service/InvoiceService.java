package com.zekerijah.fleetmanagement.service;

import com.zekerijah.fleetmanagement.model.Invoice;
import com.zekerijah.fleetmanagement.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    public List<Invoice> getInvoices(){
        return invoiceRepository.findAll();
    }

    public Optional<Invoice> getInvoiceById(Integer id){
        return invoiceRepository.findById(id);
    }

    public void saveInvoice(Invoice invoice){
        invoiceRepository.save(invoice);
    }

    public void deleteInvoiceById(Integer id){
        invoiceRepository.deleteById(id);
    }


}
