package org.AUI_Lab.AUI_Lab.dtos;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class OrderDTO implements Comparable<OrderDTO>, Serializable {
    private int id;
    private String description;
    private Date orderDate;
    private Date deliveryDate;
    private int clientId;

    @Override
    public int compareTo(OrderDTO other) {
        if(id!=other.id)return id-other.id;
        if(!description.equals(other.description))return description.compareTo(other.description);
        if(!orderDate.equals(other.orderDate))return orderDate.compareTo(other.orderDate);
        if(!deliveryDate.equals(other.deliveryDate))return deliveryDate.compareTo(other.deliveryDate);
        return 0;
    }
    @Override
    public String toString(){
        return "OrderDTO{id='" + String.valueOf(id) + "', description='" + description + "', orderDate='" + orderDate.toString() + "', deliveryDate='" +deliveryDate.toString()+"', clientId='" + clientId + "}";
    }
}
