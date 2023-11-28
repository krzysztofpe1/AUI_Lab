package org.AUI_Lab.AUI_Lab.mics;

import org.AUI_Lab.AUI_Lab.data_classes.Address;
import org.AUI_Lab.AUI_Lab.data_classes.Client;
import org.AUI_Lab.AUI_Lab.data_classes.Order;
import org.AUI_Lab.AUI_Lab.services.ClientService;
import org.AUI_Lab.AUI_Lab.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.CountDownLatch;

@Component
//Command Line Runner
public class CLR implements CommandLineRunner {

    private final ClientService clientService;
    private final OrderService orderService;

    public CLR(ClientService clientService, OrderService orderService){

        this.clientService = clientService;
        this.orderService = orderService;
    }
    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println(args);
        String command;
        String[] inputList;
        while (true){
            command = scanner.nextLine();
            inputList = command.split(" ");
            switch (inputList[0]){
                case "help" ->{
                    if(inputList.length > 1)
                    {
                        CLP.warningTooManyParameters("help");
                    }
                    System.out.println("help - show this view");
                    System.out.println("list {all|order|client|orders|clients}");
                    System.out.println("list all - list all records from clients and orders");
                    System.out.println("list order <Client's surname> - list orders of certain client");
                    System.out.println("list client <Client's surname - list one client");
                    System.out.println("list orders - list all orders");
                    System.out.println("list clients - list all clients");
                    System.out.println("add {client|order}");
                    System.out.println("add client - adds client");
                    System.out.println("add order - adds order");
                    System.out.println("delete {client|order}");
                    System.out.println("delete client - delete client with instructions");
                    System.out.println("delete order - delete order with instructions");
                    System.out.println("quit - stops the application");
                }
                case "list" ->{
                    if(inputList.length == 1){
                        CLP.errorTooFewParameters();
                        break;
                    }
                    switch (inputList[1]){
                        case "all"->{
                            System.out.println("Clients:");
                            clientService.findAllClients().forEach(System.out::println);
                            System.out.println("Orders: ");
                            orderService.getAllOrders().forEach(System.out::println);
                        }
                        case "order"->{
                            if(inputList.length<3){
                                CLP.error("You didn't specify Client's surname.");
                                break;
                            }
                            List<Order> orders = orderService.getOrderByClientsSurname(inputList[2]);
                            if(orders == null || orders.stream().count() == 0){
                                CLP.error("That client doesn't have orders");
                                break;
                            }
                            System.out.println("Orders: ");
                            orders.forEach(System.out::println);
                        }
                        case "orders"->{
                            if(inputList.length>2){
                                CLP.warningTooManyParameters("list orders");
                            }
                            System.out.println("Orders:");
                            var orders = orderService.getAllOrders();
                            System.out.println("Count: "+orders.size());
                            orders.forEach(System.out::println);
                        }
                        case "client"->{
                            if(inputList.length<3){
                                CLP.error("You didn't specify surname of client");
                                break;
                            }
                            Client client = clientService.findClientBySurname(inputList[2]);
                            if(client == null){
                                System.out.println("Such client doesn't exist.");
                                return;
                            }
                            System.out.println("Client:");
                            System.out.println(client);
                        }
                        case "clients"->{
                            if(inputList.length>2){
                                CLP.warningTooManyParameters("list clients");
                            }
                            System.out.println("Clients:");
                            var clients = clientService.findAllClients();
                            System.out.println("Count: "+ clients.size());
                            clients.forEach(System.out::println);
                        }
                        default -> {
                            CLP.error("Specify entries to list.");
                        }
                    }
                }
                case "add"->{
                    if(inputList.length<2){
                        CLP.errorTooFewParameters();
                    }
                    else if(inputList.length>2){
                        CLP.warningTooManyParameters("add "+inputList[1]);
                    }
                    switch (inputList[1]){
                        case "client"->{
                            System.out.println();
                            System.out.print("Name: ");
                            Client client = new Client();
                            client.setName(scanner.nextLine());
                            System.out.print("Surname: ");
                            client.setSurname(scanner.nextLine());
                            System.out.println("Delivery address: ");
                            System.out.print("City: ");
                            var city = scanner.nextLine();
                            System.out.print("Zip Code: ");
                            var zipCode = scanner.nextLine();
                            System.out.print("Street: ");
                            var street = scanner.nextLine();
                            System.out.print("House Number: ");
                            int houseNumber = Integer.parseUnsignedInt(scanner.next());
                            System.out.print("Apartment Number: ");
                            int apartmentNumber =  Integer.parseUnsignedInt(scanner.next());
                            Address address = new Address(city, zipCode, street, houseNumber, apartmentNumber);
                            client.setDeliveryAddress(address);
                            client.setId(UUID.randomUUID());
                            clientService.saveClient(client);
                        }
                        case "order"->{
                            System.out.println();
                            System.out.print("Description: ");
                            var description = scanner.nextLine();
                            System.out.println("DATE FORMAT: DD-Mon-YYYY");
                            System.out.print("Order date: ");
                            var orderDate = new Date(scanner.nextLine());
                            System.out.print("Delivery date: ");
                            var deliveryDate = new Date((scanner.nextLine()));
                            System.out.println("Choose client surname to assign the order to:");
                            var clients = clientService.findAllClients();
                            int i=0;
                            for (var client : clients) {
                                System.out.println(i++ + ": "+ client.getName()+" "+client.getSurname());
                            }
                            System.out.print("Client number to delete: ");
                            int index = Integer.parseUnsignedInt(scanner.next());
                            var client = clients.get(index);
                            var order = new Order();
                            order.setId(UUID.randomUUID());
                            order.setDescription(description);
                            order.setOrderDate(orderDate);
                            order.setDeliveryDate(deliveryDate);
                            order.setClient(client);
                            orderService.saveOrder(order);
                        }
                        default -> {
                            CLP.errorCommandDoesntExist(command);
                        }
                    }
                }
                case "delete"->{
                    if(inputList.length<2){
                        CLP.errorTooFewParameters();
                    }
                    switch (inputList[1]){
                        case "client"->{
                            System.out.println("List of clients:");
                            int i = 0;
                            var clients = clientService.findAllClients();
                            for (var client : clients) {
                                System.out.println(i++ + ": "+ client.getName()+" "+client.getSurname());
                            }
                            System.out.print("Client number to delete: ");
                            int index = Integer.parseUnsignedInt(scanner.next());
                            clientService.deleteClient(clients.get(index));
                            System.out.println("Client deleted.");
                        }
                        case "order"->{
                            System.out.println("List of orders:");
                            int i = 0;
                            var orders = orderService.getAllOrders();
                            for (var order : orders) {
                                System.out.println(i++ + ": "+ order);
                            }
                            System.out.print("Order number to delete: ");
                            int index = Integer.parseUnsignedInt(scanner.next());
                            orderService.deleteOrder(orders.get(index));
                            System.out.println("Order deleted.");
                        }
                        default -> {
                            CLP.errorCommandDoesntExist("delete "+inputList[1]);
                        }
                    }
                }
                case ""->{}
                default -> {
                    CLP.errorCommandDoesntExist(inputList[0]);
                }
            }
        }
    }
}
