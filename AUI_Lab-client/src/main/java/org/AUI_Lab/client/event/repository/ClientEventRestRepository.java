package org.AUI_Lab.client.event.repository;

import org.AUI_Lab.client.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;
@Repository
public class ClientEventRestRepository implements ClientEventRepository {
    private final RestTemplate restTemplate;
    @Autowired
    public ClientEventRestRepository(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }
    @Override
    public void delete(UUID id) {
        restTemplate.delete("/api/clients/{id}", id);
    }
    @Override
    public void add(Client client) {
        restTemplate.put("/api/clients/{id}", client, client.getId());
    }
}
