package org.AUI_Lab.AUI_Lab.client.function;

import org.AUI_Lab.AUI_Lab.client.dto.PatchClientRequest;
import org.AUI_Lab.AUI_Lab.client.entity.Client;
import java.util.function.BiFunction;
public class UpdateClientWithRequestFunction implements BiFunction<Client, PatchClientRequest, Client>{
    @Override
    public Client apply(Client entity, PatchClientRequest request){
        return Client.builder()
                .id(entity.getId())
                .name(request.getName())
                .surname(request.getSurname())
                .clientAddress(request.getClientAddress())
                .build();
    }
}
