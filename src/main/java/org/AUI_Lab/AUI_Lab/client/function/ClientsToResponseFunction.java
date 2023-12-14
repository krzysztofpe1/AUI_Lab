package org.AUI_Lab.AUI_Lab.client.function;

import org.AUI_Lab.AUI_Lab.client.dto.GetClientsResponse;
import org.AUI_Lab.AUI_Lab.client.entity.Client;

import java.util.List;
import java.util.function.Function;

public class ClientsToResponseFunction implements Function<List<Client>, GetClientsResponse> {
    @Override
    public GetClientsResponse apply(List<Client> entities){
        return GetClientsResponse.builder()
                .clients(entities.stream()
                        .map(client -> GetClientsResponse.Client.builder()
                                .id(client.getId())
                                .name(client.getName())
                                .surname(client.getName())
                                .clientAddress(client.getClientAddress())
                                .build())
                        .toList())
                .build();
    }
}
