package org.AUI_Lab.AUI_Lab.client.repository;

import org.AUI_Lab.AUI_Lab.client.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ClientRepository extends JpaRepository<Client, UUID> {
    List<Client> findAll();
    Client findBySurname(String surname);
    Optional<Client> findById(UUID id);
}
