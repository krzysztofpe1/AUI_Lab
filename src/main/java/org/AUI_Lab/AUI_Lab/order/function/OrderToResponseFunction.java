package org.AUI_Lab.AUI_Lab.order.function;

import org.AUI_Lab.AUI_Lab.order.dto.GetOrderResponse;
import org.AUI_Lab.AUI_Lab.order.entity.Order;
import org.springframework.stereotype.Component;

import java.util.function.Function;
@Component
public class OrderToResponseFunction implements Function<Order, GetOrderResponse> {
    @Override
    public GetOrderResponse apply(Order entity){
        return GetOrderResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .orderDate(entity.getOrderDate())
                .deliveryDate(entity.getDeliveryDate())
                .client(GetOrderResponse.Client.builder()
                        .id(entity.getClient().getId())
                        .name(entity.getClient().getName())
                        .surname(entity.getClient().getSurname())
                        .clientAddress(entity.getClient().getClientAddress())
                        .build())
                .build();
    }
}
