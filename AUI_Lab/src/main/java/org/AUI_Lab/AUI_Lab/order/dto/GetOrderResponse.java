package org.AUI_Lab.AUI_Lab.order.dto;

import lombok.*;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class GetOrderResponse {
    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @ToString
    @EqualsAndHashCode
    public static class Client{
        private UUID id;
        private String name;
        private String surname;
        private String clientAddress;
    }
    private UUID id;
    private String name;
    private String description;
    private String orderDate;
    private String deliveryDate;
    private Client client;
}
