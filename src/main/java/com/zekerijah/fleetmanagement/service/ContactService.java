package com.zekerijah.fleetmanagement.service;

import com.zekerijah.fleetmanagement.model.Contact;
import com.zekerijah.fleetmanagement.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public List<Contact> getConcatcs(){
        return contactRepository.findAll();
    }

    public void saveContact(Contact contact){
        contactRepository.save(contact);
    }

    public Optional<Contact> getClientById(Integer id){
        return contactRepository.findById(id);
    }

    public void deleteContactById(Integer id) {
        contactRepository.deleteById(id);
    }
}
