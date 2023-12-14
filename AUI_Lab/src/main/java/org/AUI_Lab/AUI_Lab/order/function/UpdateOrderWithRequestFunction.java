package org.AUI_Lab.AUI_Lab.order.function;

import org.AUI_Lab.AUI_Lab.order.dto.PatchOrderRequest;
import org.AUI_Lab.AUI_Lab.order.entity.Order;
import org.springframework.stereotype.Component;

import java.util.function.BiFunction;
@Component
public class UpdateOrderWithRequestFunction implements BiFunction<Order, PatchOrderRequest, Order> {
    @Override
    public Order apply(Order entity, PatchOrderRequest request){
        return Order.builder()
                .id(entity.getId())
                .name(request.getName())
                .description(request.getDescription())
                .orderDate(request.getOrderDate())
                .deliveryDate(request.getDeliveryDate())
                .client(entity.getClient())
                .build();
    }
}
