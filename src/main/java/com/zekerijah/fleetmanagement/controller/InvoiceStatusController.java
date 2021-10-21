package com.zekerijah.fleetmanagement.controller;

import com.zekerijah.fleetmanagement.model.InvoiceStatus;
import com.zekerijah.fleetmanagement.service.InvoiceStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class InvoiceStatusController {

    @Autowired
    private InvoiceStatusService invoiceStatusService;

    @GetMapping("/invoices-status")
    public String getInvoicesStatuses(Model model){
        List<InvoiceStatus> invoiceStatusList = invoiceStatusService.getInvoicesStatuses();
        model.addAttribute("invoicesStatuses", invoiceStatusList);
        return "invoice_status";
    }

    @PostMapping("/invoices-status/add-new")
    public String addInvoiceStatus(InvoiceStatus invoiceStatus){
        invoiceStatusService.saveInvoiceStatus(invoiceStatus);
        return "redirect:/invoices-status";
    }

    @RequestMapping("/invoices-status/find-by-id")
    @ResponseBody
    public Optional<InvoiceStatus> getInvoiceStatus(Integer id){
        return invoiceStatusService.getInvoiceStatusById(id);
    }

    @RequestMapping(value = "/invoices-status/update", method = {RequestMethod.GET, RequestMethod.POST})
    public String updateInvoiceStatus(InvoiceStatus invoiceStatus){
        invoiceStatusService.saveInvoiceStatus(invoiceStatus);
        return "redirect:/invoices-status";
    }

    @RequestMapping(value = "/invoices-status/delete", method = {RequestMethod.GET, RequestMethod.DELETE})
    public String deleteInvoiceStatus(Integer id){
        invoiceStatusService.deleteInvoiceStatusById(id);
        return "redirect:/invoices-status";
    }
}
