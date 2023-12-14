package org.AUI_Lab.AUI_Lab.client.controller;

import org.AUI_Lab.AUI_Lab.client.function.ClientToResponseFunction;
import org.AUI_Lab.AUI_Lab.client.function.ClientsToResponseFunction;
import org.AUI_Lab.AUI_Lab.client.function.RequestToClientFunction;
import org.AUI_Lab.AUI_Lab.client.function.UpdateClientWithRequestFunction;
import org.springframework.beans.factory.annotation.Autowired;

public class ClientControllerImp implements ClientController{

    private final ClientService clubService;
    private final ClientToResponseFunction clientToResponse;
    private final ClientsToResponseFunction clientsToResponse;
    private final RequestToClientFunction requestToClient;
    final UpdateClientWithRequestFunction updateClientWithRequest;

    @Autowired
    public ClientControllerImp(ClientService clientService, ClientToResponseFunction clientToResponse, ClientsToResponseFunction clientsToResponse, RequestToClubFunction requestToClient, UpdateClientWithRequestFunction updateClientWithRequest){
            this.clientService = clientService;
            this.clientToResponse = clientToResponse;
            this.clientsToResponse = clientsToResponse;
            this.requestToClient = requestToClient;
            this.updateClientWithRequest = updateClientWithRequest;
        }

        @Override
        public GetClubsResponse getClubs() {
            return clubsToResponse.apply(clubService.findAll());
        }

        @Override
        public GetClubResponse getClub(UUID id) {
            return clubService.findById(id)
                    .map(clubToResponse)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        }

        @Override
        public void putClub(UUID id, PutClubRequest request) {
            clubService.addClub(requestToClub.apply(id, request));
        }
        @Override
        public void patchClub(UUID id, PatchClubRequest request){
            clubService.updateClub(updateClubWithRequest.apply(clubService.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)), request));
        }
        @Override
        public void deleteClub(UUID id) {
            clubService.findById(id).ifPresentOrElse(
                    club -> clubService.deleteById(id), () -> {throw new ResponseStatusException(HttpStatus.NOT_FOUND);}
            );

        }
}
