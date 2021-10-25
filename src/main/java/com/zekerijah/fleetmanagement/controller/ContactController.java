package com.zekerijah.fleetmanagement.controller;

import com.zekerijah.fleetmanagement.model.Contact;
import com.zekerijah.fleetmanagement.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping("/contacts")
    public String getContacts(Model model){
        List<Contact> contactList = contactService.getConcatcs();
        model.addAttribute("contacts", contactList);
        return "contact";
    }

    @PostMapping("/contacts/add-new")
    public String addContact(Contact contact){
        contactService.saveContact(contact);
        return "redirect:/contacts";
    }

    @RequestMapping("/contacts/find-by-id")
    @ResponseBody
    public Optional<Contact> getContact(Integer id){
        return contactService.getClientById(id);
    }

    @RequestMapping(value = "/contacts/update", method = {RequestMethod.GET, RequestMethod.PUT})
    public String updateContact(Contact contact){
        contactService.saveContact(contact);
        return "redirect:/contacts";
    }

    @RequestMapping(value = "/contacts/delete", method = {RequestMethod.GET, RequestMethod.PUT})
    public String deleteContact(Integer id){
        contactService.deleteContactById(id);
        return "redirect:/contacts";
    }


}
