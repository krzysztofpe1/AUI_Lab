package org.AUI_Lab.AUI_Lab;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "clients")
public class Client implements Comparable<Client>, Serializable {
    @Id
    @GeneratedValue
    @Column(unique = true, updatable = false)
    private int id;
    private String name;
    private Address deliveryAddress;
    @Builder.Default
    private List<Order> orders = new ArrayList<>();

    @Override
    public int hashCode() {
        return Objects.hash(id, name, deliveryAddress);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Client client = (Client) obj;
        return id == client.id
                && name.equals(client.name)
                && deliveryAddress.equals(client.deliveryAddress);
    }

    @Override
    public int compareTo(Client other) {
        if(id != other.id)return id- other.id;
        if(!name.equals(other.name))return name.compareTo(other.name);
        if(!deliveryAddress.equals(other.deliveryAddress))return deliveryAddress.compareTo(other.deliveryAddress);
        return 0;
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder("Client{id='"
                + String.valueOf(id)
                + "', name='" + name
                + "', deliveryAddress='" + deliveryAddress.toString()+ "'");
        if(orders!= null && !orders.isEmpty()){
            stringBuilder.append(", orders={");
            boolean first = true;
            for (var order : orders) {
                if(!first){
                    stringBuilder.append(", ");
                }
                first=false;
                stringBuilder.append(order.toString());
            }
            stringBuilder.append("}");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public void addOrder(Order item){
        item.setClient(this);
        orders.add(item);
    }
}
