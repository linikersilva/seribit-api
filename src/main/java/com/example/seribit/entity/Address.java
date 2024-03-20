package com.example.seribit.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "endereco")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer addressId;

    @Column(name = "rua", length = 30, nullable = false)
    private String street;

    @Column(name = "numero", length = 10, nullable = false)
    private String number;

    @Column(name = "bairro", length = 30, nullable = false)
    private String neighborhood;

    @Column(name = "estado", length = 2, nullable = false)
    private String state;

    @Column(name = "cep", length = 8, nullable = false)
    private String cep;

    @Column(name = "complemento", length = 30)
    private String complement;
}
