package com.example.seribit.controller;

import com.example.seribit.dto.ClientDTO;
import com.example.seribit.dto.javaxgroups.CreateGroup;
import com.example.seribit.dto.javaxgroups.UpdateGroup;
import com.example.seribit.entity.Client;
import com.example.seribit.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/seribit-api/clients")
public class ClientController {

    private final ClientService clientService;

    @GetMapping("/{clientId}")
    public ResponseEntity<Client> getClientById(@PathVariable Integer clientId) {
        return ResponseEntity.ok().body(clientService.getClientById(clientId));
    }

    @GetMapping
    public ResponseEntity<List<Client>> getAllClients() {
        return ResponseEntity.ok().body(clientService.getAllClients());
    }

    @PostMapping
    public ResponseEntity<Client> createClient(@RequestBody
                                               @Validated(CreateGroup.class)
                                               ClientDTO clientDTO) {
        Client newClient = clientService.createClient(clientDTO);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newClient.getClientId())
                .toUri();

        return ResponseEntity.created(uri).body(newClient);
    }

    @PutMapping("/{clientId}")
    public ResponseEntity<Client> updateClient(@PathVariable Integer clientId,
                                               @RequestBody
                                               @Validated(UpdateGroup.class)
                                               ClientDTO clientDTO) {
        return ResponseEntity.ok().body(clientService.updateClient(clientId, clientDTO));
    }

    @DeleteMapping("/{clientId}")
    public ResponseEntity<Client> deleteClient(@PathVariable Integer clientId) {
        clientService.deleteClient(clientId);
        return ResponseEntity.noContent().build();
    }
}
