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
public class PutOrderRequest {
    private String name;
    private String description;
    private Date orderDate;
    private Date deliveryDate;
    private UUID client;
}
