package org.AUI_Lab.AUI_Lab.dtos.order;

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
public class GetOrderDTO {
    private UUID id;
    private String description;
    private Date orderDate;
    private Date deliveryDate;
    private int clientId;
}
