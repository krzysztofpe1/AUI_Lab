package org.AUI_Lab.AUI_Lab.services;

import org.AUI_Lab.AUI_Lab.data_classes.Order;
import org.AUI_Lab.AUI_Lab.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    @Autowired
    public OrderService(OrderRepository orderRepository){
        this.orderRepository=orderRepository;
    }
    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }
    /*public Order getOrderByClient(Client client);
    public void saveOrder(Order item);
    public void deleteOrder(Order item);*/
}
