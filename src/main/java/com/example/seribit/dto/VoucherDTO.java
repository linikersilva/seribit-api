package com.example.seribit.dto;

import com.example.seribit.dto.javaxgroups.AllAttributesNullCheckGroup;
import com.example.seribit.dto.javaxgroups.CreateGroup;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class VoucherDTO {

    private Integer voucherId;

    private LocalDateTime createdAt;

    private BigDecimal total;

    @NotNull(message = "O campo quantity não pode ser nulo.", groups = {CreateGroup.class, AllAttributesNullCheckGroup.class})
    private Integer quantity;

    @NotNull(message = "O campo productId não pode ser nulo.", groups = {CreateGroup.class, AllAttributesNullCheckGroup.class})
    private Integer productId;
}
