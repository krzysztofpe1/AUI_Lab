package org.AUI_Lab.AUI_Lab.mics;

import jakarta.annotation.PostConstruct;
import org.AUI_Lab.AUI_Lab.client.entity.Client;
import org.AUI_Lab.AUI_Lab.client.service.ClientService;
import org.AUI_Lab.AUI_Lab.order.entity.Order;
import org.AUI_Lab.AUI_Lab.client.service.ClientService;
import org.AUI_Lab.AUI_Lab.order.service.OrderService;
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

        Client marcinStenka = Client.builder().id(UUID.fromString("c4804e0f-769e-4ab9-9ebe-0578fb4f00a1")).name("Marcin").surname("Stenka").clientAddress("Turzycowa 33").build();
        Client kubaStachowicz = Client.builder().id(UUID.fromString("c4804e0f-769e-4ab9-9ebe-0578fb4f00a2")).name("Kuba").surname("Stachowicz").clientAddress("Okopowa 12").build();
        Client oskarWilda = Client.builder().id(UUID.fromString("c4804e0f-769e-4ab9-9ebe-0578fb4f00a3")).name("Oskar").surname("Wilda").clientAddress("Wiejska 3").build();
        




        Order order1 = Order.builder()
                .id(UUID.fromString("c4804e0f-769e-4ab9-9ebe-0578fb4f00b1"))
                .name("Lizaki")
                .description("Stationary")
                .orderDate("2023-08-23")
                .deliveryDate("2023-08-26")
                .client(marcinStenka)
                .build();
        Order order2 = Order.builder()
                .id(UUID.fromString("c4804e0f-769e-4ab9-9ebe-0578fb4f00b2"))
                .name("Myszka")
                .description("Online")
                .orderDate("2023-01-21")
                .deliveryDate("2023-01-23")
                .client(marcinStenka)
                .build();
        Order order3 = Order.builder()
                .id(UUID.fromString("c4804e0f-769e-4ab9-9ebe-0578fb4f00b3"))
                .name("Herbata")
                .description("Online")
                .orderDate("2023-03-01")
                .deliveryDate("2023-03-02")
                .client(kubaStachowicz)
                .build();
        Order order4 = Order.builder()
                .id(UUID.fromString("c4804e0f-769e-4ab9-9ebe-0578fb4f00b4"))
                .name("Tasak")
                .description("Online")
                .orderDate("2023-11-20")
                .deliveryDate("2023-11-20")
                .client(oskarWilda)
                .build();
        Order order5 = Order.builder()
                .id(UUID.fromString("c4804e0f-769e-4ab9-9ebe-0578fb4f00b5"))
                .name("Czipsy")
                .description("Stationary")
                .orderDate("2023-12-12")
                .deliveryDate("2023-12-13")
                .client(kubaStachowicz)
                .build();
        List<Client> clients = List.of(marcinStenka, kubaStachowicz, oskarWilda);
        List<Order> orders = List.of(order1, order2, order3, order4, order5);

        for (Client client:clients) {
            clientService.addClient(client);
        }
        for (Order order:orders) {
            orderService.addOrder(order);
        }
    }
}