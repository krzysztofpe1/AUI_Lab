package org.AUI_Lab.client.function;

import org.AUI_Lab.client.dto.PutClientRequest;
import org.AUI_Lab.client.entity.Client;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.function.BiFunction;

@Component
public class RequestToClientFunction implements BiFunction<UUID, PutClientRequest, Client> {
    @Override
    public Client apply(UUID id, PutClientRequest request){
        return Client.builder()
                .id(id)
                .name(request.getName())
                .surname(request.getSurname())
                .clientAddress(request.getClientAddress())
                .build();
    }
}
