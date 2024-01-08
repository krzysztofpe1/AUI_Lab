package org.AUI_Lab.client.event.repository;

import org.AUI_Lab.client.entity.Client;

import java.util.UUID;

public interface ClientEventRepository {
    void delete(UUID id);
    void add(Client client);
}
