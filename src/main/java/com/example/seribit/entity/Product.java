package com.example.seribit.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "produto")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer productId;

    @Column(name = "nome", length = 30, nullable = false)
    private String name;

    @Column(name = "preco", nullable = false)
    private BigDecimal price;

    @OneToOne
    @JoinColumn(name = "cliente_fk")
    private Client client;
}
