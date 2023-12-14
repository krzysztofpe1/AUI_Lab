package org.AUI_Lab.order.function;

import org.AUI_Lab.order.dto.GetOrdersResponse;
import org.AUI_Lab.order.entity.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;
@Component
public class OrdersToResponseFunction implements Function<List<Order>, GetOrdersResponse> {
    @Override
    public GetOrdersResponse apply(List<Order> entities){
        return GetOrdersResponse.builder()
                .orders(entities.stream()
                        .map(order -> GetOrdersResponse.Order.builder()
                                .id(order.getId())
                                .name(order.getName())
                                .description(order.getDescription())
                                .orderDate(order.getOrderDate())
                                .deliveryDate(order.getDeliveryDate())
                                .build())
                        .toList())
                .build();
    }
}
