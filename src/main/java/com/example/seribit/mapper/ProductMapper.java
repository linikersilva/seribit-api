package com.example.seribit.mapper;

import com.example.seribit.dto.ProductDTO;
import com.example.seribit.entity.Client;
import com.example.seribit.entity.Product;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ProductMapper {

    private final ModelMapper modelMapper;

    public Product mapFromDtoToEntity(ProductDTO productDTO, Client client) {
        Product product = modelMapper.map(productDTO, Product.class);
        product.setClient(client);
        return product;
    }

    public void updateEntity(ProductDTO productDTO, Product product, Client client) {
        product.setName(Optional.ofNullable(productDTO.getName()).orElse(product.getName()));
        product.setPrice(Optional.ofNullable(productDTO.getPrice()).orElse(product.getPrice()));
        product.setClient(client);
    }
}
