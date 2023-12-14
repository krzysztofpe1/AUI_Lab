package org.AUI_Lab.AUI_Lab.client.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import org.AUI_Lab.AUI_Lab.order.entity.Order;
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
    private UUID id;
    @Column(name = "client_name")
    private String name;
    @Column(name = "client_surname")
    private  String surname;
    @Column(name = "client_address")
    private String clientAddress;
    @Builder.Default
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "client", cascade = CascadeType.REMOVE)
    private List<Order> orders = new ArrayList<>();

    @Override
    public int hashCode() {
        return Objects.hash(id, name, clientAddress);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Client client = (Client) obj;
        return id.equals(client.id)
                && name.equals(client.name)
                && clientAddress.equals(client.clientAddress);
    }

    @Override
    public int compareTo(Client other) {
        if(!id.equals(other.id))return id.compareTo(other.id);
        if(!name.equals(other.name))return name.compareTo(other.name);
        if(!clientAddress.equals(other.clientAddress))return clientAddress.compareTo(other.clientAddress);
        return 0;
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder("Client{id='"
                + String.valueOf(id)
                + "', name='" + name
                + "', surname='" + surname
                + "', deliveryAddress='" + clientAddress.toString()+ "'");
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
