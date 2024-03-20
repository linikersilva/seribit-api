package com.example.seribit.service;

import com.example.seribit.dto.ProductDTO;
import com.example.seribit.dto.javaxgroups.AllAttributesNullCheckGroup;
import com.example.seribit.entity.Client;
import com.example.seribit.entity.Product;
import com.example.seribit.exception.handler.EntityNotFoundException;
import com.example.seribit.mapper.ProductMapper;
import com.example.seribit.repository.ProductRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ClientService clientService;
    private final ProductMapper productMapper;
    private final Validator validator;

    public ProductDTO getProductDTOById(Integer productId) {
        Product product = getProductById(productId);

        return ProductDTO.builder()
                         .productId(product.getProductId())
                         .name(product.getName())
                         .price(product.getPrice())
                         .clientId(product.getClient().getClientId())
                         .build();
    }

    public Product getProductById(Integer productId) {
        Optional<Product> productOptional = productRepository.findById(productId);
        return productOptional.orElseThrow(() -> new EntityNotFoundException("O produto não foi encontrado!"));
    }

    public List<ProductDTO> getAllProducts() {
        List<Product> allProducts = productRepository.findAll();

        return allProducts.stream().map(product ->
                ProductDTO.builder()
                          .productId(product.getProductId())
                          .name(product.getName())
                          .price(product.getPrice())
                          .clientId(product.getClient().getClientId())
                          .build()
        ).collect(Collectors.toList());
    }

    public ProductDTO createProduct(ProductDTO productDTO) {
        boolean productAlreadyExists = productRepository
                .existsProductByNameIgnoreCaseAndPriceAndClient_ClientId(productDTO.getName(),
                                                                         productDTO.getPrice(),
                                                                         productDTO.getClientId());

        if (productAlreadyExists) {
            throw new EntityExistsException("Esse produto já existe com esse mesmo preço e já está vinculado com esse cliente!");
        }

        Client client = clientService.getClientById(productDTO.getClientId());
        Product mappedEntity = productMapper.mapFromDtoToEntity(productDTO, client);
        Product newProduct = productRepository.save(mappedEntity);

        productDTO.setProductId(newProduct.getProductId());
        productDTO.setName(newProduct.getName());
        productDTO.setPrice(newProduct.getPrice());
        productDTO.setClientId(newProduct.getClient().getClientId());

        return productDTO;
    }

    public ProductDTO updateProduct(Integer productId, ProductDTO productDTO) {
        Product product = getProductById(productId);

        if (!allAttributesAreNull(productDTO)) {
            Client client = clientService.getClientById(productDTO.getClientId());
            productMapper.updateEntity(productDTO, product, client);
        }

        Product updatedProduct = productRepository.save(product);

        return ProductDTO.builder()
                         .productId(updatedProduct.getProductId())
                         .name(updatedProduct.getName())
                         .price(updatedProduct.getPrice())
                         .clientId(updatedProduct.getClient().getClientId())
                         .build();
    }

    private boolean allAttributesAreNull(ProductDTO productDTO) {
        Set<ConstraintViolation<ProductDTO>> violations =
                validator.validate(productDTO, AllAttributesNullCheckGroup.class);

        return violations.size() == 3;
    }

    public void deleteProduct(Integer productId) {
        Product product = getProductById(productId);
        productRepository.delete(product);
    }
}
