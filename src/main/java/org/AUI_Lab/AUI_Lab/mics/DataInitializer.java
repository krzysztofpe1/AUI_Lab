package org.AUI_Lab.AUI_Lab.mics;

import jakarta.annotation.PostConstruct;
import org.AUI_Lab.AUI_Lab.data_classes.Address;
import org.AUI_Lab.AUI_Lab.data_classes.Client;
import org.AUI_Lab.AUI_Lab.data_classes.Order;
import org.AUI_Lab.AUI_Lab.services.ClientService;
import org.AUI_Lab.AUI_Lab.services.OrderService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class DataInitializer implements InitializingBean {
    @Autowired
    private final ClientService clientService;
    @Autowired
    private final OrderService orderService;

    @Autowired
    public DataInitializer(ClientService clientService, OrderService orderService){
        this.clientService=clientService;
        this.orderService=orderService;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        clientService.deleteAllClients();
        orderService.deleteAllOrders();
        List<Order> janMlynarOrders = new ArrayList<>();
        List<Order> janBemarOrders = new ArrayList<>();
        Client janMlynar = Client.builder().id(UUID.randomUUID()).name("Jan").surname("Mlynar").deliveryAddress(new Address("Gdansk", "80-115", "Jasienska", 15,20)).orders(janMlynarOrders).build();
        Client janBemar = Client.builder().id(UUID.randomUUID()).name("Jan").surname("Bemar").deliveryAddress(new Address("Gdansk", "80-115", "Jasienska", 15,20)).orders(janBemarOrders).build();
        clientService.saveClient(janMlynar);
        clientService.saveClient(janBemar);
        //Jan Mlynar orders

        Order order1 = Order.builder()
                .id(UUID.randomUUID())
                .description("Stationary")
                .orderDate(new Date(2023, Calendar.OCTOBER, 23))
                .deliveryDate(new Date(2023, Calendar.OCTOBER, 26))
                .build();
        //ordersList.add(order1);
        Order order2 = Order.builder()
                .id(UUID.randomUUID())
                .description("Online")
                .orderDate(new Date(2023, Calendar.SEPTEMBER, 29))
                .deliveryDate(new Date(2023, Calendar.OCTOBER, 2))
                .build();
        //ordersList.add(order2);
        janMlynar.addOrder(order1);
        janMlynar.addOrder(order2);
        //Jan Bemar orders
        Order order3 = Order.builder()
                .id(UUID.randomUUID())
                .description("Online")
                .orderDate(new Date(2023, Calendar.SEPTEMBER, 27))
                .deliveryDate(new Date(2023, Calendar.SEPTEMBER, 30))
                .build();
        Order order4 = Order.builder()
                .id(UUID.randomUUID())
                .description("Online")
                .orderDate(new Date(2023,Calendar.OCTOBER, 22))
                .deliveryDate(new Date(2023, Calendar.OCTOBER, 26))
                .build();
        janBemar.addOrder(order3);
        janBemar.addOrder(order4);
        List<Order> ordersList = new ArrayList<>();
        ordersList.addAll(janBemar.getOrders());
        ordersList.addAll(janMlynar.getOrders());
        janBemar.addOrder(order3);
        janBemar.addOrder(order4);

        orderService.saveOrders(ordersList);
    }
}
