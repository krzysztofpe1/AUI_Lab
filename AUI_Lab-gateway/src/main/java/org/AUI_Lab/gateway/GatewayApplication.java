package org.AUI_Lab.gateway;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
@SpringBootApplication
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}
	@Bean
	public RouteLocator routeLocator(
			RouteLocatorBuilder builder,
			@Value("${AUI_Lab-order.url}") String orderUrl,
			@Value("${AUI_Lab-client.url}") String clientUrl,
			@Value("${AUI_Lab-gateway.host}") String host
	) {
		return builder
				.routes()
				.route("orders", route -> route
						.host(host)
						.and()
						.path("/api/orders/{uuid}","/api/orders","/api/clients/{uuid}/orders")
						.uri(orderUrl)
				)
				.route("clients", route -> route
						.host(host)
						.and()
						.path("/api/clients/{uuid}","/api/clients")
						.uri(clientUrl)
				)
				.build();
	}
}
