package org.AUI_Lab.AUI_Lab.repositories;

import org.AUI_Lab.AUI_Lab.data_classes.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ClientRepository extends JpaRepository<Client, UUID> {
    List<Client> getClients();
    Client getClient(String surname);
}
