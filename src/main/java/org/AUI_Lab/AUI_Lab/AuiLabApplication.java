package org.AUI_Lab.AUI_Lab;

import org.aspectj.weaver.ast.Or;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.*;
import java.util.*;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class AuiLabApplication {
	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
		//SpringApplication.run(AuiLabApplication.class, args);
		List<Order> janMlynarOrders = new ArrayList<>();
		List<Order> janBemarOrders = new ArrayList<>();
		Client janMlynar = Client.builder().id(0).name("Jan Młynar").deliveryAddress(new Address("Gdansk", "80-115", "Jasienska", 15,20)).orders(janMlynarOrders).build();
		Client janBemar = Client.builder().id(1).name("Jan Bemar").deliveryAddress(new Address("Gdansk", "80-115", "Jasienska", 15,20)).orders(janBemarOrders).build();
		//Jan Mlynar orders
		Order order1 = Order.builder()
				.id(0)
				.description("Stationary")
				.orderDate(new Date(2023, Calendar.OCTOBER, 23))
				.deliveryDate(new Date(2023, Calendar.OCTOBER, 26))
				.build();
		Order order2 = Order.builder()
				.id(1)
				.description("Online")
				.orderDate(new Date(2023, Calendar.SEPTEMBER, 29))
				.deliveryDate(new Date(2023, Calendar.OCTOBER, 2))
				.build();
		janMlynar.addOrder(order1);
		janMlynar.addOrder(order2);
		//Jan Bemar orders
		Order order3 = Order.builder()
				.id(3)
				.description("Online")
				.orderDate(new Date(2023, Calendar.SEPTEMBER, 27))
				.deliveryDate(new Date(2023, Calendar.SEPTEMBER, 30))
				.build();
		Order order4 = Order.builder()
				.id(4)
				.description("Online")
				.orderDate(new Date(2023,Calendar.OCTOBER, 22))
				.deliveryDate(new Date(2023, Calendar.OCTOBER, 26))
				.build();
		janBemar.addOrder(order3);
		janBemar.addOrder(order4);

		List<Client> clientsList = new ArrayList<>();
		clientsList.add(janMlynar);
		clientsList.add(janBemar);
		clientsList.forEach(System.out::println);

		//Excercise 3
		System.out.println("Excercise 3");
		List<Order> allOrdersList = new ArrayList<>();
		clientsList.stream().forEach(client -> allOrdersList.addAll(client.getOrders()));
		allOrdersList.stream().forEach(System.out::println);

		//Excercise 4
		System.out.println("Excercise 4");
		allOrdersList.stream()
				.filter(order -> order.getDeliveryDate().equals(new Date(2023, Calendar.OCTOBER, 26)))
				.sorted((o1, o2) -> o1.getDescription().compareTo(o2.getDescription()))
				.forEach(System.out::println);

		//Excercise 5
		System.out.println("Excercise 5");
		List<OrderDTO> orderDTOList = allOrdersList.stream()
				.map(order -> OrderDTO.builder()
						.id(order.getId())
						.description(order.getDescription())
						.orderDate(order.getOrderDate())
						.deliveryDate(order.getDeliveryDate())
						.clientId(order.getClient().getId())
						.build())
				.sorted(Comparator.comparing(OrderDTO::getId))
				.toList();
		orderDTOList.stream().forEach(System.out::println);

		//Excercise 6
		System.out.println("Excercise 6");
		System.out.println("serializing");
		ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("clients.bin"));
		outputStream.writeObject(clientsList);

		System.out.println("deserializing");
		List<Client> deserializedClientsList = new ArrayList<>();
		ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("clients.bin"));
		deserializedClientsList = (List<Client>) inputStream.readObject();

		deserializedClientsList.forEach(System.out::println);

		//Excercise 7
		System.out.println("Excercise 7");
		ForkJoinPool pool = new ForkJoinPool(2);
		deserializedClientsList.parallelStream()
				.forEach(client -> {
					pool.execute(()->{
						client.getOrders().forEach(order -> {
							System.out.println(order);
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								throw new RuntimeException(e);
							}
						});
					});
				});
		pool.awaitQuiescence(10, TimeUnit.SECONDS);
		pool.shutdown();
	}
}
