package com.zekerijah.fleetmanagement.service;

import com.zekerijah.fleetmanagement.model.Client;
import com.zekerijah.fleetmanagement.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getClients(){
        return clientRepository.findAll();
    }

    public void saveClient (Client client) {
        clientRepository.save(client);
    }

    public Optional<Client> getClientById(Integer id){
        return clientRepository.findById(id);
    }

    public void deleteClientById(Integer id) {
        clientRepository.deleteById(id);
    }
}
