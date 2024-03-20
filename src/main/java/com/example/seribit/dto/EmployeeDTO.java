package com.example.seribit.dto;

import com.example.seribit.dto.javaxgroups.AllAttributesNullCheckGroup;
import com.example.seribit.dto.javaxgroups.CreateGroup;
import com.example.seribit.dto.javaxgroups.UpdateGroup;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@RequiredArgsConstructor
@Getter
@Setter
public class EmployeeDTO {

    @NotEmpty(message = "O campo name não pode ser vazio ou nulo.", groups = {CreateGroup.class, AllAttributesNullCheckGroup.class})
    @Size(max = 50, message = "O campo name não pode ter mais que 50 caracteres.", groups = {CreateGroup.class, UpdateGroup.class})
    private String name;

    @NotEmpty(message = "O campo email não pode ser vazio ou nulo.", groups = {CreateGroup.class, AllAttributesNullCheckGroup.class})
    @Size(max = 50, message = "O campo email não pode ter mais que 50 caracteres.", groups = {CreateGroup.class, UpdateGroup.class})
    private String email;

    @NotEmpty(message = "O campo cpf não pode ser vazio ou nulo.", groups = {CreateGroup.class, AllAttributesNullCheckGroup.class})
    @Size(max = 11, message = "O campo cpf não pode ter mais que 11 caracteres.", groups = {CreateGroup.class, UpdateGroup.class})
    private String cpf;

    @NotEmpty(message = "O campo user não pode ser vazio ou nulo.", groups = {CreateGroup.class, AllAttributesNullCheckGroup.class})
    @Size(min = 10, max = 10, message = "O campo user deve ter 10 caracteres.", groups = {CreateGroup.class, UpdateGroup.class})
    private String user;

    @NotEmpty(message = "O campo password não pode ser vazio ou nulo.", groups = {CreateGroup.class, AllAttributesNullCheckGroup.class})
    @Size(max = 15, message = "O campo password não pode ter mais que 15 caracteres.", groups = {CreateGroup.class, UpdateGroup.class})
    private String password;

    @NotNull(message = "O campo salary não pode ser nulo.", groups = {CreateGroup.class, AllAttributesNullCheckGroup.class})
    @DecimalMin(value = "0.0", inclusive = false, message = "O campo salary deve ser maior que zero.", groups = {CreateGroup.class, UpdateGroup.class})
    @Digits(integer=6, fraction=2, message = "O campo salary deve ter no máximo 6 dígitos antes da vírgula e 2 dígitos depois dela.", groups = {CreateGroup.class, UpdateGroup.class})
    private BigDecimal salary;

    @NotEmpty(message = "O campo street não pode ser vazio ou nulo.", groups = {CreateGroup.class, AllAttributesNullCheckGroup.class})
    @Size(max = 30, message = "O campo street não pode ter mais que 30 caracteres.", groups = {CreateGroup.class, UpdateGroup.class})
    private String street;

    @NotEmpty(message = "O campo number não pode ser vazio ou nulo.", groups = {CreateGroup.class, AllAttributesNullCheckGroup.class})
    @Size(max = 10, message = "O campo number não pode ter mais que 10 caracteres.", groups = {CreateGroup.class, UpdateGroup.class})
    private String number;

    @NotEmpty(message = "O campo neighborhood não pode ser vazio ou nulo.", groups = {CreateGroup.class, AllAttributesNullCheckGroup.class})
    @Size(max = 30, message = "O campo neighborhood não pode ter mais que 30 caracteres.", groups = {CreateGroup.class, UpdateGroup.class})
    private String neighborhood;

    @NotEmpty(message = "O campo state não pode ser vazio ou nulo.", groups = {CreateGroup.class, AllAttributesNullCheckGroup.class})
    @Size(max = 2, message = "O campo state não pode ter mais que 2 caracteres.", groups = {CreateGroup.class, UpdateGroup.class})
    private String state;

    @NotEmpty(message = "O campo cep não pode ser vazio ou nulo.", groups = {CreateGroup.class, AllAttributesNullCheckGroup.class})
    @Size(max = 8, message = "O campo cep não pode ter mais que 8 caracteres.", groups = {CreateGroup.class, UpdateGroup.class})
    private String cep;

    @Size(max = 30, message = "O campo complement não pode ter mais que 30 caracteres.", groups = {CreateGroup.class, UpdateGroup.class})
    private String complement;

    @NotEmpty(message = "O campo ddd não pode ser vazio ou nulo.", groups = {CreateGroup.class, AllAttributesNullCheckGroup.class})
    @Size(max = 2, message = "O campo ddd não pode ter mais que 2 caracteres.", groups = {CreateGroup.class, UpdateGroup.class})
    private String ddd;

    @NotEmpty(message = "O campo phone não pode ser vazio ou nulo.", groups = {CreateGroup.class, AllAttributesNullCheckGroup.class})
    @Size(max = 9, message = "O campo phone não pode ter mais que 9 caracteres.", groups = {CreateGroup.class, UpdateGroup.class})
    private String phone;
}
