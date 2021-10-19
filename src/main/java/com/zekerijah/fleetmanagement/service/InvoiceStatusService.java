package com.zekerijah.fleetmanagement.service;

import com.zekerijah.fleetmanagement.model.InvoiceStatus;
import com.zekerijah.fleetmanagement.repository.InvoiceStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceStatusService {

    @Autowired
    private InvoiceStatusRepository invoiceStatusRepository;

    public List<InvoiceStatus> getInvoicesStatuses() {
        return invoiceStatusRepository.findAll();
    }

    public void saveInvoiceStatus(InvoiceStatus invoiceStatus) {
        invoiceStatusRepository.save(invoiceStatus);
    }

    public Optional<InvoiceStatus> getInvoiceStatusById(Integer id) {
        return invoiceStatusRepository.findById(id);
    }

    public void deleteInvoiceStatusById(Integer id) {
        invoiceStatusRepository.deleteById(id);
    }
}
