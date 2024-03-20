package com.example.seribit.controller;

import com.example.seribit.dto.ProductDTO;
import com.example.seribit.dto.javaxgroups.CreateGroup;
import com.example.seribit.dto.javaxgroups.UpdateGroup;
import com.example.seribit.entity.Product;
import com.example.seribit.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/seribit-api/products")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/{productId}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Integer productId) {
        return ResponseEntity.ok().body(productService.getProductDTOById(productId));
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        return ResponseEntity.ok().body(productService.getAllProducts());
    }

    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody
                                                 @Validated(CreateGroup.class)
                                                 ProductDTO productDTO) {
        ProductDTO newProduct = productService.createProduct(productDTO);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newProduct.getProductId())
                .toUri();

        return ResponseEntity.created(uri).body(newProduct);
    }

    @PutMapping("/{productId}")
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable Integer productId,
                                                 @RequestBody
                                                 @Validated(UpdateGroup.class)
                                                 ProductDTO productDTO) {
        return ResponseEntity.ok().body(productService.updateProduct(productId, productDTO));
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Product> deleteProduct(@PathVariable Integer productId) {
        productService.deleteProduct(productId);
        return ResponseEntity.noContent().build();
    }
}
