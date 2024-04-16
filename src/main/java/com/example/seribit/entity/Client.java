package com.example.seribit.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "cliente")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer clientId;

    @Column(name = "nome", length = 50, nullable = false)
    private String name;

    @Column(name = "email", length = 50, nullable = false, unique = true)
    private String email;

    @Column(name = "cpf_cnpj", length = 14, nullable = false, unique = true)
    private String cpfCnpj;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_fk")
    private Address address;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "telefone_fk")
    private Phone phone;
}
