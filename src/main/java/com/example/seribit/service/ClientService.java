package com.example.seribit.service;

import com.example.seribit.dto.ClientDTO;
import com.example.seribit.dto.javaxgroups.AllAttributesNullCheckGroup;
import com.example.seribit.entity.Client;
import com.example.seribit.exception.EntityNotFoundException;
import com.example.seribit.mapper.ClientMapper;
import com.example.seribit.repository.ClientRepository;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;
    private final Validator validator;

    public Client getClientById(Integer clientId) {
        Optional<Client> clientOptional = clientRepository.findById(clientId);
        return clientOptional.orElseThrow(() -> new EntityNotFoundException("O cliente não foi encontrado!"));
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Client createClient(ClientDTO clientDTO) {
        Client newClient = clientMapper.mapFromDtoToEntity(clientDTO);
        return clientRepository.save(newClient);
    }

    public Client updateClient(Integer clientId, ClientDTO clientDTO) {
        Client client = getClientById(clientId);

        if (!allAttributesAreNull(clientDTO)) {
            clientMapper.updateEntity(clientDTO, client);
        }

        return clientRepository.save(client);
    }

    private boolean allAttributesAreNull(ClientDTO clientDTO) {
        Set<ConstraintViolation<ClientDTO>> violations =
                validator.validate(clientDTO, AllAttributesNullCheckGroup.class);

        return violations.size() == 10;
    }

    public void deleteClient(Integer clientId) {
        Client client = getClientById(clientId);
        clientRepository.delete(client);
    }
}
