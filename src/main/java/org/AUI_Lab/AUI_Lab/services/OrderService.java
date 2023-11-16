package org.AUI_Lab.AUI_Lab.services;

import org.AUI_Lab.AUI_Lab.data_classes.Order;
import org.AUI_Lab.AUI_Lab.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private final OrderRepository orderRepository;
    @Autowired
    public OrderService(OrderRepository orderRepository){
        this.orderRepository=orderRepository;
    }
    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }
    public List<Order> getOrderByClientsSurname(String surname){return new ArrayList<>();}
    public void saveOrder(Order order){orderRepository.save(order);}
    public void saveOrders(List<Order> orderList){orderList.forEach(orderRepository::save);}
    public void deleteAllOrders(){orderRepository.deleteAll();}
    public void deleteOrder(Order order){orderRepository.delete(order);}
    /*public Order getOrderByClient(Client client);
    public void saveOrder(Order item);
    public void deleteOrder(Order item);*/
}
