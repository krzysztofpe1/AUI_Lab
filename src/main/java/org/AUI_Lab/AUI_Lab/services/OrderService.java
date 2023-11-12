package org.AUI_Lab.AUI_Lab.services;

import org.AUI_Lab.AUI_Lab.data_classes.Client;
import org.AUI_Lab.AUI_Lab.data_classes.Order;

import java.util.List;

public interface OrderService {
    List<Order> getAllOrders();
    Order getOrderByClient(Client client);
    void saveOrder(Order item);
    void deleteOrder(Order item);
}
