package com.example.seribit.repository;

import com.example.seribit.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    boolean existsProductByNameIgnoreCaseAndPriceAndClient_ClientId(String name, BigDecimal price, Integer clientId);
}
