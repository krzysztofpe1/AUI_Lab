package org.AUI_Lab.AUI_Lab.client.service;

import org.AUI_Lab.AUI_Lab.client.entity.Client;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClientService {
    List<Client> findAll();
    Optional<Client> findById(UUID id);
    void addClient(Client client);
    void updateClient(Client client);
    void deleteById(UUID id);
}
