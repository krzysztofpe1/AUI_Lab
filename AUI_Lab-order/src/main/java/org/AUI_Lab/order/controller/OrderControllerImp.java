package org.AUI_Lab.order.controller;

import org.AUI_Lab.order.dto.GetOrdersResponse;
import org.AUI_Lab.order.dto.GetOrderResponse;
import org.AUI_Lab.order.dto.PatchOrderRequest;
import org.AUI_Lab.order.dto.PutOrderRequest;
import org.AUI_Lab.order.function.OrderToResponseFunction;
import org.AUI_Lab.order.function.OrdersToResponseFunction;
import org.AUI_Lab.order.function.RequestToOrderFunction;
import org.AUI_Lab.order.function.UpdateOrderWithRequestFunction;
import org.AUI_Lab.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;
@RestController

public class OrderControllerImp implements OrderController {
    private final OrderService orderService;
    private final OrderToResponseFunction orderToResponse;
    private final OrdersToResponseFunction ordersToResponse;
    private final RequestToOrderFunction requestToOrder;
    private final UpdateOrderWithRequestFunction updateOrderWithRequest;
    @Autowired
    public OrderControllerImp(OrderService orderService, OrderToResponseFunction orderToResponse, OrdersToResponseFunction ordersToResponse, RequestToOrderFunction requestToOrder, UpdateOrderWithRequestFunction updateOrderWithRequest) {
        this.orderService = orderService;
        this.orderToResponse = orderToResponse;
        this.ordersToResponse = ordersToResponse;
        this.requestToOrder = requestToOrder;
        this.updateOrderWithRequest = updateOrderWithRequest;
    }
    @Override
    public GetOrdersResponse getOrders(){
        System.out.println("AAAAAAAA");

        return ordersToResponse.apply(orderService.findAll());
    }

    @Override
    public GetOrdersResponse getClientOrders(UUID clientId) {
        return orderService.findAllByClient(clientId)
                .map(ordersToResponse)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public GetOrderResponse getOrder(UUID id) {
        return orderService.findById(id)
                .map(orderToResponse)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public void putOrder(UUID id, PutOrderRequest request) {
        orderService.addOrder(requestToOrder.apply(id, request));
    }

    @Override
    public void patchOrder(UUID id, PatchOrderRequest request) {
        orderService.updateOrder(updateOrderWithRequest.apply(orderService.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)), request));
    }

    @Override
    public void deleteOrder(UUID id) {
        orderService.findById(id)
                .ifPresentOrElse(
                        order -> orderService.deleteById(id),
                        () -> {throw new ResponseStatusException(HttpStatus.NOT_FOUND);}
                );
    }
}
