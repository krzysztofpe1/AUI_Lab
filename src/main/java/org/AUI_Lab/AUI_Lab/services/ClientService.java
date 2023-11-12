package org.AUI_Lab.AUI_Lab.services;

import org.AUI_Lab.AUI_Lab.data_classes.Client;

import java.util.List;

public interface ClientService {
    List<Client> getAllClients();
    Client getClientByName(String name, String surname);
    void saveClient(Client item);
    void deleteClient(Client item);
}
