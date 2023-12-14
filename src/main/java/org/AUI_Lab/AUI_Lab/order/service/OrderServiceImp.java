package org.AUI_Lab.AUI_Lab.order.service;

import org.AUI_Lab.AUI_Lab.client.repository.ClientRepository;
import org.AUI_Lab.AUI_Lab.order.entity.Order;
import org.AUI_Lab.AUI_Lab.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service

public class OrderServiceImp implements OrderService{
    private final OrderRepository orderRepository;
    private final ClientRepository clientRepository;
    @Autowired
    public OrderServiceImp(OrderRepository orderRepository, ClientRepository clientRepository) {
        this.orderRepository = orderRepository;
        this.clientRepository = clientRepository;
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Optional<List<Order>> findAllByClient(UUID clubId) {
        return clientRepository.findById(clubId)
                .map(orderRepository::findAllByClient);
    }

    public Order findByName(String name) {
        return orderRepository.findByName(name);
    }
    public Optional<Order> findById(UUID id){
        return orderRepository.findById(id);
    }

    public void addOrder(Order order){
        orderRepository.save(order);
    }

    public void updateOrder(Order order){ orderRepository.save(order);}
    public void deleteAll() {
        orderRepository.deleteAll();
    }
    public void deleteByName(String name) {
        Order order = orderRepository.findByName(name);
        orderRepository.delete(order);
    }
    public void deleteById(UUID id){
        if (orderRepository.findById(id).isPresent()){
            orderRepository.deleteById(id);
        }
    }


}
