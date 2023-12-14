package org.AUI_Lab.AUI_Lab.order.repository;

import org.AUI_Lab.AUI_Lab.client.entity.Client;
import org.AUI_Lab.AUI_Lab.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface OrderRepository extends JpaRepository<Order, UUID> {
    Order findByName(String name);

    List<Order> findAllByClient(Client client);
}
