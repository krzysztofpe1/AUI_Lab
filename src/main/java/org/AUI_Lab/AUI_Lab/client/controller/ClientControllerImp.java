package org.AUI_Lab.AUI_Lab.client.controller;

import org.AUI_Lab.AUI_Lab.client.dto.GetClientResponse;
import org.AUI_Lab.AUI_Lab.client.dto.GetClientsResponse;
import org.AUI_Lab.AUI_Lab.client.dto.PatchClientRequest;
import org.AUI_Lab.AUI_Lab.client.dto.PutClientRequest;
import org.AUI_Lab.AUI_Lab.client.function.ClientToResponseFunction;
import org.AUI_Lab.AUI_Lab.client.function.ClientsToResponseFunction;
import org.AUI_Lab.AUI_Lab.client.function.RequestToClientFunction;
import org.AUI_Lab.AUI_Lab.client.function.UpdateClientWithRequestFunction;
import org.AUI_Lab.AUI_Lab.client.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

public class ClientControllerImp implements ClientController{

    private final ClientService clientService;
    private final ClientToResponseFunction clientToResponse;
    private final ClientsToResponseFunction clientsToResponse;
    private final RequestToClientFunction requestToClient;
    final UpdateClientWithRequestFunction updateClientWithRequest;

    @Autowired
    public ClientControllerImp(ClientService clientService, ClientToResponseFunction clientToResponse, ClientsToResponseFunction clientsToResponse, RequestToClientFunction requestToClient, UpdateClientWithRequestFunction updateClientWithRequest){
            this.clientService = clientService;
            this.clientToResponse = clientToResponse;
            this.clientsToResponse = clientsToResponse;
            this.requestToClient = requestToClient;
            this.updateClientWithRequest = updateClientWithRequest;
        }

        @Override
        public GetClientsResponse getClients() {
            return clientsToResponse.apply(clientService.findAll());
        }

        @Override
        public GetClientResponse getClient(UUID id) {
            return clientService.findById(id)
                    .map(clientToResponse)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        }

        @Override
        public void putClient(UUID id, PutClientRequest request) {
            clientService.addClient(requestToClient.apply(id, request));
        }
        @Override
        public void patchClient(UUID id, PatchClientRequest request){
            clientService.updateClient(updateClientWithRequest.apply(clientService.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)), request));
        }
        @Override
        public void deleteClient(UUID id) {
            clientService.findById(id).ifPresentOrElse(
                    client -> clientService.deleteById(id), () -> {throw new ResponseStatusException(HttpStatus.NOT_FOUND);}
            );

        }
}
