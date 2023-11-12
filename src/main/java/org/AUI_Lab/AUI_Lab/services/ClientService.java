package org.AUI_Lab.AUI_Lab.services;

import org.AUI_Lab.AUI_Lab.data_classes.Client;
import org.AUI_Lab.AUI_Lab.repositories.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    private final ClientRepository clientRepository;
    public ClientService(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }
    List<Client> getAllClients(){
      return  clientRepository.findAll();
    }
//    Client getClientByName(String name, String surname);
//    void saveClient(Client item);
//    void deleteClient(Client item);
}
