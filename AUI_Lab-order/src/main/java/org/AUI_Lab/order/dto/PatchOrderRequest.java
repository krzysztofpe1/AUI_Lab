package org.AUI_Lab.order.dto;


import lombok.*;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class PatchOrderRequest {
    private String name;
    private String description;
    private String orderDate;
    private String deliveryDate;
}
