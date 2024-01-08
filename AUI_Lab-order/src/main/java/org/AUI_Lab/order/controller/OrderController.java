package org.AUI_Lab.order.controller;

import org.AUI_Lab.order.dto.GetOrderResponse;
import org.AUI_Lab.order.dto.GetOrdersResponse;
import org.AUI_Lab.order.dto.PatchOrderRequest;
import org.AUI_Lab.order.dto.PutOrderRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

public interface OrderController {
    @GetMapping("/api/orders")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetOrdersResponse getOrders();

    @GetMapping("/api/clients/{clientId}/orders")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetOrdersResponse getClientOrders(@PathVariable("clientId") UUID clientId);

    @GetMapping("/api/orders/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetOrderResponse getOrder(@PathVariable("id") UUID id);

    @PutMapping("/api/orders/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    void putOrder(@PathVariable("id") UUID id, @RequestBody PutOrderRequest request);

    @PatchMapping("/api/orders/{id}/update")
    @ResponseStatus(HttpStatus.OK)
    void patchOrder( @PathVariable("id") UUID id, @RequestBody PatchOrderRequest request);

    @DeleteMapping("/api/orders/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteOrder(@PathVariable("id") UUID id);
}
