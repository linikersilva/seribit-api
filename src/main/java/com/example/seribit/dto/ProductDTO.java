package com.example.seribit.dto;

import com.example.seribit.dto.javaxgroups.AllAttributesNullCheckGroup;
import com.example.seribit.dto.javaxgroups.CreateGroup;
import com.example.seribit.dto.javaxgroups.UpdateGroup;
import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class ProductDTO {

    private Integer productId;

    @NotEmpty(message = "O campo name não pode ser vazio ou nulo.", groups = {CreateGroup.class, AllAttributesNullCheckGroup.class})
    @Size(max = 50, message = "O campo name não pode ter mais que 50 caracteres.", groups = {CreateGroup.class, UpdateGroup.class})
    private String name;

    @NotNull(message = "O campo price não pode ser nulo.", groups = {CreateGroup.class, AllAttributesNullCheckGroup.class})
    @DecimalMin(value = "0.0", inclusive = false, message = "O campo price deve ser maior que zero.", groups = {CreateGroup.class, UpdateGroup.class})
    @Digits(integer=7, fraction=2, message = "O campo price deve ter no máximo 7 dígitos antes da vírgula e 2 dígitos depois dela.", groups = {CreateGroup.class, UpdateGroup.class})
    private BigDecimal price;

    @NotNull(message = "O campo clientId não pode ser nulo.", groups = {CreateGroup.class, AllAttributesNullCheckGroup.class})
    private Integer clientId;
}
