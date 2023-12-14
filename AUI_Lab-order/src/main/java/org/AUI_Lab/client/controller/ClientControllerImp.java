package org.AUI_Lab.client.controller;


import org.AUI_Lab.client.dto.PutClientRequest;
import org.AUI_Lab.client.function.RequestToClientFunction;
import org.AUI_Lab.client.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;
@RestController
public class ClientControllerImp implements ClientController{
    private final ClientService clientService;
    private final RequestToClientFunction requestToClient;

    @Autowired
    public ClientControllerImp(ClientService clientService, RequestToClientFunction requestToClient){
        this.clientService = clientService;
        this.requestToClient = requestToClient;

    }

    @Override
    public void putClient(UUID id, PutClientRequest request) {
        clientService.addClient(requestToClient.apply(id, request));
    }


    @Override
    public void deleteClient(UUID id) {
        clientService.findById(id).ifPresentOrElse(
                client -> clientService.deleteById(id), () -> {throw new ResponseStatusException(HttpStatus.NOT_FOUND);}
        );

    }
}
