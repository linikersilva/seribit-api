package com.example.seribit.mapper;

import com.example.seribit.dto.ClientDTO;
import com.example.seribit.entity.Address;
import com.example.seribit.entity.Client;
import com.example.seribit.entity.Phone;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ClientMapper {

    private final ModelMapper modelMapper;

    public Client mapFromDtoToEntity(ClientDTO clientDTO) {
        Client client = modelMapper.map(clientDTO, Client.class);
        client.setAddress(Address.builder()
                                 .street(clientDTO.getStreet())
                                 .number(clientDTO.getNumber())
                                 .neighborhood(clientDTO.getNeighborhood())
                                 .state(clientDTO.getState().toUpperCase())
                                 .cep(clientDTO.getCep())
                                 .complement(clientDTO.getComplement())
                                 .build()
        );
        client.setPhone(Phone.builder()
                             .phone(clientDTO.getPhone())
                             .ddd(clientDTO.getDdd())
                             .build()
        );
        return client;
    }

    public void updateEntity(ClientDTO clientDTO, Client client) {
        client.setName(Optional.ofNullable(clientDTO.getName()).orElse(client.getName()));
        client.setEmail(Optional.ofNullable(clientDTO.getEmail()).orElse(client.getEmail()));
        client.setCpfCnpj(Optional.ofNullable(clientDTO.getCpfCnpj()).orElse(client.getCpfCnpj()));

        Address address = client.getAddress();
        address.setStreet(Optional.ofNullable(clientDTO.getStreet()).orElse(address.getStreet()));
        address.setNumber(Optional.ofNullable(clientDTO.getNumber()).orElse(address.getNumber()));
        address.setNeighborhood(Optional.ofNullable(clientDTO.getNeighborhood()).orElse(address.getNeighborhood()));
        address.setState(Optional.ofNullable(clientDTO.getState()).orElse(address.getState()));
        address.setCep(Optional.ofNullable(clientDTO.getCep()).orElse(address.getCep()));
        address.setComplement(Optional.ofNullable(clientDTO.getComplement()).orElse(address.getComplement()));

        Phone phone = client.getPhone();
        phone.setPhone(Optional.ofNullable(clientDTO.getPhone()).orElse(phone.getPhone()));
        phone.setDdd(Optional.ofNullable(clientDTO.getDdd()).orElse(phone.getDdd()));
    }
}
