package com.example.seribit.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "telefone")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer phoneId;

    @Column(name = "ddd", length = 2, nullable = false)
    private String ddd;

    @Column(name = "telefone", length = 9, nullable = false)
    private String phone;
}
