package org.AUI_Lab.AUI_Lab.dtos.client;

import lombok.*;
import org.AUI_Lab.AUI_Lab.data_classes.Address;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class GetClientCollectionDTO {
    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @ToString
    @EqualsAndHashCode
    private static class Client{
        private UUID id;
        private String name;
        private String surname;
        private Address deliveryAddress;
    }
    @Singular
    private List<Client> clients;
}
