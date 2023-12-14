package org.AUI_Lab.AUI_Lab.order.dto;


import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class PatchOrderRequest {
    private String description;
    private Date orderDate;
    private Date deliveryDate;
}
