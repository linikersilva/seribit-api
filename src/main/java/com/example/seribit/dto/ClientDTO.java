package com.example.seribit.dto;

import com.example.seribit.dto.javaxgroups.AllAttributesNullCheckGroup;
import com.example.seribit.dto.javaxgroups.CreateGroup;
import com.example.seribit.dto.javaxgroups.UpdateGroup;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class ClientDTO {

    @NotEmpty(message = "O campo name não pode ser vazio ou nulo.", groups = {CreateGroup.class, AllAttributesNullCheckGroup.class})
    @Size(max = 50, message = "O campo name não pode ter mais que 50 caracteres.", groups = {CreateGroup.class, UpdateGroup.class})
    private String name;

    @NotEmpty(message = "O campo email não pode ser vazio ou nulo.", groups = {CreateGroup.class, AllAttributesNullCheckGroup.class})
    @Size(max = 50, message = "O campo email não pode ter mais que 50 caracteres.", groups = {CreateGroup.class, UpdateGroup.class})
    private String email;

    @NotEmpty(message = "O campo cpfCnpj não pode ser vazio ou nulo.", groups = {CreateGroup.class, AllAttributesNullCheckGroup.class})
    @Size(max = 14, message = "O campo cpfCnpj não pode ter mais que 14 caracteres.", groups = {CreateGroup.class, UpdateGroup.class})
    private String cpfCnpj;

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

    private String complement;

    @NotEmpty(message = "O campo ddd não pode ser vazio ou nulo.", groups = {CreateGroup.class, AllAttributesNullCheckGroup.class})
    @Size(max = 2, message = "O campo ddd não pode ter mais que 2 caracteres.", groups = {CreateGroup.class, UpdateGroup.class})
    private String ddd;

    @NotEmpty(message = "O campo phone não pode ser vazio ou nulo.", groups = {CreateGroup.class, AllAttributesNullCheckGroup.class})
    @Size(max = 9, message = "O campo phone não pode ter mais que 9 caracteres.", groups = {CreateGroup.class, UpdateGroup.class})
    private String phone;
}
