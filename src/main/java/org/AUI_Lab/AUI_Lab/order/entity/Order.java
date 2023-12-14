package org.AUI_Lab.AUI_Lab.order.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;
import org.AUI_Lab.AUI_Lab.client.entity.Client;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "orders")
public class Order implements Comparable<Order>, Serializable {
    @Id
    private UUID id;
    @Column(name = "description")
    private String description;
    @Column(name = "order_date")
    @Temporal(TemporalType.DATE)
    private Date orderDate;
    @Column(name = "delivery_date")
    @Temporal(TemporalType.DATE)
    private Date deliveryDate;
    @ManyToOne
    @JoinColumn(name = "client")
    private Client client;

    @Override
    public int hashCode() {
        return Objects.hash(id, description, orderDate, deliveryDate);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Order order = (Order) obj;
        return id.equals(order.id) && Objects.equals(description, order.description)
                && Objects.equals(orderDate, order.orderDate)
                && Objects.equals(deliveryDate, order.deliveryDate);
    }

    @Override
    public int compareTo(Order other) {
        if(!id.equals(other.id))return id.compareTo(other.id);
        if(!description.equals(other.description))return description.compareTo(other.description);
        if(!orderDate.equals(other.orderDate))return orderDate.compareTo(other.orderDate);
        if(!deliveryDate.equals(other.deliveryDate))return deliveryDate.compareTo(other.deliveryDate);
        return 0;
    }

    @Override
    public String toString(){
        return "Order{id='" + String.valueOf(id) + "', description='" + description + "', orderDate='" + orderDate.toString() + "', deliveryDate='" +deliveryDate.toString()+"'}";
    }
}
