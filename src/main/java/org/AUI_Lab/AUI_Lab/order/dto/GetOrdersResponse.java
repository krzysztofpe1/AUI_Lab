package org.AUI_Lab.AUI_Lab.order.dto;


import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class GetOrdersResponse {
    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @ToString
    @EqualsAndHashCode
    public static class Order{
        private UUID id;
        private String name;
        private String description;
        private String orderDate;
        private String deliveryDate;
    }
    @Singular
    private List<Order> orders;
}
