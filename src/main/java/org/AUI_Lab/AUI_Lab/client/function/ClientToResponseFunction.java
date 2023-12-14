package org.AUI_Lab.AUI_Lab.client.function;

import org.AUI_Lab.AUI_Lab.client.dto.GetClientResponse;
import org.AUI_Lab.AUI_Lab.client.entity.Client;

import java.util.function.Function;

public class ClientToResponseFunction implements Function<Client, GetClientResponse> {
    @Override
    public GetClientResponse apply(Client entity){
        return GetClientResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .surname(entity.getSurname())
                .clientAddress(entity.getClientAddress())
                .build();
    }
}
