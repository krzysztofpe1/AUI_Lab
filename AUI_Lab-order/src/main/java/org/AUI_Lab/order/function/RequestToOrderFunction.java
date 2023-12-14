package org.AUI_Lab.order.function;

import org.AUI_Lab.client.entity.Client;
import org.AUI_Lab.order.dto.PutOrderRequest;
import org.AUI_Lab.order.entity.Order;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.function.BiFunction;
@Component
public class RequestToOrderFunction implements BiFunction<UUID, PutOrderRequest, Order> {

    @Override
    public Order apply(UUID id, PutOrderRequest request){
        return Order.builder()
                .id(id)
                .name(request.getName())
                .description(request.getDescription())
                .orderDate(request.getOrderDate())
                .deliveryDate(request.getDeliveryDate())
                .client(Client.builder()
                        .id(request.getClient())
                        .build())
                .build();
    }
}
