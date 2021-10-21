package com.zekerijah.fleetmanagement.controller;

import com.zekerijah.fleetmanagement.model.Client;
import com.zekerijah.fleetmanagement.model.Invoice;
import com.zekerijah.fleetmanagement.model.InvoiceStatus;
import com.zekerijah.fleetmanagement.service.ClientService;
import com.zekerijah.fleetmanagement.service.InvoiceService;
import com.zekerijah.fleetmanagement.service.InvoiceStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @Autowired
    private InvoiceStatusService invoiceStatusService;

    @Autowired
    private ClientService clientService;

    @GetMapping("/invoices")
    public String getInvoices(Model model){
        List<Invoice> invoiceList = invoiceService.getInvoices();
        List<InvoiceStatus> invoiceStatusList = invoiceStatusService.getInvoicesStatuses();
        List<Client> clientList = clientService.getClients();

        model.addAttribute("invoices", invoiceList);
        model.addAttribute("invoicesStatuses", invoiceStatusList);
        model.addAttribute("clients", clientList);

        return "invoice";
    }

    @PostMapping("/invoices/add-new")
    public String addInvoice(Invoice invoice){
        invoiceService.saveInvoice(invoice);
        return "redirect:/invoices";
    }

    @RequestMapping("/invoices/find-by-id")
    @ResponseBody
    public Optional<Invoice> getInvoice(Integer id){
        return invoiceService.getInvoiceById(id);
    }

    @RequestMapping(value = "/invoices/update", method ={RequestMethod.GET, RequestMethod.PUT})
    public String updateInvoice(Invoice invoice){
        invoiceService.saveInvoice(invoice);
        return "redirect:/invoices";
    }

    @RequestMapping(value = "/invoices/delete", method = {RequestMethod.GET, RequestMethod.DELETE})
    public String deleteInvoice(Integer id){
        invoiceService.deleteInvoiceById(id);
        return "redirect:/invoices";
    }
}
