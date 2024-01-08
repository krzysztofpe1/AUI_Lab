package org.AUI_Lab.client.entity;

import jakarta.persistence.*;
import lombok.*;
import org.AUI_Lab.order.entity.Order;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "clubs")
public class Client implements Serializable {
    @Id
    private UUID id;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "client", cascade = CascadeType.REMOVE)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Order> players = new ArrayList<Order>();
}