package com.example.seribit.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "vale")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class Voucher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer voucherId;

    @Column(name = "data_de_criacao", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "total", nullable = false)
    private BigDecimal total;

    @Column(name = "quantidade", nullable = false)
    private Integer quantity;

    @OneToOne
    @JoinColumn(name = "produto_fk")
    private Product product;
}
