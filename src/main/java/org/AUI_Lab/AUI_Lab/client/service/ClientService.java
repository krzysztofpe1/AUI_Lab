package org.AUI_Lab.AUI_Lab.services;

import org.AUI_Lab.AUI_Lab.data_classes.Client;
import org.AUI_Lab.AUI_Lab.repositories.ClientRepository;
import org.AUI_Lab.AUI_Lab.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ClientService {
    private final ClientRepository clientRepository;
    private final OrderRepository orderRepository;
    @Autowired
    public ClientService(ClientRepository clientRepository, OrderRepository orderRepository){
        this.clientRepository = clientRepository;
        this.orderRepository = orderRepository;
    }
    public List<Client> findAllClients(){
      return  clientRepository.findAll();
    }
    public Client findClientBySurname(String lastname){return clientRepository.findClientBySurname(lastname);}
    Client findClientById(UUID id){
        try {
            var client = clientRepository.findById(id).get();
            return client;
        }
        catch (Exception ex){}
        return null;
    }
    public void saveClient(Client client){
        clientRepository.save(client);
    }
    public void deleteClient(Client client){
        clientRepository.delete(client);
    }
    public void deleteAllClients(){clientRepository.deleteAll();}
    public void deleteClientById(UUID id){
        clientRepository.deleteById(id);
    }
}
