package org.AUI_Lab.order.service;

import org.AUI_Lab.order.entity.Order;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OrderService {
    List<Order> findAll();
    Optional<List<Order>> findAllByClient(UUID clientId);
    Optional<Order> findById(UUID id);
    void addOrder(Order order);
    void updateOrder(Order order);
    void deleteById(UUID id);
}
