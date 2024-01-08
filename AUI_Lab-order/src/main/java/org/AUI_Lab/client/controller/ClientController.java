package org.AUI_Lab.client.controller;

import org.AUI_Lab.client.dto.PutClientRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

public interface ClientController {
    @PutMapping("/api/clients/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    void putClient(@PathVariable("id") UUID id, @RequestBody PutClientRequest request);

    @DeleteMapping("/api/clients/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteClient(@PathVariable("id") UUID id);
}
