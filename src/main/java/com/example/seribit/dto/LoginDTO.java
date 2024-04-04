package com.example.seribit.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class LoginDTO {

    @NotEmpty(message = "O campo user não pode ser vazio ou nulo.")
    @Size(min = 10, max = 10, message = "O campo user deve ter 10 caracteres.")
    private String user;

    @NotEmpty(message = "O campo password não pode ser vazio ou nulo.")
    @Size(max = 15, message = "O campo password não pode ter mais que 15 caracteres.")
    private String password;
}
