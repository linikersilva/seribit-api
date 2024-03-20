package com.example.seribit.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "funcionario")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer employeeId;

    @Column(name = "nome", length = 50, nullable = false)
    private String name;

    @Column(name = "email", length = 50, nullable = false, unique = true)
    private String email;

    @Column(name = "cpf", length = 11, nullable = false, unique = true)
    private String cpf;

    @Column(name = "usuario", length = 10, nullable = false, unique = true)
    private String user;

    @Column(name = "senha", length = 15, nullable = false)
    private String password;

    @Column(name = "salario", nullable = false)
    private BigDecimal salary;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_fk")
    private Address address;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "telefone_fk")
    private Phone phone;
}
