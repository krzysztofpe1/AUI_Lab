package org.AUI_Lab.AUI_Lab.order.service;

import org.AUI_Lab.AUI_Lab.order.entity.Order;
import org.AUI_Lab.AUI_Lab.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OrderService {
    List<Order> findAll();
    Optional<List<Order>> findAllByClient(UUID clientId);
    Optional<Order> findById(UUID id);
    Order findByName(String name);
    void addOrder(Order player);
    void updateOrder(Order player);
    void deleteAll();
    void deleteByName(String name);
    void deleteById(UUID id);
}
