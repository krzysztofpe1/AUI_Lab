package org.AUI_Lab.AUI_Lab.client.controller;

import org.AUI_Lab.AUI_Lab.client.dto.GetClientResponse;
import org.AUI_Lab.AUI_Lab.client.dto.GetClientsResponse;
import org.AUI_Lab.AUI_Lab.client.dto.PatchClientRequest;
import org.AUI_Lab.AUI_Lab.client.dto.PutClientRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

public interface ClientController {
    @GetMapping("api/clients")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetClientsResponse getClients();

    @GetMapping("api/clients/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetClientResponse getClient(@PathVariable("id") UUID id);

    @PutMapping("/api/clients/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    void putClient(@PathVariable("id") UUID id, @RequestBody PutClientRequest request);

    @PatchMapping("/api/clients/{id}/update")
    @ResponseStatus(HttpStatus.OK)
    void patchClient(@PathVariable("id") UUID id, @RequestBody PatchClientRequest request);

    @DeleteMapping("/api/clients/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteClient(@PathVariable("id") UUID id);
}
