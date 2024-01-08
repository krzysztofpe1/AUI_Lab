package org.AUI_Lab.order.initialize;

import org.AUI_Lab.client.entity.Client;
import org.AUI_Lab.order.entity.Order;
import org.AUI_Lab.client.service.ClientService;
import org.AUI_Lab.order.service.OrderService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
@Component
public class InitializeData implements InitializingBean {
    private final OrderService orderService;
    private final ClientService clientService;
    @Autowired
    public InitializeData(OrderService orderService, ClientService clientService){
        this.orderService = orderService;
        this.clientService = clientService;
    }
    @Override
    public void afterPropertiesSet() throws Exception {
        if (orderService.findAll().isEmpty()){
            Client marcinStenka = Client.builder().id(UUID.fromString("c4804e0f-769e-4ab9-9ebe-0578fb4f00a1")).build();
            Client kubaStachowicz = Client.builder().id(UUID.fromString("c4804e0f-769e-4ab9-9ebe-0578fb4f00a2")).build();
            Client oskarWilda = Client.builder().id(UUID.fromString("c4804e0f-769e-4ab9-9ebe-0578fb4f00a3")).build();

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
}
