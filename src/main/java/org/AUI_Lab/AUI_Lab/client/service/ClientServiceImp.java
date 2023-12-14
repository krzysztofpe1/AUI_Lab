package org.AUI_Lab.AUI_Lab.client.service;

import org.AUI_Lab.AUI_Lab.client.entity.Client;
import org.AUI_Lab.AUI_Lab.client.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ClientServiceImp implements ClientService{
    private final ClientRepository clientRepository;
    private final OrderService orderService;
    @Autowired
    public ClientServiceImp (ClientRepository clientRepository, OrderService orderService){
        this.clientRepository = clientRepository;
        this.orderService = orderService;
    }
    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }
    public Client findBySurname(String surname) {
        return clientRepository.findBySurname(surname);
    }
    public Optional<Client> findById(UUID id) {
        return clientRepository.findById(id);
    }

    public void addClient(Client client){
        clientRepository.save(client);
    }
    public void updateClient(Client client){
        clientRepository.save(client);
    }

    public void deleteAll() {
        clientRepository.deleteAll();
    }

    public void deleteById(UUID id){
        if(clientRepository.findById(id).isPresent()){
            clientRepository.deleteById(id);
        }
    }
}
