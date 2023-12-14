package org.AUI_Lab.client.service;

import org.AUI_Lab.client.entity.Client;
import org.AUI_Lab.client.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.AUI_Lab.client.event.repository.ClientEventRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public class ClientServiceImp implements ClientService{
    private final ClientRepository clientRepository;
    private final ClientEventRepository clientEventRepository;
    @Autowired
    public ClientServiceImp (ClientRepository clientRepository, ClientEventRepository clientEventRepository){
        this.clientRepository = clientRepository;
        this.clientEventRepository = clientEventRepository;
    }
    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }
    public Optional<Client> findById(UUID id) {
        return clientRepository.findById(id);
    }

    public void addClient(Client client){
        clientRepository.save(client);
        clientEventRepository.add(client);
    }
    public void updateClient(Client client){
        clientRepository.save(client);
    }

    public void deleteById(UUID id){
        if(clientRepository.findById(id).isPresent()){
            clientRepository.deleteById(id);
            clientEventRepository.delete(id);
        }
    }
}
